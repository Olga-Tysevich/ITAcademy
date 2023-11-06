package com.example.final_project_java.model.requisites;

public class BankAccount {
    private int id;
    private final int OWNER_ID;
    private String bankName;
    private String accountNumber;
    private String BIC;
    private String bankAddress;

    public BankAccount(int id, int OWNER_ID, String bankName, String accountNumber, String BIC, String bankAddress) {
        this.id = id;
        this.OWNER_ID = OWNER_ID;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.BIC = BIC;
        this.bankAddress = bankAddress;
    }

    public BankAccount(int OWNER_ID) {
        this.OWNER_ID = OWNER_ID;
    }

    @Override
    public String toString() {
        return "Bank name: " + bankName +
                "\t Bank account number: " + accountNumber +
                "\t Bank address: " + bankAddress +
                "\t BIC: " + BIC;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public int getOWNER_ID() {
        return OWNER_ID;
    }

    public int getId() {
        return id;
    }

    public String getBankName() {
        return bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBIC() {
        return BIC;
    }

    public String getBankAddress() {
        return bankAddress;
    }
}
