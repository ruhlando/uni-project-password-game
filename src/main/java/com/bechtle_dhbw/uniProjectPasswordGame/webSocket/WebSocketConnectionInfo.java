package com.bechtle_dhbw.uniProjectPasswordGame.webSocket;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

//This class is used to log clients (dis)connect in the console.
//This is used for debugging.
@Component
public class WebSocketConnectionInfo {

    //Client connects
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        System.out.println("Client connected: " + accessor.getSessionId());
    }

    //Client disconnects
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        System.out.println("Client disconnected: " + accessor.getSessionId());
    }
}
