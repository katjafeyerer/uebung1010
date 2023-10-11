package TransactionLoader;

import java.io.*;
import java.util.ArrayList;

public class TransactionLoader {
    public ArrayList<Transaction> loadTransactions(String path){
        ArrayList<Transaction> list = new ArrayList<>();
        File f = new File(path);

        try(BufferedReader br = new BufferedReader(new FileReader(f))){

            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                String[] split = line.split(";");
                Transaction t = new Transaction(split[0], split[1], Double.parseDouble(split[2]), split[3], split[4], split[5], split[6],
                        split[7]);
                list.add(t);
            }




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return list;
    }
}
