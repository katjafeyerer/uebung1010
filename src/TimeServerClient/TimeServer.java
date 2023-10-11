package TimeServerClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(1111)){

            int number = 0;

            while(number < 5){

                System.out.println("Warte auf Client");
                Socket client = serverSocket.accept();
                number++;
                // Zeit Input wird dem Client geschickt
                Timehandler th = new Timehandler(client);
                th.run();
                System.out.println("Client hat sich verbudnden");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
