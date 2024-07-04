package com.bechtle_dhbw.uniProjectPasswordGame.rules;

public class MinLengthRule implements Rule {
    private boolean hidden = true;

    @Override
    public String getName() {
        return "r1";
    }

    @Override
    public boolean validate(String password) {
        return password.length() >= 5;
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
