import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class Client {
    public static void main(String[] args) {
       try(Socket socket = new Socket("localhost", 55)){
           while(true){

           }
       } catch(Exception e){
           e.printStackTrace();
       };
    }

}
