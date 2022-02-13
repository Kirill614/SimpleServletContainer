package context;

import servlet.ServletWrapper;

import java.util.Map;

public class Configuration {
    private Map<String, ServletWrapper> router;

    public Configuration(Map<String, ServletWrapper> router) {
        this.router = router;
    }

    public Map<String, ServletWrapper> getRouter() {
        return router;
    }

    public void setRouter(Map<String, ServletWrapper> router) {
        this.router = router;
    }
}
