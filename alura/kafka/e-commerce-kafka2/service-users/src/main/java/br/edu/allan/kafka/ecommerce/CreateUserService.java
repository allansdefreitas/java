package br.edu.allan.kafka.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class CreateUserService {


    private final Connection connection;

    CreateUserService() throws SQLException {
        String url = "jdbc:sqlite:target/users_database.db";
        this.connection = DriverManager.getConnection(url);

        connection.createStatement().execute("create table Users(" +
                "uuid varchar(200) primary key," +
                "email varchar(200)" +
                ")");
    }


    private final static String TOPIC_ECOMMERCE_NEW_ORDER = "ECOMMERCE_NEW_ORDER";
    private final static String TOPIC_ECOMMERCE_ORDER_REJECTED = "ECOMMERCE_ORDER_REJECTED";
    private final static String TOPIC_ECOMMERCE_ORDER_APROVED = "ECOMMERCE_ORDER_APROVED";

    private final KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();

    public static void main(String[] args) throws SQLException {

        var createUserService = new CreateUserService();

        try (var service = new KafkaService<>(
                CreateUserService.class.getSimpleName(),
                TOPIC_ECOMMERCE_NEW_ORDER,
                createUserService::parse,
                Order.class,
                new HashMap<>())) { //ou Map.of()

            service.run();
        }

    }

    private void parse(ConsumerRecord<String, Order> record) throws SQLException {
        System.out.println("-------------------------------------------");
        System.out.println("processing new order, checking for new user");
        System.out.println("-------------------------------------------");
        System.out.println("value: " + record.value());

        var order = record.value();

        if(isNewUser(order.getEmail())){
            insertNewUser(order.getEmail());

        }


    }

    private void insertNewUser(String email) throws SQLException {
        var insertStatement = connection.prepareStatement("insert into Users(uuid, email)" +
                "values (?, ?)");

        insertStatement.setString(1, "uuid");
        insertStatement.setString(2, email);
        insertStatement.execute();
        System.out.println("User uuid e " + email + "added");

    }

    private boolean isNewUser(String email) throws SQLException {

        var existsStatement = connection.prepareStatement("select uuid from Users " +
                "where email = ? limit 1");
        existsStatement.setString(1, email);

        var results = existsStatement.executeQuery();

        return !results.next();

    }


    private static Properties properties() {

        var properties = new Properties();

        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, CreateUserService.class.getSimpleName());
        properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, CreateUserService.class.getSimpleName() + "-" + UUID.randomUUID().toString());

        return properties;
    }


}
