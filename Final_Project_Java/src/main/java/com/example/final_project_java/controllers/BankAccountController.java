package com.example.final_project_java.controllers;

import com.example.final_project_java.model.requisites.BankAccount;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Objects;

import static com.example.final_project_java.controllers.Constants.*;

public class BankAccountController extends BaseController {
    private BankAccount bankAccount;
    @FXML
    private Label warning;
    @FXML
    private Label name;
    @FXML
    private TextField bankName;
    @FXML
    private TextField accountNumber;
    @FXML
    private TextField BIC;
    @FXML
    private TextField bankAddress;

    @FXML
    private void changeBankName() {
        warning.setText("");
        bankAccount.setBankName(bankName.getText());
    }
    @FXML
    private void changeAccountNumber() {
        warning.setText("");
        bankAccount.setAccountNumber(accountNumber.getText());
    }
    @FXML
    private void changeBIC() {
        warning.setText("");
        bankAccount.setBIC(BIC.getText());
    }
    @FXML
    private void changeBankAddress() {
        warning.setText("");
        bankAccount.setBankAddress(bankAddress.getText());
    }

    @FXML
    private void saveBtnClick() {
        if (bankName.getText().equals("")){
            warning.setText("Input bank name!");
        } else if (accountNumber.getText().equals("")) {
            warning.setText("Input account number!");
        } else if (BIC.getText().equals("")) {
            warning.setText("Input BIC!");
        } else if (bankAddress.getText().equals("")) {
            warning.setText("Input bank address!");
        } else {
            changeBankAccount(bankAccount);
            displayBankAccountList(new BankAccount(bankAccount.getOWNER_ID()));
        }
    }

    @FXML
    private void cancelBtnClick() {
        displayBankAccountList(new BankAccount(bankAccount.getOWNER_ID()));
    }

    @FXML
    private void displayBankAccountList(BankAccount bankAccount) {
        ObjectListMenuController<BankAccount> bankAccounts = getLoader(LIST_LOADER).getController();
        if (this.bankAccount.getOWNER_ID() == 0) {
            bankAccounts.setName("Bank accounts: " + getRequisitesDB().selectAll(OWNER_ID).get(0).getNameForPrint());
        } else {
            bankAccounts.setName("Bank accounts: " + getCustomerDB().select(bankAccount.getOWNER_ID()).getName());
        }
        bankAccounts.setItem(bankAccount);
        bankAccounts.setList(getBankAccountDB().selectAll(bankAccount.getOWNER_ID()));
        activateScene(LIST_SCENE);
    }

    public void setBankAccountData(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.name.setText("Bank account");
        this.bankName.setText(Objects.requireNonNullElse(bankAccount.getBankName(), ""));
        this.accountNumber.setText(Objects.requireNonNullElse(bankAccount.getAccountNumber(), ""));
        this.BIC.setText(Objects.requireNonNullElse(bankAccount.getBIC(), ""));
        this.bankAddress.setText(Objects.requireNonNullElse(bankAccount.getBankAddress(), ""));
    }
}
