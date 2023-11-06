package com.example.final_project_java.controllers;

import com.example.final_project_java.model.customer.Bill;
import com.example.final_project_java.model.customer.Contract;
import com.example.final_project_java.model.customer.Customer;
import com.example.final_project_java.model.customer.WayBill;
import com.example.final_project_java.model.recyclableUnits.RecyclableType;
import com.example.final_project_java.model.requisites.BankAccount;
import com.example.final_project_java.model.requisites.Requisites;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.*;

import static com.example.final_project_java.controllers.Constants.*;

public class CustomerController extends BaseController {
    private final Map<RecyclableType, Double> priceTemp = new TreeMap<>();
    private Customer customer;
    @FXML
    private Label warning;
    @FXML
    private Label name;
    @FXML
    private Label error;
    @FXML
    private TextField customerName;
    @FXML
    private ListView<Map.Entry<RecyclableType, Double>> price;
    @FXML
    private Label recyclableType;
    @FXML
    private TextField recyclablePrice;
    @FXML
    private Label recyclablePriceError;

    @FXML
    private void changeName() {
        warning.setText("");
        customer.setName(customerName.getText());
    }

    @FXML
    private void saveNameBtnClick() {
        setCustomerData(customer);
    }

    @FXML
    private void requisitesBtnClick() {
        if (customer.getId() == 0) {
            error.setText("Customer not saved!");
        } else {
            ObjectListMenuController<Requisites> requisitesList = getLoader(LIST_LOADER).getController();
            requisitesList.setName("Requisites: " + customer.getName());
            requisitesList.setItem(new Requisites(customer.getId()));
            List<Requisites> requisites = getRequisitesDB().selectAll(customer.getId());
            requisitesList.setList(requisites);
            requisitesList.setPrevScene(CUSTOMER_SCENE);
            activateScene(LIST_SCENE);
        }
    }

    @FXML
    private void bankAccountsBtnClick() {
        if (customer.getId() == 0) {
            error.setText("Customer not saved!");
        } else {
            ObjectListMenuController<BankAccount> bankAccounts = getLoader(LIST_LOADER).getController();
            bankAccounts.setName("Bank accounts: " + customer.getName());
            bankAccounts.setItem(new BankAccount(customer.getId()));
            bankAccounts.setList(getBankAccountDB().selectAll(customer.getId()));
            bankAccounts.setPrevScene(CUSTOMER_SCENE);
            activateScene(LIST_SCENE);
        }
    }

    @FXML
    private void contractsBtnClick() {
        if (customer.getId() == 0) {
            error.setText("Customer not saved!");
        } else {
            ObjectListMenuController<Contract> contracts = getLoader(LIST_LOADER).getController();
            contracts.setName("Contracts: " + customer.getName());
            contracts.setItem(new Contract(customer.getId()));
            contracts.setList(getContractDB().selectAll(customer.getId()));
            contracts.setPrevScene(CUSTOMER_SCENE);
            activateScene(LIST_SCENE);
        }
    }

    @FXML
    private void waybillBtnClick() {
        if (customer.getId() == 0) {
            error.setText("Customer not saved!");
        } else {
            ObjectListMenuController<WayBill> waybills = getLoader(LIST_LOADER).getController();
            waybills.setName("WayBills: " + customer.getName());
            waybills.setItem(new WayBill(customer.getId()));
            List<WayBill> wayBills = getWayBillDB().selectAll(customer.getId()) != null? getWayBillDB().selectAll(customer.getId()) : new ArrayList<>();
            waybills.setList(wayBills);
            waybills.setPrevScene(CUSTOMER_SCENE);
            activateScene(LIST_SCENE);
        }
    }

    @FXML
    private void billBtnClick() {
        if (customer.getId() == 0) {
            error.setText("Customer not saved!");
        } else {
            ObjectListMenuController<Bill> bills = getLoader(LIST_LOADER).getController();
            bills.setName("Bills: " + customer.getName());
            bills.setItem(new Bill(customer.getId(), "", customer.getPriceNumber()));
            List<Bill> billList = getBillDB().selectAll(customer.getId()) != null? getBillDB().selectAll(customer.getId()) : new ArrayList<>();
            bills.setList(billList);
            bills.setPrevScene(CUSTOMER_SCENE);
            activateScene(LIST_SCENE);
        }
    }

    @FXML
    private void displayRecyclableData() {
        MultipleSelectionModel<Map.Entry<RecyclableType, Double>> selectionModel = price.getSelectionModel();
        try {
            int itemPosition = selectionModel.getSelectedIndices().get(0);
            Map.Entry<RecyclableType, Double> entry = price.getItems().get(itemPosition);
            recyclableType.setText(String.valueOf(entry.getKey()));
            recyclablePrice.setText(String.valueOf(entry.getValue()));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void changePriceValue() {
        try {
            priceTemp.put(RecyclableType.valueOf(recyclableType.getText()), Double.parseDouble(recyclablePrice.getText()));
            recyclablePriceError.setText("");
            displayPrice();
//            priceNumberTemp = customer.getPriceNumber() + 1;
        } catch (NumberFormatException e) {
            recyclablePriceError.setText("Please enter a valid number!");
        }
    }
    @FXML
    private void changePrice() {
        boolean checkPriceData = false;
        for (Map.Entry<RecyclableType, Double> entry: priceTemp.entrySet()){
            if (!Objects.equals(entry.getValue(), customer.getPrice().get(entry.getKey()))){
                checkPriceData = true;
                break;
            }
        }
        if (checkPriceData) {
            customer.getPrice().putAll(priceTemp);
            customer.setPriceNumber(customer.getPriceNumber() + 1);
        }
    }

    @FXML
    private void saveBtnClick() {
        if (customer.getName().equals("")){
            warning.setText("Input customer name!");
        } else {
            changeCustomer(customer);
            customer = getCustomerDB().selectByName(customer.getName());
            error.setText("");
            warning.setTextFill(Color.GREEN);
            warning.setText("Saved successfully!");
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event -> {
                warning.setTextFill(Color.RED);
                warning.setText("");
            });
            pause.play();
        }
    }

    @FXML
    private void cancelBtnClick() {
        error.setText("");
        warning.setText("");
        name.setText("");
        displayCustomerList(new Customer(""));
    }

    private void displayCustomerList(Customer customer) {
        ObjectListMenuController<Customer> customers = getLoader(LIST_LOADER).getController();
        customers.setName("Customers");
        customers.setItem(customer);
        customers.setList(getCustomerDB().selectAll(OWNER_ID));
        customers.setPrevScene(MAIN_SCENE);
        activateScene(LIST_SCENE);
    }

    public void setCustomerData(Customer customer) {
        priceTemp.putAll(customer.getPrice());
        this.customer = customer;
        name.setText("Customer: " + customer.getName());
        customerName.setText(customer.getName());
        displayPrice();
    }

    private void displayPrice() {
        List<Map.Entry<RecyclableType, Double>> list = new ArrayList<>();
        priceTemp.entrySet().forEach(list::add);
        ObservableList<Map.Entry<RecyclableType, Double>> itemsList = FXCollections.observableArrayList(list);
        price.setItems(itemsList);
    }
}
