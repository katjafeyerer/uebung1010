package PersonClient;

public class Demo {
    public static void main(String[] args) throws PersonLoadException {

        new PersonLoader(".\\data\\persons (2).csv").load();


    }
}
