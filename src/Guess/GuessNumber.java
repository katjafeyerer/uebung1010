package Guess;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class GuessNumber {
    private Socket client;

    public GuessNumber(Socket client) {
        this.client = client;
    }

    public void generateNumber(){

        try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))){

            int i = new Random().nextInt(32) + 1;
            bw.write("Rate eine Zahl");
            bw.newLine();
            bw.flush();

            String line;
            while((line = br.readLine()) != null){
                try {

                    int value = Integer.parseInt(br.readLine());
                    if(value > 32 || value < 0){
                        bw.write("Bite innerhalb des Scopes wählen");
                    }

                    else if (value > i) {
                        bw.write("Zahl ist zu groß");
                        bw.newLine();
                        bw.flush();
                    } else if (value < i) {
                        bw.write("Zahl ist zu klein");

                    }
                    bw.write("Gratulation. Die Zahl wurde gefunden");
                    bw.newLine();
                    bw.flush();

                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
