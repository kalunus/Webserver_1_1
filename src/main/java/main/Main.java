package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;
import servlets.MirrorRequestsServlet;

/**
 * Created by SBT-Boyko-AP on 11.09.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MirrorRequestsServlet mirrorRequestsServlet = new MirrorRequestsServlet();
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mirrorRequestsServlet), "/mirror");
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}
