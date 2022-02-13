package handler;

import context.ServletContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class BaseHandler implements Runnable {
    private ExecutorService executorService = Executors.newFixedThreadPool(3);
    private ServletContext servletContext;

    public BaseHandler(ServletContext servletContext){
        this.servletContext = servletContext;
    }

    public abstract void handleRequest(InputStream input) throws Exception;

    @Override
    public void run(){
       executorService.execute(new Processor());
    }

    class Processor implements Runnable{
        public void run(){
            InputStream inputStream;
            try {
                inputStream = servletContext.getClientSocket().getInputStream();
                handleRequest(inputStream);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
