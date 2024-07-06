package com.bechtle_dhbw.uniProjectPasswordGame.validation.rules;

import com.bechtle_dhbw.uniProjectPasswordGame.validation.interfaces.Rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContainsSpecialCharacterRule implements Rule {
    private boolean hidden = true;

    @Override
    public String getName() {
        return "r4";
    }

    @Override
    public boolean validate(String password) {
        final String regex = "[-._!\"`'#%&,:;<>=@{}~\\$\\\\(\\)\\*\\+/\\\\\\?\\[\\]\\^\\|]+";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(password);

        return matcher.find();
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
