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

    // List to hold all the rules
    private final List<Rule> rules;

    // Constructor to initialize the rules
    public RuleHandler() {
        rules = new ArrayList<>(); // Using generics to ensure type safety
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

    // Method to validate the password against the rules
    public ArrayNode validatePassword(String password) {
        // Phase 1: Determine which rules to make visible
        boolean allPreviousValid = true;

        for (Rule rule : rules) {
            if (!rule.isHidden()) {
                // Validate current rule if already visible
                allPreviousValid = allPreviousValid && rule.validate(password);
            } else if (allPreviousValid) {
                // Make the next rule visible if all previous rules are valid
                rule.setHidden(false);
                break; // Stop after making one rule visible
            } else {
                // Stop if a previous rule is invalid
                break;
            }
        }

        // Phase 2: Validate rules in *parallel* and return results
        ExecutorService executor = Executors.newFixedThreadPool(rules.size()); // Using ExecutorService for parallelism
        List<Callable<ObjectNode>> tasks = new ArrayList<>(); // Generics used to ensure type safety

        ObjectMapper mapper = new ObjectMapper();

        // Creating tasks for each rule validation
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
            // Executing all tasks in parallel and collecting results
            List<Future<ObjectNode>> futures = executor.invokeAll(tasks); // Using generics to ensure type safety
            for (Future<ObjectNode> future : futures) {
                results.add(future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown(); // Properly shutting down the executor
        }

        return results; // Returning the validation results
    }

    // New method for testing the validation
    public ArrayNode testValidation(String password) {
        ArrayNode result = validatePassword(password);
        System.out.println(result.toPrettyString()); // Pretty print the JSON array
        return result;
    }

}


