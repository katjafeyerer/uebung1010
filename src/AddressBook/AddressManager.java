package AddressBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressManager {
    private List<Address> addresses = new ArrayList<>();

    public AddressManager() {
        this.addresses = addresses;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
    public void loadFromCsv(String path, String separator) throws AddressLoadException{
        try(BufferedReader br = new BufferedReader(new FileReader(new File(path)))){
            String line;
            while((line = br.readLine()) != null){
                String[] split = line.split(separator);
                Address address = new Address(split[0], split[1], split[2], split[3]);
                addresses.add(address);

            }
            for (Address a: addresses) {
                System.out.println(a);
            }

        } catch (FileNotFoundException e) {
            throw new AddressLoadException("File not found", e);
        } catch (IOException e) {
            throw new AddressLoadException("IO Exception", e);
        }


    }
    public void exportToCsv(String path, String separator) throws AddressExportException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)))){

            for (Address s: addresses) {
                String string = s.getFirstname() + separator + s.getLastname() + separator+
                        s.getEmail() + separator + s.getMobilNumber();
                bw.write(string);
                bw.newLine();
                bw.flush();
            }


        } catch (IOException e) {
            throw new AddressExportException("IO Excpetion", e);
        }


    }
}
