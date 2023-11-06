package com.example.final_project_java.model.customer;

import java.time.LocalDate;

public class Contract {
    private int id;
    private final int CUSTOMER_ID;
    private String number;
    private LocalDate startDate = LocalDate.of(2023, 1, 1);
    private LocalDate endDate = LocalDate.of(2023, 1, 1);

    public Contract(int id, int CUSTOMER_ID, String number, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.number = number;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Contract(int customerId) {
        CUSTOMER_ID = customerId;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Unique number: " + id +
                "\t Contract number: " + number +
                "\t Start date: " + startDate +
                "\t End date: " + endDate;
    }
}
