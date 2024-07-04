package com.bechtle_dhbw.uniProjectPasswordGame.rules;

public class ContainsRomeYearRule implements Rule{
    private boolean hidden = true;

    @Override
    public String getName() {
        return "r10";
    }

    @Override
    public boolean validate(String password) {
        return password.contains("753");
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
