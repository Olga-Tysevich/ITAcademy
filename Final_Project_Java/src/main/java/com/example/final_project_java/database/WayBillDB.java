package com.example.final_project_java.database;


import com.example.final_project_java.model.customer.WayBill;

import java.util.List;

public interface WayBillDB extends DB<WayBill> {

    WayBill selectByNumber(String number);
    List<WayBill> selectWayBillsWithoutBill(int customerID);
}
