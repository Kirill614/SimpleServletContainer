package context;

import handler.HttpHandler;
import lifecycle.LifeCycle;
import processor.MainProcessor;
import servlet.ServletLoader;
import servlet.ServletWrapper;

import java.util.Map;

public class MainContext implements LifeCycle {
    private Configuration configuration;
    private MainProcessor mainProcessor;

    public MainContext(Configuration config) {
        this.configuration = config;
    }

    @Override
    public void init() {
        ServletLoader loader = new ServletLoader(configuration.getRouter());
        ServletContext servletContext = new ServletContext(this.configuration, loader);
        mainProcessor = MainProcessor.Builder.newBuilder()
                .setPort(0)
                .setHandler(HttpHandler.class)
                .setServletContext(servletContext)
                .build();
    }

    @Override
    public void start() {
        new Thread(mainProcessor).start();
    }

    @Override
    public void destroy() {

    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
