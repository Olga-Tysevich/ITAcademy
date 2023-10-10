package project.model.customer;

import java.util.Date;
import java.util.List;

public class Payment {
    private final int ID;
    private final int CUSTOMER_ID;
    private Date date;
    private List<String> bills;
    private double sum;

    public Payment(int id, int customerId) {
        ID = id;
        CUSTOMER_ID = customerId;
    }

    public int getID() {
        return ID;
    }

    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "ID=" + ID +
                ", CUSTOMER_ID=" + CUSTOMER_ID +
                ", date=" + date +
                ", bills=" + bills +
                ", sum=" + sum +
                '}';
    }
}
