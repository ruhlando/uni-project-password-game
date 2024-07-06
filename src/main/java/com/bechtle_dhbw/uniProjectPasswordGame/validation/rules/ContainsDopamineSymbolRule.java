package com.bechtle_dhbw.uniProjectPasswordGame.validation.rules;

import com.bechtle_dhbw.uniProjectPasswordGame.validation.algorithms.BoyerMoore;
import com.bechtle_dhbw.uniProjectPasswordGame.validation.interfaces.Rule;

public class ContainsDopamineSymbolRule implements Rule {
    private boolean hidden = true;

    // Constructor to initialize the BoyerMoore instance with the dopamine pattern
    public ContainsDopamineSymbolRule() {
        String pattern = "C8H11NO2";
    }

    @Override
    public String getName() {
        return "r9";
    }

    @Override
    public boolean validate(String password) {
        //BoyerMoore boyerMoore = new BoyerMoore();
        // Validate if the pattern is found in the password
        return true; //CHANGE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
