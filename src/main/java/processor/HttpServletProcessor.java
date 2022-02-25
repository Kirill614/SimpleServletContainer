package processor;

import context.ServletContext;
import http.HttpRequest;
import http.HttpResponse;
import servlet.ServletLoader;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletProcessor implements Processor{
    private ServletContext context;

    public HttpServletProcessor(ServletContext context){
        this.context = context;
    }

    @Override
    public void process(HttpRequest request, HttpResponse response) {
        try {
            ServletLoader loader = context.getLoader();
            Servlet servlet = loader.loadServlet(request.getPath());
            servlet.service(request, response);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
