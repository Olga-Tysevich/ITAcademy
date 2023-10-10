package project.model.customer;

import reconsider.ContractStatus;
import java.util.Date;

public class Contract {
    private final int ID;
    private final int CUSTOMER_ID;
    private String number;
    private Date startDate;
    private Date endDate;

    public Contract(int CUSTOMER_ID, int ID) {
        this.ID = ID;
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public int getID() {
        return ID;
    }

    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "ID=" + ID +
                ", contractNumber='" + number + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
