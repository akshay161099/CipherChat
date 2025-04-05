package com.example.Chat.model;

public class Chat {
    private String message;
    private String receiver;
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

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Message_Type getType() {
        return type;
    }

    public void setType(Message_Type type) {
        this.type = type;
    }
}
