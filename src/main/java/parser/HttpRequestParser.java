package parser;

import http.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpRequestParser {
    private InputStream input;

    public HttpRequestParser(InputStream input) {
        this.input = input;
    }

    public String readHttpRequest() throws IOException {
        byte[] bytes = new byte[1000];
        try {
            input.read(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String string = new String(bytes);
        if(!string.isEmpty()) return string;
        return null;
    }

    public HttpRequest parse() throws Exception {
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
