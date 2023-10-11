package Guess;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class GuessNumberClient {
    public static void main(String[] args) {
        try(Socket client = new Socket("Localhost", 2222);
            BufferedReader cli = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))){

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);

                if(line.startsWith("Gratulation")){
                    break;
                }
                String input = cli.readLine();
                bw.write(input);
                bw.newLine();
                bw.flush();
            }




        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
