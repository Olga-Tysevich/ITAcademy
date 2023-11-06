package com.example.final_project_java.controllers;

import com.example.final_project_java.model.customer.Bill;
import com.example.final_project_java.model.customer.WayBill;
import com.example.final_project_java.model.recyclableUnits.RecyclableType;
import com.example.final_project_java.model.requisites.BankAccount;
import com.example.final_project_java.model.requisites.Requisites;
import com.example.final_project_java.template.BillTemplate;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.util.*;

import static com.example.final_project_java.controllers.Constants.*;
import static com.example.final_project_java.controllers.Constants.LIST_TO_ADD_SCENE;

public class BillController extends BaseController {
    private Bill bill;
    @FXML
    private Label message;
    @FXML
    private Label sceneName;
    @FXML
    private Label numberError;
    @FXML
    private TextField billNumber;
    @FXML
    private Label ownerBankAccount;
    @FXML
    private Label customerRequisites;
    @FXML
    private Label customerBankAccount;
    @FXML
    private DatePicker date;
    @FXML
    private ListView<String> billData;
    @FXML
    private Label wayBillNumber;
    @FXML
    private Label wayBillDate;
    @FXML
    private Label totalPositionsInWayBill;
    @FXML
    private Label sum;

    @FXML
    private void changeNumber() {
        if (!billNumber.getText().equals("")) {
            bill.setNumber(billNumber.getText());
            sceneName.setText("Bill: " + bill.getNumber());
            numberError.setText("");
        } else {
            numberError.setText("Please enter a valid bill number!");
        }
    }

    @FXML
    private void changeDate() {
        bill.setDate(date.getValue());
    }

    @FXML
    private void saveBtnClick() {
        if (!billNumber.getText().equals("")) {
            numberError.setText("");
            bill.setNumber(billNumber.getText());
            changeBill(bill);
            bill = getBillDB().selectByNumber(bill.getNumber());
            message.setTextFill(Color.GREEN);
            message.setText("Saved successfully!");
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(e -> {
                message.setTextFill(Color.RED);
                message.setText("");
            });
            pause.play();
        } else {
            numberError.setText("Please enter a valid bill number!");
        }
    }

    @FXML
    private void cancelBtnClick() {
        numberError.setText("");
        wayBillNumber.setText("");
        wayBillDate.setText("");
        totalPositionsInWayBill.setText("");
        displayBillList();
    }

    private void displayBillList() {
        ObjectListMenuController<Bill> bills = getLoader(LIST_LOADER).getController();
        bills.setName("Bills: " + getCustomerDB().select(bill.getCUSTOMER_ID()).getName());
        bills.setItem(new Bill(bill.getCUSTOMER_ID(), "", getCustomerDB().select(bill.getCUSTOMER_ID()).getPriceNumber()));
        List<Bill> billList = getBillDB().selectAll(bill.getCUSTOMER_ID()) != null ? getBillDB().selectAll(bill.getCUSTOMER_ID()) : new ArrayList<>();
        bills.setList(billList);
        bills.setPrevScene(CUSTOMER_SCENE);
        activateScene(LIST_SCENE);
    }

    @FXML
    private void addOwnerBankAccountBtnClick() {
        setListToAddScene(OWNER_ID, "Owner bank accounts: ");
    }

    @FXML
    private void addCustomerBankAccountBtnClick() {
        setListToAddScene(bill.getCUSTOMER_ID(), "Customer bank accounts: ");
    }

    private void setListToAddScene(int ownerId, String sceneName) {
        if (bill.getId() == 0) {
            message.setText("Bill not saved!");
        } else {
            ListToAddMenuController<BankAccount> listOwnerBankAccounts = getLoader(LIST_TO_ADD_LOADER).getController();
            listOwnerBankAccounts.setSceneName(sceneName);
            listOwnerBankAccounts.setItem(new BankAccount(ownerId));
            List<BankAccount> bankAccounts = getBankAccountDB().selectAll(ownerId);
            listOwnerBankAccounts.setList(bankAccounts);
            listOwnerBankAccounts.setPrevScene(BILL_SCENE);
            listOwnerBankAccounts.setOwnerID(ownerId);
            activateScene(LIST_TO_ADD_SCENE);
        }

    }

    @FXML
    private void addCustomerRequisitesBtnClick() {
        if (bill.getId() == 0) {
            message.setText("Bill not saved!");
        } else {
            ListToAddMenuController<Requisites> customerRequisites = getLoader(LIST_TO_ADD_LOADER).getController();
            customerRequisites.setSceneName("Customer requisites: ");
            customerRequisites.setItem(new Requisites(bill.getCUSTOMER_ID()));
            List<Requisites> requisites = getRequisitesDB().selectAll(bill.getCUSTOMER_ID());
            customerRequisites.setList(requisites);
            customerRequisites.setPrevScene(BILL_SCENE);
            customerRequisites.setOwnerID(bill.getCUSTOMER_ID());
            activateScene(LIST_TO_ADD_SCENE);
        }
    }

    @FXML
    private void addBtnClick() {
        if (bill.getId() == 0) {
            message.setText("Bill not saved!");
        } else {
            ListToAddMenuController<WayBill> waybillList = getLoader(LIST_TO_ADD_LOADER).getController();
            waybillList.setSceneName("Customer wayBills: ");
            waybillList.setItem(new WayBill(bill.getCUSTOMER_ID()));
            List<WayBill> waybills = getWayBillDB().selectWayBillsWithoutBill(bill.getCUSTOMER_ID());
            waybillList.setList(waybills);
            waybillList.setPrevScene(BILL_SCENE);
            waybillList.setOwnerID(bill.getCUSTOMER_ID());
            activateScene(LIST_TO_ADD_SCENE);
        }
    }

    public void setBillData(Bill bill) {
        this.bill = bill;
        sceneName.setText("Bill: " + bill.getNumber());
        billNumber.setText(bill.getNumber());
        BankAccount ownerBankAccount = getBankAccountDB().select(bill.getOwnerBankAccountId());
        this.ownerBankAccount.setText(ownerBankAccount == null ? "" : ownerBankAccount.toString());
        Requisites customerRequisites = getRequisitesDB().select(bill.getCustomerRequisitesId());
        this.customerRequisites.setText(customerRequisites == null ? "" : customerRequisites.toString());
        BankAccount customerBankAccount = getBankAccountDB().select(bill.getCustomerBankAccountId());
        this.customerBankAccount.setText(customerBankAccount == null ? "" : customerBankAccount.toString());
        date.setValue(bill.getDate());
        sum.setText("Sum: " + bill.getSum());
        displayBillData();
    }

    private void displayBillData() {
        List<String> list = bill.getWayBills();
        ObservableList<String> itemsList = FXCollections.observableArrayList(list);
        billData.setItems(itemsList);
    }

    public void addBankAccount(BankAccount bankAccount, int ownerId) {
        if (ownerId == 0) {
            bill.setOwnerBankAccountId(bankAccount.getId());
            ownerBankAccount.setText(bankAccount.toString());
        } else {
            bill.setCustomerBankAccountId(bankAccount.getId());
            customerBankAccount.setText(bankAccount.toString());
        }
    }

    public void addCustomerRequisites(Requisites requisites) {
        bill.setCustomerRequisitesId(requisites.getId());
        customerRequisites.setText(requisites.toString());
    }

    public void addWayBill(WayBill wayBill) {
        wayBill.setBillNumber(bill.getNumber());
        changeWayBill(wayBill);
        ObservableList<String> itemsList = billData.getItems();
        itemsList.add(wayBill.getNumber());
        billData.setItems(itemsList);
        bill.addWaybill(wayBill);
        bill.setSum(calculateAmount(wayBill));
        sum.setText("Bill sum: " + bill.getSum());
        changeBill(bill);
        bill = getBillDB().selectByNumber(bill.getNumber());
    }

    private double calculateAmount(WayBill wayBill) {
        SortedMap<String, Integer> wayBillData = wayBill.getWayBillData();
        Map<RecyclableType, Double> price = getCustomerDB().select(bill.getCUSTOMER_ID()).getPrice();
        double amount = bill.getSum();
        for (Map.Entry<String, Integer> entry : wayBillData.entrySet()) {
            amount += price.get(getRecyclableUnitDB().selectByName(entry.getKey()).getType()) * entry.getValue();
        }
        return amount;
    }

    @FXML
    private void displayWayBillData() {
        MultipleSelectionModel<String> selectionModel = billData.getSelectionModel();
        try {
            int itemPosition = selectionModel.getSelectedIndices().get(0);
            String wayBill = billData.getItems().get(itemPosition);
            wayBillNumber.setText("WayBill number: " + wayBill);
            wayBillDate.setText("WayBill date: " + getWayBillDB().selectByNumber(wayBill).getDate());
            totalPositionsInWayBill.setText("Total positions: " + getWayBillDB().selectByNumber(wayBill).getTotalPositions());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void saveAsDocxBtnClick() {
        Map<RecyclableType, Integer> amountRecyclableUnitsInBill = getAmountRecyclableUnitsInBill();
        Map<RecyclableType, Double> price = getBillDB().selectPrice(bill.getPRICE_NUMBER());
        Map<RecyclableType, Double> billPriceOfRecyclableUnits = new TreeMap<>();
        Arrays.stream(RecyclableType.values()).forEach(t -> billPriceOfRecyclableUnits.put(t, 0.00));
        amountRecyclableUnitsInBill.forEach((key, value) -> billPriceOfRecyclableUnits.put(key, value * price.get(key)));
        String[] wayBillArray = bill.getWayBills().toArray(new String[0]);
        int totalPositions = amountRecyclableUnitsInBill.values().stream().reduce(Integer::sum).get();
        double sum = billPriceOfRecyclableUnits.values().stream().reduce(Double::sum).get();
        BillTemplate template = new BillTemplate(bill.getNumber(), wayBillArray, bill.getDate(), totalPositions, sum, amountRecyclableUnitsInBill, price,
                billPriceOfRecyclableUnits);
        try {
            template.generateBill();
        } catch (FileNotFoundException e) {
            message.setTextFill(Color.RED);
            message.setText("The file is already open! Close the file!");
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(m -> {
                message.setText("");
            });
        }
    }

    private Map<RecyclableType, Integer> getAmountRecyclableUnitsInBill() {
        Map<RecyclableType, Integer> amountRecyclableUnitsInBill = new TreeMap<>();
        Arrays.stream(RecyclableType.values()).forEach(t -> amountRecyclableUnitsInBill.put(t, 0));
        System.out.println(bill.getWayBills().size());
        bill.getWayBills().forEach(w -> getWayBillDB().selectByNumber(w).getWayBillData().forEach((key, value) ->
                amountRecyclableUnitsInBill.put(getRecyclableUnitDB().selectByName(key).getType(),
                        amountRecyclableUnitsInBill.get(getRecyclableUnitDB().selectByName(key).getType())
                                + value)));
        return amountRecyclableUnitsInBill;
    }
}
