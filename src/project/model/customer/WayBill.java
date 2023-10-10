package project.model.customer;

import project.model.recyclableUnits.RecyclableType;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;
public class WayBill {
    private final int ID;
    private final int CUSTOMER_ID;
    private String number;
    private Date date;
    private SortedMap<RecyclableType, Double> price;
    private SortedMap<Integer, Integer> wayBillData;
    private int totalNumberOfEntry = 0;
    private double sum;
    private String note;

    public WayBill(int CUSTOMER_ID, int ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.ID = ID;
    }
    public void addRecyclableUnit(int recyclableUnitID, int amountInWB) {
        wayBillData = wayBillData == null ? new TreeMap<>() : wayBillData;
        wayBillData.put(recyclableUnitID, amountInWB);
        totalNumberOfEntry += amountInWB;
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

    public int getID() {
        return ID;
    }

    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public SortedMap<Integer, Integer> getWayBillData() {
        return wayBillData;
    }

    @Override
    public String toString() {
        return "WayBill{" +
                "ID=" + ID +
                ", OWNER_ID=" + CUSTOMER_ID +
                ", number='" + number + '\'' +
                ", date=" + date +
                ", wayBillData=" + wayBillData +
                ", totalNumberOfEntry=" + totalNumberOfEntry +
                ", note='" + note + '\'' +
                '}';
    }
}
