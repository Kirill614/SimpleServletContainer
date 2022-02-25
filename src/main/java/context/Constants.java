package context;

public class Constants {
    public static final String SERVLET_CONFIG_FILE = "servletconfig.json";
    public static final String SERVLET = "servlet";
    public static final String SERVLET_NAME = "name";
    public static final String SERVLET_CLASS = "class";
    public static final String SERVLET_MAPPING = "mapping";
    public static final String OUTPUT_HEADERS = "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html\r\n" + "Content-Length: ";
    public static final String OUTPUT_END_OF_HEADERS = "\r\n\r\n";
    public static final int PORT = 55;
}
