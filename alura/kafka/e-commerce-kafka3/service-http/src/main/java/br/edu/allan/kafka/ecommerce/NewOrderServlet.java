package br.edu.allan.kafka.ecommerce;

import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderServlet extends HttpServlet {

    private final static String TOPIC_ECOMMERCE_NEW_ORDER = "ECOMMERCE_NEW_ORDER";
    private final static String TOPIC_ECOMMERCE_SEND_EMAIL = "ECOMMERCE_SEND_EMAIL";

    private final KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();
    private final KafkaDispatcher<Email> emailDispatcher = new KafkaDispatcher<>();

    @Override
    public void destroy() {
        super.destroy();
        orderDispatcher.close();
        emailDispatcher.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            var emailAddress = req.getParameter("email");
            var amount = req.getParameter("amount");

            var orderId = UUID.randomUUID().toString();
            CorrelationId correlationId = new CorrelationId(NewOrderServlet.class.getSimpleName());

            Order order = new Order(orderId, new BigDecimal(amount), emailAddress);
            orderDispatcher.send(TOPIC_ECOMMERCE_NEW_ORDER, emailAddress, correlationId, order);

            var emailSubject = "Hello! We are processing your order!";
            Email email = new Email("Processing order", emailSubject);

            emailDispatcher.send(TOPIC_ECOMMERCE_SEND_EMAIL, emailAddress, correlationId, email);

            String successMessage = "The new order was processed successfully!";
            System.out.println(successMessage);

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("New order sent!");

        } catch (ExecutionException e) {
            throw new ServletException(e);
        } catch (InterruptedException e) {
            throw new ServletException(e);
        }
    }
}

