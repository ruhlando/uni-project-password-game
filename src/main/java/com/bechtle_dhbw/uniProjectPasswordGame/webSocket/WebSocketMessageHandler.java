package com.bechtle_dhbw.uniProjectPasswordGame.webSocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketMessageHandler {

    @MessageMapping("/password")
    //@SendTo("/topic/password")
    public String messageHandler(String message) throws Exception {
        System.out.println(message);

        //Call Rules

        return message;
    }
}