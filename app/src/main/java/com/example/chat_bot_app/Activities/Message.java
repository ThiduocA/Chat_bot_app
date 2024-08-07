package com.example.chat_bot_app.Activities;

public class Message {
    public static String SENT_BY_ME = "me";
    public static String SENT_BY_BOT = "bot";
    String message, sentBy;

    public Message(String message, String sendBy) {
        this.message = message;
        this.sentBy = sendBy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }
}
