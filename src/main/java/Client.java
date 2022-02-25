import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 55)) {
            String message = "hello server";
            OutputStream out = socket.getOutputStream();
            out.write(message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
    }

}
