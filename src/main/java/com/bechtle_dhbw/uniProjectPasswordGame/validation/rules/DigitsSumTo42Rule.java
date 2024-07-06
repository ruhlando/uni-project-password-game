package com.bechtle_dhbw.uniProjectPasswordGame.validation.rules;

import com.bechtle_dhbw.uniProjectPasswordGame.validation.interfaces.Rule;

public class DigitsSumTo42Rule implements Rule {
    private boolean hidden = true;

    @Override
    public String getName() {
        return "r5";
    }

    @Override
    public boolean validate(String password) {
        int sum = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }
        return sum == 42;
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
