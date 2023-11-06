package com.example.final_project_java.controllers;

import com.example.final_project_java.model.customer.Contract;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Objects;

import static com.example.final_project_java.controllers.Constants.*;

public class ContractController extends BaseController {
    private Contract contract;
    @FXML
    private Label warning;
    @FXML
    private Label name;
    @FXML
    private Label error;
    @FXML
    private TextField number;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker endDate;

    @FXML
    private void changeNumber() {
        warning.setText("");
        contract.setNumber(number.getText());
    }

    @FXML
    private void changeStartDate() {
        if (startDate.getValue().isBefore(endDate.getValue()) || startDate.getValue().isEqual(endDate.getValue())) {
            error.setText("");
        } else {
            error.setText("The end date cannot be later than the start date!");
        }
        contract.setStartDate(startDate.getValue());
    }

    @FXML
    private void changeEndDate() {
        contract.setStartDate(endDate.getValue());
    }

    @FXML
    private void saveBtnClick() {
        if (number.getText().equals("")) {
            warning.setText("Input contract number!");
        } else if (startDate.getValue().isBefore(endDate.getValue()) || startDate.getValue().isEqual(endDate.getValue())) {
            warning.setText("");
            error.setText("");
            changeContract(contract);
            sceneExit();
        }
    }

    @FXML
    private void cancelBtnClick() {
        sceneExit();
    }

    private void sceneExit() {
        ObjectListMenuController<Contract> contracts = getLoader(LIST_LOADER).getController();
        contracts.setName("Contracts: " + name.getText());
        contracts.setItem(new Contract(contract.getCUSTOMER_ID()));
        contracts.setList(getContractDB().selectAll(contract.getCUSTOMER_ID()));
        contracts.setPrevScene(CUSTOMER_SCENE);
        activateScene(LIST_SCENE);
    }

    public void setContractData(Contract contract) {
        this.contract = contract;
        this.name.setText(Objects.requireNonNullElse(getCustomerDB().select(contract.getCUSTOMER_ID()).getName(), ""));
        this.number.setText(Objects.requireNonNullElse(contract.getNumber(), ""));
        this.startDate.setValue(contract.getStartDate());
        this.endDate.setValue(contract.getEndDate());
    }
}
