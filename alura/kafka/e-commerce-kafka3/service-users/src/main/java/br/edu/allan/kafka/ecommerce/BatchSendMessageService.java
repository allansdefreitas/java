package br.edu.allan.kafka.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BatchSendMessageService {

    private final KafkaDispatcher<User> userDispatcher = new KafkaDispatcher<>();


    private final static String TOPIC_SEND_MESSAGE_TO_ALL_USERS = "SEND_MESSAGE_TO_ALL_USERS";

    private final Connection connection;
    private final static String TOPIC_ECOMMERCE_NEW_ORDER = "ECOMMERCE_NEW_ORDER";
    private final KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();

    BatchSendMessageService() throws SQLException {
        String url = "jdbc:sqlite:target/users_database.db";
        this.connection = DriverManager.getConnection(url);

        connection.createStatement().execute("create table if not exists Users(" +
                "uuid varchar(200) primary key," +
                "email varchar(200)" +
                ")");
    }

    public static void main(String[] args) throws SQLException {

        var batchService = new BatchSendMessageService();

        try (var service = new KafkaService<>(
                BatchSendMessageService.class.getSimpleName(),
                TOPIC_SEND_MESSAGE_TO_ALL_USERS,
                batchService::parse,
                String.class,
                new HashMap<>())) { //ou Map.of()

            service.run();
        }

    }

    private void parse(ConsumerRecord<String, Message<String>> record) throws SQLException, ExecutionException, InterruptedException {

        var message = record.value();

        System.out.println("\n\n-------------------------------------------");
        System.out.println("processing new batch");
        System.out.println("-------------------------------------------");
        System.out.println("Topic: " + message.getPayload());

        for(User user : getAllUsers()){
            userDispatcher.send(message.getPayload(), user.getUuid(), user);
        }

    }

    private List<User> getAllUsers() throws SQLException {

        var results = connection.prepareStatement("select uuid from Users").executeQuery();

        List<User> users = new ArrayList<>();
        while (results.next()){
            User user = new User(results.getString(1));

            users.add(user);
        }
        return users;
    }
}
