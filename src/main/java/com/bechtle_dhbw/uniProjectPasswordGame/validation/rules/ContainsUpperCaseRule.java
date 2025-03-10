package com.bechtle_dhbw.uniProjectPasswordGame.validation.rules;

import com.bechtle_dhbw.uniProjectPasswordGame.validation.interfaces.Rule;

public class ContainsUpperCaseRule implements Rule {
    private boolean hidden = true;

    @Override
    public String getName() {
        return "r3";
    }

    @Override
    public boolean validate(String password) {
        return password.matches(".*[A-Z].*");
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
