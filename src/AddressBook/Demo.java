package AddressBook;

public class Demo {
    public static void main(String[] args) throws AddressLoadException, AddressExportException {
       new AddressManager().loadFromCsv(".\\data\\address.csv", ";");

        new AddressManager().exportToCsv(".\\data\\address2.csv", ";");
    }
}
