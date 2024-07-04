package com.bechtle_dhbw.uniProjectPasswordGame.rules;

public class ContainsRainbowColorRule implements Rule {
    private boolean hidden = true;
    private static final String[] colors = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};

    @Override
    public String getName() {
        return "r11";
    }

    @Override
    public boolean validate(String password) {
        for (String color : colors) {
            if (password.contains(color)) {
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
