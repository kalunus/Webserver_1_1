import org.eclipse.jetty.server.Server;

/**
 * Created by SBT-Boyko-AP on 11.09.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //Frontend frontend = new Frontend();
        Server server = new Server(8080);
        ServletContextHandler context =
        server.start();
    }
}
