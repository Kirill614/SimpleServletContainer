
import http.HttpRequest;
import server.HttpServer;

import javax.servlet.*;
import java.io.IOException;

public class Bootstrap {
    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.start();
    }
}
