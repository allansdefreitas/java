package br.edu.allan.kafka.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

public class LogService {

    private final static String TOPIC_ECOMMERCE_NEW_ORDER = "ECOMMERCE_NEW_ORDER";
    private final static String TOPIC_ECOMMERCE_SEND_EMAIL = "ECOMMERCE_SEND_EMAIL";
    private final static String TOPIC_LOG_SERVICE = "ECOMMERCE_LOG_SERVICE";

    public static void main(String[] args) {

        var logService = new LogService();

        try(var service = new KafkaService(
                LogService.class.getSimpleName(),
                Pattern.compile("ECOMMERCE.*"),
                logService::parse,
                String.class,
                Map.of(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName()))) {

            service.run();
        }
    }


    private void parse(ConsumerRecord<String, String> record){

        System.out.println("-------------------------------------------");
        System.out.println("LOG " + record.topic());
        System.out.println("key: " + record.key());
        System.out.println("value: " + record.value());
        System.out.println("partition: " +record.partition());
        System.out.println("offset: " +record.offset());

    }

}
