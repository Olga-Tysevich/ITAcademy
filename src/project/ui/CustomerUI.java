package project.ui;

import project.model.customer.Customer;
import project.model.recyclableUnits.RecyclableType;

import java.util.List;
import java.util.Map;

public interface CustomerUI {

    void displayCustomer(Customer customer);

    String getCustomerNameFromUser();

    int getUserChoice();

    ContractUI contract();

    WayBillUI wayBill();
    BillUI bill();

    int getCustomerId(List<Customer> customers);
    void displayPrice(Map<RecyclableType, Double> price);

}
