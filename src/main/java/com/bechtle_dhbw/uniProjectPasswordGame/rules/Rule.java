package com.bechtle_dhbw.uniProjectPasswordGame.rules;

public interface Rule {
    String getName();
    boolean validate(String password);
    boolean isHidden();
    void setHidden(boolean hidden);
}
