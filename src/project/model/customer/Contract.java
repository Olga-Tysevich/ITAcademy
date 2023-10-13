package project.model.customer;

import java.util.Date;

public class Contract {
    private int id;
    private final int CUSTOMER_ID;
    private String number;
    private Date startDate;
    private Date endDate;

    public Contract(int id, int CUSTOMER_ID, String number, Date startDate, Date endDate) {
        this.id = id;
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.number = number;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Contract(int customerId, String number) {
        CUSTOMER_ID = customerId;
        this.number = number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "ID=" + id +
                ", contractNumber='" + number + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
