package com.example.final_project_java.model.requisites;

public class Requisites {
    private int id;
    private final int OWNER_ID;
    private int taxpayerID;
    private long classifierCode;
    private String nameForPrint;
    private String legalAddress;
    private String mailingAddress;
    private String phone;

    public Requisites(int id, int OWNER_ID, int taxpayerID, long classifierCode, String nameForPrint, String legalAddress, String mailingAddress, String phone) {
        this.id = id;
        this.OWNER_ID = OWNER_ID;
        this.taxpayerID = taxpayerID;
        this.classifierCode = classifierCode;
        this.nameForPrint = nameForPrint;
        this.legalAddress = legalAddress;
        this.mailingAddress = mailingAddress;
        this.phone = phone;

    }

    public Requisites(int OWNER_ID) {
        this.OWNER_ID = OWNER_ID;
    }

    @Override
    public String toString() {
        return "Unique number: " + id +
                "\t Taxpayer ID: " + taxpayerID +
                "\t Classifier code: " + classifierCode +
                "\t Name for print: " + nameForPrint +
                "\t Legal address: " + legalAddress +
                "\t Mailing address: " + mailingAddress +
                "\t Phone: " + phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTaxpayerID(int taxpayerID) {
        this.taxpayerID = taxpayerID;
    }

    public void setClassifierCode(long classifierCode) {
        this.classifierCode = classifierCode;
    }

    public void setNameForPrint(String nameForPrint) {
        this.nameForPrint = nameForPrint;
    }

    public void setLegalAddress(String legalAddress) {
        this.legalAddress = legalAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public int getOWNER_ID() {
        return OWNER_ID;
    }

    public int getTaxpayerID() {
        return taxpayerID;
    }

    public long getClassifierCode() {
        return classifierCode;
    }

    public String getNameForPrint() {
        return nameForPrint;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public String getPhone() {
        return phone;
    }
}
