package com.bechtle_dhbw.uniProjectPasswordGame.webSocket;

import com.bechtle_dhbw.uniProjectPasswordGame.validation.RuleHandler;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketMessageHandler {
    RuleHandler rulesHandler = new RuleHandler();

    @MessageMapping("/password")
    public ArrayNode messageHandler(Message message) throws Exception {
        System.out.println(message.getPassword());
        return rulesHandler.testValidation(message.getPassword());
    }

}