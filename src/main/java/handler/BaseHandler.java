package handler;

import context.ServletContext;

import javax.servlet.ServletInputStream;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class BaseHandler implements Runnable {
    private ExecutorService executorService = Executors.newFixedThreadPool(3);
    private ServletContext servletContext;

    public BaseHandler(ServletContext servletContext){
        this.servletContext = servletContext;
    }

    public abstract void handleRequest(InputStream input, OutputStream outputStream) throws Exception;

    @Override
    public void run(){
       executorService.execute(new Processor());
    }

    class Processor implements Runnable{
        public void run(){
            InputStream inputStream;
            OutputStream outputStream;
            try {
                inputStream = servletContext.getClientSocket().getInputStream();
                outputStream = servletContext.getClientSocket().getOutputStream();
                handleRequest(inputStream, outputStream);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
