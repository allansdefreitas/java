package br.edu.allan.ecommerce.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.UUID;

public class FraudDetectorService {
    private final static String TOPIC_ECOMMERCE_NEW_ORDER = "ECOMMERCE_NEW_ORDER";

    public static void main(String[] args) {

        var fraudService = new FraudDetectorService();
        var service = new KafkaService(
                FraudDetectorService.class.getSimpleName(),
                TOPIC_ECOMMERCE_NEW_ORDER,
                fraudService::parse);

        service.run();

    }

    private void parse(ConsumerRecord<String, String> record){
        System.out.println("-------------------------------------------");
        System.out.println("processing new order, checking for fraud");
        System.out.println("-------------------------------------------");
        System.out.println("key: " + record.key());
        System.out.println("value: " + record.value());
        System.out.println("partition: " +record.partition());
        System.out.println("offset: " +record.offset());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Order processed!");
    }



    private static Properties properties() {

        var properties = new Properties();

        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, FraudDetectorService.class.getSimpleName());
        properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, FraudDetectorService.class.getSimpleName() + "-" + UUID.randomUUID().toString());



        return properties;
    }


}
