package com.bechtle_dhbw.uniProjectPasswordGame.validation.rules;

import com.bechtle_dhbw.uniProjectPasswordGame.validation.interfaces.Rule;

public class ContainsSponsorRule implements Rule {
    private boolean hidden = true;
    private static final String[] sponsors = {"Bechtle", "Apple", "DHBW"};

    @Override
    public String getName() {
        return "r8";
    }

    @Override
    public boolean validate(String password) {
        for (String sponsor : sponsors) {
            if (password.contains(sponsor)) {
                return true;
            }
        }
        return false;
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
