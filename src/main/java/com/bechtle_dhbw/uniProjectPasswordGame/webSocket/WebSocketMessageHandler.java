package com.bechtle_dhbw.uniProjectPasswordGame.webSocket;

import com.bechtle_dhbw.uniProjectPasswordGame.rules.Message;
import com.bechtle_dhbw.uniProjectPasswordGame.rules.RuleHandler;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.HandlerMapping;

@Controller
public class WebSocketMessageHandler {
    private final HandlerMapping stompWebSocketHandlerMapping;
    int i = 0;

    RuleHandler ruleshandler = new RuleHandler();

    public WebSocketMessageHandler(@Qualifier("stompWebSocketHandlerMapping") HandlerMapping stompWebSocketHandlerMapping) {
        this.stompWebSocketHandlerMapping = stompWebSocketHandlerMapping;
    }

    @MessageMapping("/password")
    //@SendTo("/topic/password")
    public ArrayNode messageHandler(@RequestBody Message message) throws Exception {
        System.out.println(message.getPassword());
        i++;
        System.out.println(i);
        return ruleshandler.testValidation(message.getPassword());
    }

}