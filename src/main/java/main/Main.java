package main;

import com.sun.media.jfxmedia.logging.Logger;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.RequestLog;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.log.LoggerLog;
import org.eclipse.jetty.util.log.StdErrLog;
import servlets.AllRequestsServlet;
import servlets.MirrorRequestsServlet;
import sun.rmi.runtime.Log;

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
        //System.out.println("Server started");
        context.getLogger().info("Server started");
        server.join();


        //Logger.logMsg(Logger.INFO,"Server started");

    }
}
