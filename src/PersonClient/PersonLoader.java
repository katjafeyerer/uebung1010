package PersonClient;

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
                if(split.length != 3){
                    throw new PersonLoadException("Not enough values at line " + line);
                }
                Person p = new Person(Integer.parseInt(split[0]), split[1], split[2]);
                list.add(p);
            }
            for (Person p : list) {
                System.out.println(p);
            }


        } catch (FileNotFoundException e) {
            throw new PersonLoadException("File not found", e);
        } catch (IOException e) {
            throw new PersonLoadException("IO Exception", e);
        }


        return list;
    }
}
