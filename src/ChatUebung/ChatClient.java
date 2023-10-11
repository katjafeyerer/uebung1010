package ChatUebung;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ChatClient {
    private BufferedReader reader;
    private PrintWriter printWriter;
    private ArrayList<ChatClient> clients;
    private Socket client;
    private String name;

    public ChatClient(BufferedReader reader, PrintWriter printWriter, ArrayList<ChatClient> clients, Socket client, String name) {
        this.reader = reader;
        this.printWriter = printWriter;
        this.clients = clients;
        this.client = client;
        this.name = name;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))){



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void sendMessage(String message){

    }
}
