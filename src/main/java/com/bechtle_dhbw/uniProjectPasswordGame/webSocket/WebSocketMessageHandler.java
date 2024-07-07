package com.bechtle_dhbw.uniProjectPasswordGame.webSocket;

import com.bechtle_dhbw.uniProjectPasswordGame.validation.RuleHandler;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

//This class is used to process incoming messages over Websocket.
//The client uses the StompJS library to connect/send/receive data from the server.
@Controller
public class WebSocketMessageHandler {
    // initialized Object outside messageHandler for persistent data (store hide value).
    private final RuleHandler rulesHandler = new RuleHandler();

    //Method to handle incoming WebSocket messages with destination "/password"
    //Outgoing messages are send over topic/password.
    //Incoming Json is stored and mapped to the "message" object
    //password is given to the "validatePassword" method of the "rulesHandler" object.
    //The resulting array is returned and serialized into Json by the Jackson dependency.
    //StompJS on the client is used to correctly display valid rules.
    @MessageMapping("/password")
    public ArrayNode messageHandler(@Payload Message message) throws Exception {
        System.out.println("Received password: " + message.getPassword()); //debug
        ArrayNode result = rulesHandler.validatePassword(message.getPassword());
        System.out.println("Validation result: " + result.toPrettyString()); //debug
        return result;
    }

}