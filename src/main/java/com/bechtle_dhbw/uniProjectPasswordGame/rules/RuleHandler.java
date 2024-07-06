package com.bechtle_dhbw.uniProjectPasswordGame.rules;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RuleHandler {

    private final List<Rule> rules;

    public RuleHandler() {
        rules = new ArrayList<>();
        rules.add(new MinLengthRule());
        rules.add(new ContainsNumberRule());
        rules.add(new ContainsUpperCaseRule());
        rules.add(new ContainsSpecialCharacterRule());
        rules.add(new DigitsSumTo42Rule());
        rules.add(new ContainsMonthRule());
        rules.add(new ContainsRomanNumeralRule());
        rules.add(new ContainsSponsorRule());
        rules.add(new ContainsDopamineSymbolRule());
        rules.add(new ContainsRomeYearRule());
        rules.add(new ContainsRainbowColorRule());
        rules.add(new ContainsAnimalStartingWithLRule());
    }

    public ArrayNode validatePassword(String password) {
        // Phase 1: Bestimmen, welche Regeln sichtbar gemacht werden sollen
        boolean allPreviousValid = true;

        for (Rule rule : rules) {
            // Wenn eine Regel einmal sichtbar ist, bleibt sie sichtbar
            if (!rule.isHidden()) {
                // Validierung der aktuellen Regel
                allPreviousValid = allPreviousValid && rule.validate(password);
            } else if (allPreviousValid) {
                // Wenn alle vorherigen Regeln gültig sind, machen wir die nächste Regel sichtbar
                rule.setHidden(false);
                // Nach dem Sichtbarmachen einer Regel, brechen wir die Schleife ab
                break;
            } else {
                // Wenn eine vorherige Regel ungültig ist, brechen wir die Schleife ab
                break;
            }
        }

        // Phase 2: Parallel die Regeln validieren und das Ergebnis zurückgeben
        ExecutorService executor = Executors.newFixedThreadPool(rules.size());
        List<Callable<ObjectNode>> tasks = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        for (Rule rule : rules) {
            tasks.add(() -> {
                ObjectNode result = mapper.createObjectNode();
                result.put("name", rule.getName());
                result.put("value", rule.validate(password));
                result.put("hidden", rule.isHidden());
                return result;
            });
        }

        ArrayNode results = mapper.createArrayNode();

        try {
            List<Future<ObjectNode>> futures = executor.invokeAll(tasks);
            for (Future<ObjectNode> future : futures) {
                results.add(future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        return results;
    }

    // Neue Methode zum Testen
    public ArrayNode testValidation(String password) {
        ArrayNode result = validatePassword(password);
        System.out.println(result.toPrettyString()); // Pretty print the JSON array
        return result;
    }
}


