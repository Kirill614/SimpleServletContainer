package servlet;

import http.HttpResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import static context.Constants.*;


public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String OUTPUT = "hello client!!!";
            HttpResponse httpResponse = (HttpResponse) response;
            OutputStream outputStream = httpResponse.getSocketOutputStream();
            outputStream.write((OUTPUT_HEADERS + OUTPUT.length() + OUTPUT_END_OF_HEADERS + OUTPUT).getBytes());
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
