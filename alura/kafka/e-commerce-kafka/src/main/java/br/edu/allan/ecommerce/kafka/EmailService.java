package br.edu.allan.ecommerce.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;

public class EmailService {

    private final static String TOPIC_ECOMMERCE_SEND_EMAIL = "ECOMMERCE_SEND_EMAIL";

    public static void main(String[] args) {

        var emailService = new EmailService();
        try(var service = new KafkaService(
                EmailService.class.getSimpleName(),
                TOPIC_ECOMMERCE_SEND_EMAIL,
                emailService::parse,
                Email.class,
                Map.of())) {

            service.run();
        }
    }

    private void parse(ConsumerRecord<String, Email> record){

        System.out.println("-------------------------------------------");
        System.out.println("Sending e-mail");
        System.out.println(record.key());
        System.out.println(record.value().getSubject());
        System.out.println(record.value().getBody());
        System.out.println(record.partition());
        System.out.println(record.offset());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // ignoring
            e.printStackTrace();
        }
        System.out.println("Email sent");

    }
}
