package project.ui;

import project.model.customer.Bill;
import project.model.recyclableUnits.RecyclableType;

import java.util.List;
import java.util.Map;

public interface BillUI {
    String getBillNumberFromUser();
    int getAction(Bill bill);
    Bill changeBill(Bill bill);
    void displayBillData(Map<RecyclableType, Integer> billData);
    void displayPrice(Map<RecyclableType, Double> price);
    int getBillId(List<Bill> bills);
}
