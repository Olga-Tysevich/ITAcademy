package com.example.final_project_java.model.customer;

//import com.example.final_project_java.model.recyclableUnits.RecyclableType;

import java.time.LocalDate;
import java.util.*;

public class Bill {
    private int id;
    private final int CUSTOMER_ID;
    private String number;
    private LocalDate date = LocalDate.of(2023,1,1);
    private int ownerBankAccountId;
    private int customerRequisitesId;
    private int customerBankAccountId;
    private List<String> wayBills = new ArrayList<>();
//    private final Map<RecyclableType, Integer> billData = new TreeMap<>();
    private final int PRICE_NUMBER;
    private double sum = 0;

    public Bill(int CUSTOMER_ID, String number, int PRICE_NUMBER) {
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.number = number;
        this.PRICE_NUMBER = PRICE_NUMBER;
//        for (int i = 0; i < RecyclableType.values().length; i++) {
//            billData.put(RecyclableType.values()[i], 0);
//        }
    }

    public Bill(int id, int CUSTOMER_ID, String number, LocalDate date, int ownerBankAccountId, int customerRequisitesId, int customerBankAccountId,
                List<String> wayBills, int PRICE_NUMBER, double sum) {
        this.id = id;
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.number = number;
        this.date = date;
        this.ownerBankAccountId = ownerBankAccountId;
        this.customerRequisitesId = customerRequisitesId;
        this.customerBankAccountId = customerBankAccountId;
        this.wayBills = wayBills;
        this.PRICE_NUMBER = PRICE_NUMBER;
        this.sum = sum;
    }

    public void addWaybill(WayBill wayBill) {
        wayBills.add(wayBill.getNumber());
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getOwnerBankAccountId() {
        return ownerBankAccountId;
    }

    public void setOwnerBankAccountId(int ownerBankAccountId) {
        this.ownerBankAccountId = ownerBankAccountId;
    }

    public int getCustomerRequisitesId() {
        return customerRequisitesId;
    }

    public void setCustomerRequisitesId(int customerRequisitesId) {
        this.customerRequisitesId = customerRequisitesId;
    }

    public int getCustomerBankAccountId() {
        return customerBankAccountId;
    }

    public void setCustomerBankAccountId(int customerBankAccountId) {
        this.customerBankAccountId = customerBankAccountId;
    }

    public List<String> getWayBills() {
        return wayBills;
    }

    public void setWayBills(List<String> wayBills) {
        this.wayBills = wayBills;
    }

//    public Map<RecyclableType, Integer> getBillData() {
//        return billData;
//    }

    public int getPRICE_NUMBER() {
        return PRICE_NUMBER;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Unique number: " + id +
                "\t Bill number: " + number +
                "\t Bill date: " + date +
                "\t Bill date: sum: " + sum;
    }
}
