package com.email.model;

public class EmailRequest {
    private String to;
    private String message;
    private String subject;

    public EmailRequest(String message, String from, String subject) {
        this.message = message;
        this.to = to;
        this.subject = subject;
    }

    public EmailRequest() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "from='" + to + '\'' +
                ", message='" + message + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
