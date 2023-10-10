package project.model.requisites;

public class Requisites {
    private final int ID;
    private final int OWNER_ID;
    private String taxpayerID;
    private String classifierCode;
    private String nameForPrint;
    private String legalAddress;
    private String mailingAddress;
    private String phone;

    public Requisites(int OWNER_ID, int ID, String nameForPrint, String taxpayerID, String classifierCode, String legalAddress, String mailingAddress, String phone) {
        this.OWNER_ID = OWNER_ID;
        this.taxpayerID = taxpayerID;
        this.classifierCode = classifierCode;
        this.nameForPrint = nameForPrint;
        this.legalAddress = legalAddress;
        this.mailingAddress = mailingAddress;
        this.phone = phone;
        this.ID = ID;

    }
    public Requisites(int OWNER_ID, int ID) {
        this.OWNER_ID = OWNER_ID;
        this.ID = ID;
    }
    public void setData(int userChoice, String value) {
        switch (userChoice) {
            case 1 -> nameForPrint = value;
            case 2 -> taxpayerID = value;
            case 3 -> classifierCode = value;
            case 4 -> legalAddress = value;
            case 5 -> mailingAddress = value;
            case 6 -> phone = value;
        }

    }

    @Override
    public String toString() {
        return "Requisites{" +
                "NAME='" + nameForPrint + '\'' +
                ", TAXPAYER_ID='" + taxpayerID + '\'' +
                ", CLASSIFIER_CODE='" + classifierCode + '\'' +
                ", legalAddress='" + legalAddress + '\'' +
                ", mailingAddress='" + mailingAddress + '\'' +
                ", phone='" + phone + '\'' +
                "}\n";
    }

    public int getID() {
        return ID;
    }

    public int getOWNER_ID() {
        return OWNER_ID;
    }

    public String getTaxpayerID() {
        return taxpayerID;
    }

    public String getClassifierCode() {
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
