package project.model.customer;

import java.util.Date;
import java.util.Map;

public class Bill {
    private final int ID;
    private final int CUSTOMER_ID;
    private String number;
    private Date date;
    private Map<String, Double> wayBills;
    private double sum;
    private String note;

    public Bill(int ID, int CUSTOMER_ID) {
        this.ID = ID;
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getID() {
        return ID;
    }

    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "ID=" + ID +
                ", CUSTOMER_ID=" + CUSTOMER_ID +
                ", number='" + number + '\'' +
                ", date=" + date +
                ", sum=" + sum +
                ", note='" + note + '\'' +
                '}';
    }
}