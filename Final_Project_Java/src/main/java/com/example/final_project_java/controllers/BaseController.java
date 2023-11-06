package com.example.final_project_java.controllers;

import com.example.final_project_java.database.BillDB;
import com.example.final_project_java.database.DB;
import com.example.final_project_java.database.WayBillDB;
import com.example.final_project_java.database.impl.*;
import com.example.final_project_java.model.customer.Bill;
import com.example.final_project_java.model.customer.Contract;
import com.example.final_project_java.model.customer.Customer;
import com.example.final_project_java.model.customer.WayBill;
import com.example.final_project_java.model.recyclableUnits.RecyclableUnit;
import com.example.final_project_java.model.requisites.BankAccount;
import com.example.final_project_java.model.requisites.Requisites;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.HashMap;

public abstract class BaseController {
    private final DB<Requisites> requisitesDB = new RequisitesImpl();
    private final DB<BankAccount> bankAccountDB = new BankAccountImpl();
    private final DB<Customer> customerDB = new CustomerImpl();
    private final DB<Contract> contractDB = new ContractImpl();
    private final WayBillDB wayBillDB = new WayBillImpl();
    private final BillDB billDB = new BillImpl();
    private final DB<RecyclableUnit> recyclableUnitDB = new RecyclableUnitImpl();
    private Stage stage;
    private HashMap<String, FXMLLoader> loaders;
    private HashMap<String, Scene> sceneHashMap;

    public void addLoaders(HashMap<String, FXMLLoader> loaders) {
        this.loaders = loaders;
    }

    public FXMLLoader getLoader(String name) {
        return loaders.get(name);
    }

    public void addScenes(HashMap<String, Scene> sceneHashMap) {
        this.sceneHashMap = sceneHashMap;
    }

    public void activateScene(String name) {
        stage.setTitle("Company");
        stage.setScene(sceneHashMap.get(name));
    }

    public void changeRequisites(Requisites requisites) {
        if (requisitesDB.select(requisites.getId()) != null) {
            requisitesDB.update(requisites);
        } else {
            requisitesDB.insert(requisites);
        }
    }

    public void changeBankAccount(BankAccount bankAccount) {
        if (bankAccountDB.select(bankAccount.getId()) != null) {
            bankAccountDB.update(bankAccount);
        } else {
            bankAccountDB.insert(bankAccount);
        }
    }

    public void changeCustomer(Customer customer) {
        if (customerDB.select(customer.getId()) != null) {
            customerDB.update(customer);
        } else {
            customerDB.insert(customer);
        }
    }

    public void changeContract(Contract contract) {
        if (contractDB.select(contract.getId()) != null) {
            contractDB.update(contract);
        } else {
            contractDB.insert(contract);
        }
    }

    public void changeRecyclableUnit(RecyclableUnit recyclableUnit) {
        if (recyclableUnitDB.select(recyclableUnit.getId()) != null) {
            recyclableUnitDB.update(recyclableUnit);
        } else {
            recyclableUnitDB.insert(recyclableUnit);
        }
    }

    public void changeWayBill(WayBill wayBill) {
        if (wayBillDB.select(wayBill.getId()) != null) {
            wayBillDB.update(wayBill);
        } else {
            wayBillDB.insert(wayBill);
        }
    }

    public void changeBill(Bill bill) {
        if (billDB.select(bill.getId()) != null) {
            billDB.update(bill);
        } else {
            billDB.insert(bill);
        }
    }

    public DB<Requisites> getRequisitesDB() {
        return requisitesDB;
    }

    public DB<BankAccount> getBankAccountDB() {
        return bankAccountDB;
    }

    public DB<Customer> getCustomerDB() {
        return customerDB;
    }

    public DB<Contract> getContractDB() {
        return contractDB;
    }

    public WayBillDB getWayBillDB() {
        return wayBillDB;
    }

    public BillDB getBillDB() {
        return billDB;
    }

    public DB<RecyclableUnit> getRecyclableUnitDB() {
        return recyclableUnitDB;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
