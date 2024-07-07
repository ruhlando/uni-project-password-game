package com.bechtle_dhbw.uniProjectPasswordGame.webSocket;

import com.bechtle_dhbw.uniProjectPasswordGame.validation.RuleHandler;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketMessageHandler {
    private final RuleHandler rulesHandler = new RuleHandler();

    @MessageMapping("/password")
    public ArrayNode messageHandler(@Payload Message message) throws Exception {
        System.out.println("Received password: " + message.getPassword());
        ArrayNode result = rulesHandler.validatePassword(message.getPassword());
        System.out.println("Validation result: " + result.toPrettyString());
        return result;
    }

}