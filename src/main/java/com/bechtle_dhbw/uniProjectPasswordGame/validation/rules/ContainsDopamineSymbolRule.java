package com.bechtle_dhbw.uniProjectPasswordGame.validation.rules;

import com.bechtle_dhbw.uniProjectPasswordGame.validation.algorithms.BoyerMoore;
import com.bechtle_dhbw.uniProjectPasswordGame.validation.interfaces.Rule;

public class ContainsDopamineSymbolRule implements Rule {
    private boolean hidden = true;
    private final BoyerMoore boyerMoore;

    // Constructor to initialize the BoyerMoore instance with the dopamine pattern
    public ContainsDopamineSymbolRule() {
        String pattern = "C8H11NO2";
        this.boyerMoore = new BoyerMoore(pattern);
    }

    @Override
    public String getName() {
        return "r9";
    }

    @Override
    public boolean validate(String password) {
        // Validate if the pattern is found in the password
        return boyerMoore.search(password) != -1;
    }

    @Override
    public boolean isHidden() {
        return hidden;
    }

    @Override
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
