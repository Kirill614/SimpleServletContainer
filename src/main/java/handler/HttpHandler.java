package handler;

import context.ServletContext;
import http.HttpRequest;
import http.HttpResponse;
import parser.HttpRequestParser;
import processor.HttpDispatchProcessor;

import java.io.*;

public class HttpHandler extends BaseHandler {
    private ServletContext servletContext;

    public HttpHandler(ServletContext servletContext) {
        super(servletContext);
        this.servletContext = servletContext;
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream) throws Exception {
        HttpRequestParser parser = new HttpRequestParser(inputStream);
        HttpRequest request = parser.parse();
        // System.out.println(request.getHttpVersion() + "   " + request.getMethod() + "   " + request.getPath());
        HttpResponse response = new HttpResponse(outputStream);
        HttpDispatchProcessor processor = new HttpDispatchProcessor(false, servletContext);
        processor.process(request, response);
    }
}
