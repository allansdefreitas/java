package br.edu.allan.kafka.ecommerce;

import java.util.UUID;

public class CorrelationId {

    private final String id;

    CorrelationId(String title){
        this.id = title + "(" + UUID.randomUUID().toString() + ")";
    }

    public CorrelationId continueWith(String title){
        CorrelationId correlationId = new CorrelationId(id + "-" + title);
        return correlationId;
    }

    @Override
    public String toString() {
        return "CorrelationId{" +
                "id='" + id + '\'' +
                '}';
    }
}
