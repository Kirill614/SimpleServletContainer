import server.HttpServer;

import java.util.concurrent.atomic.AtomicInteger;

public class Bootstrap {
    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.start();
    }
}
