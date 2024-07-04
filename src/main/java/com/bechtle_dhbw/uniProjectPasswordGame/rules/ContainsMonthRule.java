package com.bechtle_dhbw.uniProjectPasswordGame.rules;

public class ContainsMonthRule implements Rule{
    private boolean hidden = true;
    private static final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
                                            "September", "October", "November", "December"};

    @Override
    public String getName() {
        return "r6";
    }

    @Override
    public boolean validate(String password) {
        for (String month : months) {
            if (password.contains(month)) {
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
