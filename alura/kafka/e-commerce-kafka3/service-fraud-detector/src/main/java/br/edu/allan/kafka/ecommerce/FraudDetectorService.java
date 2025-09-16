package br.edu.allan.kafka.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class FraudDetectorService {
    private final static String TOPIC_ECOMMERCE_NEW_ORDER = "ECOMMERCE_NEW_ORDER";
    private final static String TOPIC_ECOMMERCE_ORDER_REJECTED = "ECOMMERCE_ORDER_REJECTED";
    private final static String TOPIC_ECOMMERCE_ORDER_APROVED = "ECOMMERCE_ORDER_APROVED";

    private final KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();

    public static void main(String[] args) {

        var fraudService = new FraudDetectorService();

        try(var service = new KafkaService<>(
                FraudDetectorService.class.getSimpleName(),
                TOPIC_ECOMMERCE_NEW_ORDER,
                fraudService::parse,
                Order.class,
                new HashMap<>())) { //ou Map.of()

            service.run();
        }

    }

    private void parse(ConsumerRecord<String, Order> record) throws ExecutionException, InterruptedException {
        System.out.println("-------------------------------------------");
        System.out.println("processing new order, checking for fraud");
        System.out.println("-------------------------------------------");
        System.out.println("key: " + record.key());
        System.out.println("value: " + record.value());
        System.out.println("partition: " +record.partition());
        System.out.println("offset: " +record.offset());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var order = record.value();

        if(isFraud(order)){
            System.out.println("Order is a fraud!!!!" + order);
            orderDispatcher.send(TOPIC_ECOMMERCE_ORDER_REJECTED, order.getEmail(), order);
        }else{
            System.out.println("Aproved: " + order);
            orderDispatcher.send(TOPIC_ECOMMERCE_ORDER_APROVED, order.getEmail(), order);
        }
    }

    private static boolean isFraud(Order order) {
        return order.getAmount().compareTo(new BigDecimal("3000")) >= 0;
    }

}
