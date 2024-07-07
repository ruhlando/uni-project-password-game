package com.bechtle_dhbw.uniProjectPasswordGame.webSocket;

//This class is used to map Json data into a Message object.
//This is done by using the ObjectMapping functionality of the standard Jackson dependency.
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
