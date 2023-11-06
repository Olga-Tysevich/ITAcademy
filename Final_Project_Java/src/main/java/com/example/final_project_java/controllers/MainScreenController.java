package com.example.final_project_java.controllers;

import com.example.final_project_java.model.customer.Customer;
import com.example.final_project_java.model.recyclableUnits.RecyclableUnit;
import com.example.final_project_java.model.requisites.BankAccount;
import com.example.final_project_java.model.requisites.Requisites;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.Objects;

import static com.example.final_project_java.controllers.Constants.*;

public class MainScreenController extends BaseController{
    public Button requisitesBtn;
    public Button bankAccountBtn;
    @FXML
    private Label name;

    @FXML
    private void requisitesBtnClick() {
        RequisitesController requisites = getLoader(REQUISITES_MENU_LOADER).getController();
        requisites.setTypeOwner(true);
        requisites.setRequisitesData(getRequisitesDB().selectAll(0).get(0));
        activateScene(REQUISITES_SCENE);
    }

    @FXML
    private void bankAccountsBtnClick() {
        ObjectListMenuController<BankAccount> bankAccounts = getLoader(LIST_LOADER).getController();
        bankAccounts.setItem(new BankAccount(OWNER_ID));
        bankAccounts.setList(getBankAccountDB().selectAll(OWNER_ID));
        bankAccounts.setName("Bank accounts: " + name.getText());
        bankAccounts.setPrevScene(MAIN_SCENE);
        activateScene(LIST_SCENE);
    }

    @FXML
    private void customerBtnClick() {
        ObjectListMenuController<Customer> customers = getLoader(LIST_LOADER).getController();
        customers.setItem(new Customer(""));
        customers.setList(getCustomerDB().selectAll(OWNER_ID));
        customers.setName("Customers: ");
        customers.setPrevScene(MAIN_SCENE);
        activateScene(LIST_SCENE);
    }

    @FXML
    private void recyclableUnitBtnClick() {
        ObjectListMenuController<RecyclableUnit> controller = getLoader(LIST_LOADER).getController();
        controller.setItem(new RecyclableUnit(""));
        controller.setList(getRecyclableUnitDB().selectAll(OWNER_ID));
        controller.setName("Recyclable units: ");
        controller.setPrevScene(MAIN_SCENE);
        activateScene(LIST_SCENE);
    }

    public void setName() {
        String ownerName = null;
        try {
            ownerName = getRequisitesDB().selectAll(OWNER_ID).get(0).getNameForPrint();
        } catch (IndexOutOfBoundsException e) {
            getRequisitesDB().insert(new Requisites(OWNER_ID));
        }
        this.name.setText(Objects.requireNonNullElse(ownerName, "Fill in the owner's details!"));
    }
}
