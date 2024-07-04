package com.bechtle_dhbw.uniProjectPasswordGame.rules;

public class ContainsRomanNumeralRule implements Rule{
    private boolean hidden = true;
    private static final String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    @Override
    public String getName() {
        return "r7";
    }

    @Override
    public boolean validate(String password) {
        for (String numeral : romanNumerals) {
            if (password.contains(numeral)) {
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
