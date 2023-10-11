package PersonClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientCommunication implements Runnable{

    private Socket client;


    public ClientCommunication(Socket client) {
        this.client = client;
    }


    @Override
    public void run() {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            ObjectOutputStream oos = new ObjectOutputStream(new ObjectOutputStream(client.getOutputStream()))) {
            ArrayList<Person> load = new PersonLoader(".\\data\\persons (2).csv").load();

            String line;
            while((line = br.readLine()) != null){

                if(line.startsWith("EXIT")){
                    return;
                }

                else if(line.startsWith("GETALL")){
                    for (Person p: load) {
                        oos.writeObject(p);

                    }
                    oos.writeObject(null);
                    oos.flush();
                }

                else if(line.startsWith("GET")){
                    String[] s = line.split(" ");
                    if(s.length != 2){
                        System.out.println("Fehler in der Eingabe");
                    }
                    String s1 = s[1];
                    int value = Integer.parseInt(s1);
                    for (Person p: load) {
                        if(p.getId() == value){
                            oos.writeObject(p);
                            oos.flush();
                        }
                    }
                }
            }


        } catch (PersonLoadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
