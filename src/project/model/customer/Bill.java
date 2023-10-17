package project.model.customer;

import project.model.recyclableUnits.RecyclableType;

import java.util.*;
import java.util.stream.IntStream;

public class Bill {
    private int id;
    private final int CUSTOMER_ID;
    private String number;
    private Date date;
    private List<String> wayBills = new ArrayList<>();
    private final Map<RecyclableType, Integer> billData = new TreeMap<>();
    private final Map<RecyclableType, Double> price;
    private double sum;
    private String note;

    public Bill(int CUSTOMER_ID, String number, Map<RecyclableType, Double> price) {
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.number = number;
        this.price = price;
        IntStream.range(0, RecyclableType.values().length).forEach(i -> billData.put(RecyclableType.values()[i], 0));
    }

    public Bill(int id, int CUSTOMER_ID, String number, Date date, List<String> wayBills, Map<RecyclableType, Double> price, double sum, String note) {
        this.id = id;
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.number = number;
        this.date = date;
        this.wayBills = wayBills;
        this.price = price;
        this.sum = sum;
        this.note = note;
    }

    public void addWayBill(String wayBillNumber, Map<RecyclableType, Integer> billData) {
        wayBills.add(wayBillNumber);
        billData.forEach((k, v) -> this.billData.put(k, v + this.billData.get(k)));
        billData.forEach((k, v) -> sum = price.get(k) * v);
    }

    public int getId() {
        return id;
    }

    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getWayBills() {
        return wayBills;
    }

    public Map<RecyclableType, Integer> getBillData() {
        return billData;
    }

    public Map<RecyclableType, Double> getPrice() {
        return price;
    }

    public void setWayBills(List<String> wayBills) {
        this.wayBills = wayBills;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "ID=" + id +
                ", CUSTOMER_ID=" + CUSTOMER_ID +
                ", number='" + number + '\'' +
                ", date=" + date +
                ", sum=" + sum +
                ", note='" + note + '\'' +
                '}';
    }
}
