package TransactionLoader;

import java.util.ArrayList;
import java.util.Collections;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Transaction> transactions = new TransactionLoader().loadTransactions(".\\data\\transactions.csv");
        for (Transaction t: transactions) {
            System.out.println(t);
        }
        System.out.println();
        Collections.sort(transactions, new PriceProductComparator());
        for (Transaction t: transactions) {
            System.out.println(t);
        }
        new TransactionObjectHandler().saveTransactions(transactions, ".\\data\\transactionsCopy.csv");
    }
}
