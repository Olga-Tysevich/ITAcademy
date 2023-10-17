package project.model.customer;

import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

public class WayBill {
    private int id;
    private final int CUSTOMER_ID;
    private String number;
    private Date date;
    private SortedMap<String, Integer> wayBillData = new TreeMap<>();
    private int totalPositions = 0;
    private String note;
    private String billNumber;

    public WayBill(int id, int CUSTOMER_ID, String number, Date date, SortedMap<String, Integer> wayBillData, int totalPositions, String note) {
        this.id = id;
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.number = number;
        this.date = date;
        this.wayBillData = wayBillData;
        this.totalPositions = totalPositions;
        this.note = note;
    }

    public WayBill(int CUSTOMER_ID, String number) {
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.number = number;
    }

    public void addRecyclableUnit(String recyclableUnitName, int amountInWB) {
        wayBillData.put(recyclableUnitName, amountInWB);
        totalPositions += amountInWB;
    }

    public void deleteRecyclableUnit(String recyclableUnitName) {
        wayBillData.remove(recyclableUnitName);
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

    public String getNote() {
        return note;
    }

    public SortedMap<String, Integer> getWayBillData() {
        return wayBillData;
    }

    public void setWayBillData(SortedMap<String, Integer> wayBillData) {
        this.wayBillData = wayBillData;
    }

    public void setTotalPositions(int totalPositions) {
        this.totalPositions = totalPositions;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public void setId(int id) {
        this.id = id;
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
