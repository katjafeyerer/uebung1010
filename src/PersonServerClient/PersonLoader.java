package PersonServerClient;

import PersonClient.PersonLoadException;

import java.io.*;
import java.util.ArrayList;

public class PersonLoader {
    private String path;

    public PersonLoader(String path) {
        this.path = path;
    }
    public ArrayList<Person> load() throws PersonLoadException {
        ArrayList<Person> list = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(new File(path)))){

            String line;
            while((line = br.readLine()) != null){
                String[] split = line.split(";");
            }


        } catch (FileNotFoundException e) {
            throw new PersonLoadException("File not found", e);
        } catch (IOException e) {
            throw new PersonLoadException("IO Exception", e);
        }


        return list;
    }
}
