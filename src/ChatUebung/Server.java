package ChatUebung;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(1234)){

            while(true){
                System.out.println("Warte auf Client");
                Socket client = serverSocket.accept();
                System.out.println("Client hat sich verbunden");

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
