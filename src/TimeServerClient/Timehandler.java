package TimeServerClient;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

public class Timehandler {
    private Socket client;

    public Timehandler(Socket client) {
        this.client = client;
    }

    public void run(){

        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))){

            LocalDateTime dateTime = LocalDateTime.now();
            bw.write(dateTime.toString());
            bw.newLine();
            bw.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
