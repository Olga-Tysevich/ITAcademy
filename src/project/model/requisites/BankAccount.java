package project.model.requisites;

public class BankAccount {
    private final int ID;
    private final int OWNER_ID;
    private String bankName;
    private String accountNumber;
    private String BIC;
    private String bankAddress;

    public BankAccount(int OWNER_ID, int ID, String bankName, String accountNumber, String BIC, String bankAddress) {
        this.ID = ID;
        this.OWNER_ID = OWNER_ID;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.BIC = BIC;
        this.bankAddress = bankAddress;
    }


    public BankAccount(int OWNER_ID, int ID) {
        this.OWNER_ID = OWNER_ID;
        this.ID = ID;
    }

    public void setData(int userChoice, String value) {
        switch (userChoice) {
            case 1 -> bankName = value;
            case 2 -> accountNumber = value;
            case 3 -> BIC = value;
            case 4 -> bankAddress = value;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "ID='" + ID +
                ", bankName=" + bankName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankAddress='" + bankAddress + '\'' +
                ", BIC='" + BIC + '\'' +
                "}\n";
    }

    public int getOWNER_ID() {
        return OWNER_ID;
    }

    public int getID() {
        return ID;
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
