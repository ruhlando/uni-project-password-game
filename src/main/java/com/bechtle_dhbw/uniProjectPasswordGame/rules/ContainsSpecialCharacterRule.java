package com.bechtle_dhbw.uniProjectPasswordGame.rules;

public class ContainsSpecialCharacterRule implements Rule {
    private boolean hidden = true;

    @Override
    public String getName() {
        return "r4";
    }

    @Override
    public boolean validate(String password) {
        return password.matches(".*[!@#$%^&*()].*");
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
