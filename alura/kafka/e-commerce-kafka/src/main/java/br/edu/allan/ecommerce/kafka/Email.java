package br.edu.allan.ecommerce.kafka;

public class Email {

    private final String subject, body;

    public Email(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }
}
