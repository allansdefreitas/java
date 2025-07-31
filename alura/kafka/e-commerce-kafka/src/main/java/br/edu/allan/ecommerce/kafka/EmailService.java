package br.edu.allan.ecommerce.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

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
        var service = new KafkaService(
                EmailService.class.getSimpleName(),
                TOPIC_ECOMMERCE_SEND_EMAIL,
                emailService::parse);

        service.run();
    }
}
