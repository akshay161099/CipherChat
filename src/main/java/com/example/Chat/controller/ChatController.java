package com.example.Chat.controller;

import com.example.Chat.model.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatController
{
    @Autowired
    SimpMessagingTemplate template;
    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public Chat register(@Payload Chat chatMessage, SimpMessageHeaderAccessor headerAccessor,Principal principal) {
        headerAccessor.getSessionAttributes().put("username", principal.getName());
        return chatMessage;
    }

    /*@MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public Chat sendMessage(@Payload Chat chatMessage) {
        return chatMessage;
    }*/
    @MessageMapping("/chat")
    public void broadCast(Chat chat) {
        template.convertAndSend("/topic/public",chat.getMessage());
    }

    @MessageMapping("/private")
    public void sendToUser (Chat chat, Principal principal) {
        template.convertAndSendToUser(chat.getReceiver(),"/queue/private",chat);
    }
}
