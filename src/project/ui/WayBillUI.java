package project.ui;

import project.model.customer.WayBill;
import java.util.List;
import java.util.Map;

public interface WayBillUI {
    int getAction(WayBill wayBill);
    WayBill changeWayBill(WayBill wayBill);
    String getWayBillNumberFromUser();
    void displayRecyclableUnits(Map<String, Integer> wayBillData);
    String getRecyclableUnitName();
    int getRecyclableUnitAmount();
    int getActionWithRecyclableUnit();
    int getWayBillId(List<WayBill> wayBills);
}
