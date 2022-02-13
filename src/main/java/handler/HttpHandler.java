package handler;

import context.ServletContext;

import java.io.*;

public class HttpHandler extends BaseHandler{

    public HttpHandler(ServletContext servletContext){
        super(servletContext);
    }

    @Override
    public void handleRequest(InputStream inputStream) throws IOException {
        System.out.println("handle");
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder strBuilder = new StringBuilder();
        String string;
        while((string = in.readLine()) != null){
            strBuilder.append(string);
        }
        String requestString = strBuilder.toString();
    }
}
