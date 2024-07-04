package com.bechtle_dhbw.uniProjectPasswordGame.rules;

public class Message {
    private String password;
    Message(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
