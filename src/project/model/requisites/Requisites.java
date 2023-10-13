package project.model.requisites;

public class Requisites {
    private int id;
    private final int OWNER_ID;
    private int taxpayerID;
    private int classifierCode;
    private String nameForPrint;
    private String legalAddress;
    private String mailingAddress;
    private String phone;

    public Requisites(int id, int OWNER_ID, String nameForPrint, int taxpayerID, int classifierCode, String legalAddress, String mailingAddress, String phone) {
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
        return "Requisites{" +
                "id=" + id +
                ", taxpayerID=" + taxpayerID +
                ", classifierCode=" + classifierCode +
                ", nameForPrint='" + nameForPrint + '\'' +
                ", legalAddress='" + legalAddress + '\'' +
                ", mailingAddress='" + mailingAddress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void setTaxpayerID(int taxpayerID) {
        this.taxpayerID = taxpayerID;
    }

    public void setClassifierCode(int classifierCode) {
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

    public int getClassifierCode() {
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