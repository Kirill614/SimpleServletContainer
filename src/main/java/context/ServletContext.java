package context;

import servlet.ServletLoader;

import java.net.Socket;

public class ServletContext {
    private Configuration configuration;
    private Socket clientSocket;
    private ServletLoader loader;

    public ServletContext(Configuration configuration, ServletLoader loader){
        this.configuration = configuration;
        this.loader = loader;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public ServletLoader getLoader() {
        return loader;
    }

    public void setLoader(ServletLoader loader) {
        this.loader = loader;
    }
}
