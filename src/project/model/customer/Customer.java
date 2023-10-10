package project.model.customer;

import project.model.Company;
import project.model.recyclableUnits.RecyclableType;
import project.model.requisites.BankAccount;
import project.model.requisites.Requisites;
import java.util.*;

public class Customer extends Company {
    private String name;
    private List<Contract> contracts;
    private List<WayBill> wayBills;
    private List<Bill> bills;
    private List<Payment> payments;
    private SortedMap<RecyclableType, Double> price;

    public Customer(int id, String name) {
        super(id);
        this.name = name;
    }

    public void setPriceValues(RecyclableType type, double price) {
        this.price.put(type, price);
    }

    @SuppressWarnings("unchecked")
    public <E> void addEntry(E entry) {
        if (entry.getClass().equals(Contract.class)) {
            contracts = contracts == null ? new ArrayList<>() : contracts;
            addObjectToList((List<E>) contracts, entry);
        } else if (entry.getClass().equals(WayBill.class)) {
            wayBills = wayBills == null ? new ArrayList<>() : wayBills;
            addObjectToList((List<E>) wayBills, entry);
        } else if (entry.getClass().equals(Bill.class)) {
            bills = bills == null ? new ArrayList<>() : bills;
            addObjectToList((List<E>) bills, entry);
        } else if (entry.getClass().equals(Payment.class)) {
            payments = payments == null ? new ArrayList<>() : payments;
            addObjectToList((List<E>) payments, entry);
        }
    }

    private <E> void addObjectToList(List<E> list, E entry) {
        if (list.contains(entry)) {
            list.set(list.indexOf(entry), entry);
        } else {
            list.add(entry);
        }
    }

    public <E> void removeEntry(E entry) {
        if (entry.getClass().equals(Contract.class) && contracts != null) {
            contracts.remove(entry);
        } else if (entry.getClass().equals(WayBill.class) && wayBills != null) {
            wayBills.remove(entry);
        } else if (entry.getClass().equals(Bill.class) && bills != null) {
            bills.remove(entry);
        } else if (entry.getClass().equals(Payment.class) && payments != null) {
            payments.remove(entry);
        }
    }

    private <E> E getObjectFromList(List<E> list) {
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID='" + super.getID() + '\'' +
                ", name=" + name +
                ", price=" + price +
                "}\n";
    }

    public int getID() {
        return super.getID();
    }

    public String getName() {
        return name;
    }

    public List<Requisites> getRequisitesList() {
        return super.getRequisitesList();
    }

    public List<BankAccount> getBankAccounts() {
        return super.getBankAccounts();
    }

    public List<Contract> getContracts() {

        return contracts == null ? new ArrayList<>() : contracts;
    }

    public List<WayBill> getWayBills() {

        return wayBills == null ? new ArrayList<>() : wayBills;
    }

    public List<Bill> getBills() {
        return bills == null ? new ArrayList<>() : bills;
    }

    public List<Payment> getPayments() {
        return payments == null ? new ArrayList<>() : payments;
    }
}
