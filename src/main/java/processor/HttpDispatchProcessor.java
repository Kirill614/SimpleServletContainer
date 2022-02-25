package processor;

import context.ServletContext;
import http.HttpRequest;
import http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpDispatchProcessor implements Processor{
    private boolean isStatic = false;
    private ServletContext servletContext;

    public HttpDispatchProcessor(boolean isStatic, ServletContext servletContext){
        this.isStatic = isStatic;
        this.servletContext = servletContext;
    }

    @Override
    public void process(HttpRequest request, HttpResponse response) {
        Processor processor;
        if(isStatic){
            //
        } else {
            processor = new HttpServletProcessor(servletContext);
            processor.process(request, response);
        }
    }
}
