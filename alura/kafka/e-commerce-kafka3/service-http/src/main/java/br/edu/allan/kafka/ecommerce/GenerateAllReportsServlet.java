package br.edu.allan.kafka.ecommerce;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class GenerateAllReportsServlet extends HttpServlet {

    private final static String TOPIC_USER_GENERATE_READING_REPORT = "USER_GENERATE_READING_REPORT";
    private final static String TOPIC_SEND_MESSAGE_TO_ALL_USERS = "SEND_MESSAGE_TO_ALL_USERS";

    private final KafkaDispatcher<String> batchDispatcher = new KafkaDispatcher<>();

    @Override
    public void destroy() {
        super.destroy();
        batchDispatcher.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            batchDispatcher.send(TOPIC_SEND_MESSAGE_TO_ALL_USERS, TOPIC_USER_GENERATE_READING_REPORT, TOPIC_USER_GENERATE_READING_REPORT);

            String successMessage = "Sent generate reporsts to all users!";
            System.out.println(successMessage);

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("Report requests generated");

        } catch (ExecutionException e) {
            throw new ServletException(e);
        } catch (InterruptedException e) {
            throw new ServletException(e);
        }
    }
}

