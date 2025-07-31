package br.edu.allan.ecommerce.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class EmailService {

    private final static String TOPIC_ECOMMERCE_SEND_EMAIL = "ECOMMERCE_SEND_EMAIL";


    private void parse(ConsumerRecord<String, String> record){

        System.out.println("-------------------------------------------");
        System.out.println("Sending e-mail");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());

    }

    public static void main(String[] args) {

        var emailService = new EmailService();
        try(var service = new KafkaService(
                EmailService.class.getSimpleName(),
                TOPIC_ECOMMERCE_SEND_EMAIL,
                emailService::parse)) {

            service.run();
        }
    }
}
