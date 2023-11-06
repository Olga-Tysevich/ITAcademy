package com.example.final_project_java.controllers;

import com.example.final_project_java.model.customer.Bill;
import com.example.final_project_java.model.customer.Contract;
import com.example.final_project_java.model.customer.Customer;
import com.example.final_project_java.model.customer.WayBill;
import com.example.final_project_java.model.recyclableUnits.RecyclableUnit;
import com.example.final_project_java.model.requisites.BankAccount;
import com.example.final_project_java.model.requisites.Requisites;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;

import java.util.List;

import static com.example.final_project_java.controllers.Constants.*;

public class ObjectListMenuController<E> extends BaseController {
    private String prevScene;
    private E item;
    @FXML
    private Label name;
    @FXML
    private ListView<E> listView;

    @FXML
    private void createNewBtnClick() {
        checkItemType();
    }

    @FXML
    private void editBtnClick() {
        MultipleSelectionModel<E> selectionModel = listView.getSelectionModel();
        try {
            int itemPosition = selectionModel.getSelectedIndices().get(0);
            item = listView.getItems().get(itemPosition);
            checkItemType();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkItemType(){
        if (item instanceof Requisites) {
            displayRequisites();
        } else if (item instanceof BankAccount) {
            displayBankAccount();
        } else if (item instanceof Customer) {
            displayCustomer();
        } else if (item instanceof Contract) {
            displayContract();
        } else if (item instanceof RecyclableUnit) {
            displayRecyclableUnit();
        } else if (item instanceof WayBill){
            displayWayBill();
        }else if (item instanceof Bill){
            displayBill();
        }
    }

    private void displayRequisites() {
        RequisitesController requisitesController = getLoader(REQUISITES_MENU_LOADER).getController();
        requisitesController.setRequisites((Requisites) item);
        requisitesController.setRequisitesData((Requisites) item);
        activateScene(REQUISITES_SCENE);
    }

    private void displayBankAccount() {
        BankAccountController bankAccountController = getLoader(BANK_ACCOUNT_MENU_LOADER).getController();
        bankAccountController.setBankAccountData((BankAccount) item);
        activateScene(BANK_ACCOUNT_SCENE);
    }

    private void displayCustomer() {
        CustomerController customerController = getLoader(CUSTOMER_LOADER).getController();
        customerController.setCustomerData((Customer) item);
        activateScene(CUSTOMER_SCENE);
    }

    private void displayContract() {
        ContractController contractController = getLoader(CONTRACT_LOADER).getController();
        contractController.setContractData((Contract) item);
        activateScene(CONTRACT_SCENE);
    }

    private void displayRecyclableUnit() {
        RecyclableUnitController recyclableUnitController = getLoader(RECYCLABLE_UNIT_LOADER).getController();
        recyclableUnitController.setRecyclableUnitData((RecyclableUnit) item);
        activateScene(RECYCLABLE_UNIT_SCENE);
    }

    private void displayWayBill() {
        WayBillController wayBillController = getLoader(WAYBILL_LOADER).getController();
        wayBillController.setWayBillData((WayBill) item);
        activateScene(WAYBILL_SCENE);
    }

    private void displayBill() {
        BillController billController = getLoader(BILL_LOADER).getController();
        billController.setBillData((Bill) item);
        activateScene(BILL_SCENE);
    }

    @FXML
    private void cancelBtnClick() {
        activateScene(prevScene);
    }

    public void setList(List<E> list) {
        ObservableList<E> itemsList = FXCollections.observableArrayList(list);
        listView.setItems(itemsList);
    }

    public void setName(String listName) {
        this.name.setText(listName);
    }

    public void setItem(E item) {
        this.item = item;
    }

    public void setPrevScene(String prevScene) {
        this.prevScene = prevScene;
    }
}
