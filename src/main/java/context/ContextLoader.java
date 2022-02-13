package context;

import parser.ServletConfigParser;
import server.HttpServer;
import servlet.ServletWrapper;

import java.io.*;
import java.util.Map;

public class ContextLoader {

    private Map<String, ServletWrapper> router;
    private HttpServer httpServer;

    public ContextLoader(HttpServer httpServer) {
        this.httpServer = httpServer;
    }

    private void loadServletConfig() throws Exception {
        File file = new File(Constants.SERVLET_CONFIG_FILE);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String nextString;
        StringBuilder strBuilder = new StringBuilder();
        while ((nextString = reader.readLine()) != null) {
            strBuilder.append(nextString);
        }
        String configString = strBuilder.toString();
        ServletConfigParser parser = new ServletConfigParser();
        router = parser.parseConfig(configString);
    }

    public void loadContext() throws Exception {
        loadServletConfig();
        MainContext context = new MainContext(new Configuration(router));
        httpServer.addContext(context);
    }

    public Map<String, ServletWrapper> getRouter() {
        return router;
    }

}
