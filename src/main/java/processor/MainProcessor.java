package processor;

import context.ServletContext;
import handler.BaseHandler;
import handler.HttpHandler;

import java.lang.reflect.Constructor;
import java.net.ServerSocket;
import java.net.Socket;

import static context.Constants.*;

public class MainProcessor implements Runnable {
    private int port;
    private Class<? extends BaseHandler> handlerClass;
    private ServletContext servletContext;
    private Socket clientSocket;

    public MainProcessor(int port, Class<? extends BaseHandler> handlerClass, ServletContext servletContext) {
        this.port = port;
        this.handlerClass = handlerClass;
        this.servletContext = servletContext;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                 clientSocket = serverSocket.accept();
                //System.out.println("connected");
                startClientHandler();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startClientHandler() throws Exception{
        Constructor<? extends BaseHandler> handlerConstructor = handlerClass.getConstructor(ServletContext.class);
        servletContext.setClientSocket(clientSocket);
        BaseHandler clientHandler = handlerConstructor.newInstance(servletContext);
        new Thread(clientHandler).start();
    }

    public static class Builder {
        private int port;
        private Class<? extends BaseHandler> handlerClass;
        private ServletContext servletContext;

        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

        public Builder setServletContext(ServletContext context) {
            this.servletContext = context;
            return this;
        }

        public Builder setHandler(Class<? extends BaseHandler> handlerClass) {
            this.handlerClass = handlerClass;
            return this;
        }

        public static Builder newBuilder() {
            return new MainProcessor.Builder();
        }

        public MainProcessor build() {
            return new MainProcessor(this.port, this.handlerClass, this.servletContext);
        }
    }
}
