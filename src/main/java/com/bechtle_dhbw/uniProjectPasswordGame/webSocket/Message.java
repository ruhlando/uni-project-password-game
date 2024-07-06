package com.bechtle_dhbw.uniProjectPasswordGame.webSocket;

public class Message {
    private String password;

    Message(){
    }

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
