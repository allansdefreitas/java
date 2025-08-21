package br.edu.allan.kafka.ecommerce;


import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.math.BigDecimal;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    private final static String TOPIC_ECOMMERCE_NEW_ORDER = "ECOMMERCE_NEW_ORDER";
    private final static String TOPIC_ECOMMERCE_SEND_EMAIL = "ECOMMERCE_SEND_EMAIL";

    private final static int QUANTIDADE_ORDERS_ENVIAR = 10;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        try (var orderDispatcher = new KafkaDispatcher<Order>()) {
            try (var emailDispatcher = new KafkaDispatcher<Email>()) {

                for (int i = 0; i < QUANTIDADE_ORDERS_ENVIAR; i++) {

                    var userId = UUID.randomUUID().toString();
                    var orderId = UUID.randomUUID().toString();
                    var amount = BigDecimal.valueOf(Math.random() * 5000 + 1);

                    Order order = new Order(userId, orderId, amount);

                    orderDispatcher.send(TOPIC_ECOMMERCE_NEW_ORDER, userId, order);

                    var emailSubject = "Hello! We are processing your order!";
                    Email email = new Email("Processing order", emailSubject);

                    emailDispatcher.send(TOPIC_ECOMMERCE_SEND_EMAIL, userId, email);
                }
            }
        }
    }
}