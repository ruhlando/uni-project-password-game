package com.bechtle_dhbw.uniProjectPasswordGame.validation.rules;

import com.bechtle_dhbw.uniProjectPasswordGame.validation.interfaces.Rule;

public class ContainsAnimalStartingWithLRule implements Rule {
    private boolean hidden = true;
    private static final String[] animals = {"Lion", "Leopard", "Llama", "Lynx", "Lobster"};

    @Override
    public String getName() {
        return "r12";
    }

    @Override
    public boolean validate(String password) {
        for (String animal : animals) {
            if (password.toLowerCase().contains(animal.toLowerCase())) {
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
