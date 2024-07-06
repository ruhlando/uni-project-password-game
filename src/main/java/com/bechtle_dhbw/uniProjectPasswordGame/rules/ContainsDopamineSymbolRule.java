package com.bechtle_dhbw.uniProjectPasswordGame.rules;

public class ContainsDopamineSymbolRule implements Rule {
    private boolean hidden = true;
    private final String pattern = "C8H11NO2";
    private final BoyerMoore boyerMoore;

    // Constructor to initialize the BoyerMoore instance with the dopamine pattern
    public ContainsDopamineSymbolRule() {
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
