package com.example.final_project_java.database;

import com.example.final_project_java.model.customer.Bill;
import com.example.final_project_java.model.recyclableUnits.RecyclableType;

import java.util.Map;

public interface BillDB extends DB<Bill>{
    Bill selectByNumber(String name);
    Map<RecyclableType, Double> selectPrice(int priceNumber);
}
