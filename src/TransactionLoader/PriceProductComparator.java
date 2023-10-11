package TransactionLoader;

import java.util.Comparator;

public class PriceProductComparator implements Comparator<Transaction> {

    @Override
    public int compare(Transaction o1, Transaction o2) {
        double result = Double.compare(o1.getPrice(), o2.getPrice());

        if(result == 0){
            return o2.getProduct().compareTo(o1.getProduct());
        }
        return (int) result;
    }
}
