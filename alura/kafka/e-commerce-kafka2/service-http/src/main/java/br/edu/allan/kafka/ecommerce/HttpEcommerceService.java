package br.edu.allan.kafka.ecommerce;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class HttpEcommerceService {


    public static void main(String[] args) throws Exception {

        var server = new Server(8080);


        var context = new ServletContextHandler();
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new NewOrderServlet()), "/new");

        server.start();
        server.join();




    }
}
