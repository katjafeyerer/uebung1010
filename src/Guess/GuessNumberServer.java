package Guess;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GuessNumberServer {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(2222)){
            while(true){
                System.out.println("Warte auf Client");
                Socket client = serverSocket.accept();
                GuessNumber guessNumber = new GuessNumber(client);
                guessNumber.generateNumber();
                System.out.println("Client hat sich verbunden");

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
