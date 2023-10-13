package project.model.customer;

import project.model.recyclableUnits.RecyclableType;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;
public class WayBill {
    private int id;
    private final int CUSTOMER_ID;
    private String number;
    private Date date;
    private SortedMap<RecyclableType, Double> price = new TreeMap<>();
    private SortedMap<Integer, Integer> wayBillData = new TreeMap<>();
    private int totalPositions = 0;
    private double sum;
    private String note;

    public WayBill(int id, int CUSTOMER_ID, String number, Date date, SortedMap<RecyclableType, Double> price, SortedMap<Integer,
            Integer> wayBillData, int totalPositions, double sum, String note) {
        this.id = id;
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.number = number;
        this.date = date;
        this.price = price;
        this.wayBillData = wayBillData;
        this.totalPositions = totalPositions;
        this.sum = sum;
        this.note = note;
    }

    public WayBill(int CUSTOMER_ID, String number) {
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.number = number;
    }
    public void addRecyclableUnit(int recyclableUnitID, int amountInWB) {
        wayBillData.put(recyclableUnitID, amountInWB);
        totalPositions += amountInWB;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void setNote(String note) {
        this.note = note;
    }

    public void setPrice(RecyclableType recyclableType, double unitPrice) {
        price.put(recyclableType, unitPrice);
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

    public Date getDate() {
        return date;
    }

    public int getTotalPositions() {
        return totalPositions;
    }

    public double getSum() {
        return sum;
    }

    public String getNote() {
        return note;
    }

    public SortedMap<RecyclableType, Double> getPrice() {
        return price;
    }

    public SortedMap<Integer, Integer> getWayBillData() {
        return wayBillData;
    }

    @Override
    public String toString() {
        return "WayBill{" +
                "ID=" + id +
                ", OWNER_ID=" + CUSTOMER_ID +
                ", number='" + number + '\'' +
                ", date=" + date +
                ", wayBillData=" + wayBillData +
                ", totalNumberOfEntry=" + totalPositions +
                ", note='" + note + '\'' +
                '}';
    }
}
