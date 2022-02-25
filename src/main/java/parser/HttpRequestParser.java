package parser;

import http.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpRequestParser {
    private InputStream input;

    public HttpRequestParser(InputStream input){
        this.input = input;
    }

    public String readHttpRequest() throws IOException {

//        try(BufferedReader reader = new BufferedReader(new InputStreamReader(input))){
//            StringBuilder strBuilder = new StringBuilder();
//            String string;
//            while ((string = reader.readLine()) != null){
//                strBuilder.append(string);
//            }
//            return strBuilder.toString();
//        } catch(Exception e){
//            e.printStackTrace();
//        }
        StringBuilder strBuilder = null;
        try{
            strBuilder = new StringBuilder();
            int i;
            while((char)(i = input.read()) != '\r'){
                System.out.println((char) i + " " + Thread.currentThread().getName());
                strBuilder.append((char) i);
            }
            return strBuilder.toString();
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public HttpRequest parse() throws Exception{
        String rawRequest = readHttpRequest();

        String[] requestArr = rawRequest.split(" ");

        String method = requestArr[0];
        if (method == null || method.length() == 0) throw new Exception();

        String path = requestArr[1];
        if (path == null || path.length() == 0) throw new Exception();

        String httpVersion = requestArr[2];
        if (httpVersion == null || httpVersion.length() == 0) throw new Exception();

        return new HttpRequest(method, path, httpVersion);
    }
}
