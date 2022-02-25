package processor;

import http.HttpRequest;
import http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Processor {
    void process(HttpRequest request, HttpResponse response);
}
