package com.example.Chat.model;

public class Chat {
    private String message;
    private String sender;
    private Message_Type type;
    public enum Message_Type{
        CHAT,EXIT,JOIN;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Message_Type getType() {
        return type;
    }

    public void setType(Message_Type type) {
        this.type = type;
    }
}
