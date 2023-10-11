package TransactionLoader;

import javax.xml.crypto.dsig.TransformService;
import java.io.*;
import java.util.ArrayList;

public class TransactionObjectHandler {
    public void saveTransactions(ArrayList<Transaction> list, String path){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){

            for (Transaction t: list) {
                oos.writeObject(t);

                oos.flush();
            }
            oos.writeObject(null);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
