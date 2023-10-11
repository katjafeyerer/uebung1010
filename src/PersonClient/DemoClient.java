package PersonClient;

import java.io.IOException;
import java.net.Socket;

public class DemoClient {
    public static void main(String[] args) {
        try(Socket client = new Socket("Localhost", 1234)){





        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
