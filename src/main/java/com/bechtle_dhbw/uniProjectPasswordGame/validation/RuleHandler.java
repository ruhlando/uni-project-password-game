package com.bechtle_dhbw.uniProjectPasswordGame.validation;

import com.bechtle_dhbw.uniProjectPasswordGame.validation.interfaces.Rule;
import com.bechtle_dhbw.uniProjectPasswordGame.validation.rules.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RuleHandler {

    // List to hold all the rules
    private final List<Rule> rules;

    // Constructor to initialize the rules
    public RuleHandler() {
        rules = new ArrayList<>(); // Using *generics* to ensure type safety
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
        System.out.println("Phase 1: Determine which rules to make visible");

        for (Rule rule : rules) {
            System.out.println("Checking rule: " + rule.getName() + ", isHidden: " + rule.isHidden());
            if (!rule.isHidden()) {
                // Validate current rule if already visible
                allPreviousValid = allPreviousValid && rule.validate(password);
                System.out.println("Rule " + rule.getName() + " validation result: " + allPreviousValid);
            } else if (allPreviousValid) {
                // Make the next rule visible if all previous rules are valid
                rule.setHidden(false);
                System.out.println("Making rule " + rule.getName() + " visible");
                break; // Stop after making one rule visible
            } else {
                // Stop if a previous rule is invalid
                System.out.println("Previous rule invalid, stopping visibility changes");
                break;
            }
        }

        // Phase 2: Validate rules in parallel and return results
        System.out.println("Phase 2: Validate rules in parallel");
        ExecutorService executor = Executors.newFixedThreadPool(rules.size()); // Using ExecutorService for parallelism
        List<Future<ObjectNode>> futures = new ArrayList<>(); // List to hold Future objects

        ObjectMapper mapper = new ObjectMapper();

        // Submitting tasks for each rule validation
        for (Rule rule : rules) {
            Future<ObjectNode> future = executor.submit(() -> {
                ObjectNode result = mapper.createObjectNode();
                result.put("name", rule.getName());
                result.put("value", rule.validate(password));
                result.put("hidden", rule.isHidden());
                System.out.println("Rule " + rule.getName() + " validated by thread: " + Thread.currentThread().getName());
                return result;
            });
            futures.add(future);
        }

        ArrayNode results = mapper.createArrayNode();

        try {
            // Collecting results from futures
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

//    // New method for testing the validation
//    public ArrayNode testValidation(String password) {
//        ArrayNode result = validatePassword(password);
//        //System.out.println(result.toPrettyString()); // Pretty print the JSON array
//        return result;
//    }

}


