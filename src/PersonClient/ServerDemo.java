package PersonClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(1234)) {

            while(true){
                System.out.println("Wartet auf Client");
                Socket client = serverSocket.accept();
                System.out.println("Client hat sich verbunden");
                ClientCommunication clientCommunication = new ClientCommunication(client);
                Thread thread = new Thread(clientCommunication);
                thread.start();
                //clientCommunication.run();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
