package com.bechtle_dhbw.uniProjectPasswordGame.rules;

public class ContainsDopamineSmybolRule implements Rule {
    private boolean hidden = true;

    @Override
    public String getName() {
        return "r9";
    }

    @Override
    public boolean validate(String password) {
        return password.contains("C8H11NO2");
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
