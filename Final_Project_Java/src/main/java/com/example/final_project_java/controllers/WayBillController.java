package com.example.final_project_java.controllers;

import com.example.final_project_java.model.customer.WayBill;
import com.example.final_project_java.model.recyclableUnits.RecyclableUnit;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.final_project_java.controllers.Constants.*;

public class WayBillController extends BaseController {
    private WayBill wayBill;
    @FXML
    private Label message;
    @FXML
    private Label name;
    @FXML
    private Label numberError;
    @FXML
    private TextField waybillNumber;
    @FXML
    private DatePicker date;
    @FXML
    private TextField note;
    @FXML
    private ListView<Map.Entry<String, Integer>> waybillData;
    @FXML
    private Label unitName;
    @FXML
    private TextField unitAmount;
    @FXML
    private Label unitAmountError;
    @FXML
    private Label billNumber;

    @FXML
    private Label totalPosition;

    @FXML
    private void changeNumber() {
        wayBill.setNumber(waybillNumber.getText());
    }

    @FXML
    private void saveNumberBtnClick() {
        setWayBillData(wayBill);
    }

    @FXML
    private void changeDate() {
        wayBill.setDate(date.getValue());
    }

    @FXML
    private void changeNote() {
        wayBill.setNote(note.getText());
    }


    @FXML
    private void displayRecyclableData() {
        MultipleSelectionModel<Map.Entry<String, Integer>> selectionModel = waybillData.getSelectionModel();
        try {
            int itemPosition = selectionModel.getSelectedIndices().get(0);
            Map.Entry<String, Integer> entry = waybillData.getItems().get(itemPosition);
            unitName.setText(String.valueOf(entry.getKey()));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void addUnitBtnClick() {
        if (wayBill.getId() == 0) {
            numberError.setText("WayBill not saved!");
        } else {
            ListToAddMenuController<RecyclableUnit> listRecyclableUnit = getLoader(LIST_TO_ADD_LOADER).getController();
            listRecyclableUnit.setSceneName("Recyclable units: ");
            listRecyclableUnit.setItem(new RecyclableUnit());
            List<RecyclableUnit> recyclableUnits = getRecyclableUnitDB().selectAll(OWNER_ID);
            listRecyclableUnit.setList(recyclableUnits);
            listRecyclableUnit.setPrevScene(WAYBILL_SCENE);
            activateScene(LIST_TO_ADD_SCENE);
        }
    }

    @FXML
    private void add() {
        try {
            int oldAmount = wayBill.getWayBillData().get(unitName.getText());
            wayBill.getWayBillData().put(unitName.getText(), Integer.parseInt(unitAmount.getText()) + oldAmount);
            unitAmountError.setText("");
            int totalPositions = wayBill.getWayBillData().values().stream().reduce(Integer::sum).get();
            totalPosition.setText("Total positions: " + totalPositions);
            wayBill.setTotalPositions(totalPositions);
            displayWayBillData();
            changeWayBill(wayBill);
        } catch (RuntimeException e) {
            unitAmountError.setText("Please enter a valid number!");
        }
    }

    @FXML
    private void delete() {
        try {
            int oldAmount = wayBill.getWayBillData().get(unitName.getText());
            if (oldAmount >= Integer.parseInt(unitAmount.getText())) {
                wayBill.getWayBillData().put(unitName.getText(), oldAmount - Integer.parseInt(unitAmount.getText()));
                unitAmountError.setText("");
                int totalPositions = wayBill.getWayBillData().values().stream().reduce(Integer::sum).get();
                totalPosition.setText("Total positions: " + totalPositions);
                wayBill.setTotalPositions(totalPositions);
                displayWayBillData();
                changeWayBill(wayBill);
            } else {
                unitAmountError.setText("Please enter a valid number!");
            }
        } catch (NumberFormatException e) {
            unitAmountError.setText("Please enter a valid number!");
        }
    }

    @FXML
    private void saveBtnClick() {
        if (waybillNumber.getText() != null) {
            numberError.setText("");
            wayBill.setNumber(waybillNumber.getText());
            changeWayBill(wayBill);
            wayBill = getWayBillDB().selectByNumber(wayBill.getNumber());
            message.setText("Saved successfully!");
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(e -> {
                message.setText("");
            });
            pause.play();
        }
        if (waybillNumber.getText() == null) {
            numberError.setText("Please enter a valid waybill number!");
        }
    }

    @FXML
    private void cancelBtnClick() {
        numberError.setText("");
        unitName.setText("");
        unitAmount.setText("");
        displayWayBillList();
    }

    private void displayWayBillList() {
        ObjectListMenuController<WayBill> waybills = getLoader(LIST_LOADER).getController();
        waybills.setName("WayBills: " + getCustomerDB().select(wayBill.getCUSTOMER_ID()).getName());
        waybills.setItem(new WayBill(wayBill.getCUSTOMER_ID()));
        List<WayBill> wayBills = getWayBillDB().selectAll(wayBill.getCUSTOMER_ID()) != null ? getWayBillDB().selectAll(wayBill.getCUSTOMER_ID())
                : new ArrayList<>();
        waybills.setList(wayBills);
        waybills.setPrevScene(CUSTOMER_SCENE);
        activateScene(LIST_SCENE);
    }

    public void setWayBillData(WayBill wayBill) {
        this.wayBill = wayBill;
        name.setText("WayBill: " + wayBill.getNumber());
        waybillNumber.setText(wayBill.getNumber());
        date.setValue(wayBill.getDate());
        note.setText(wayBill.getNote());
        billNumber.setText("Bill number: " + (wayBill.getBillNumber() == null ? "" : wayBill.getBillNumber()));
        totalPosition.setText("Total positions: " + (wayBill.getTotalPositions() == 0 ? "" : wayBill.getTotalPositions()));
        displayWayBillData();
    }

    private void displayWayBillData() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        wayBill.getWayBillData().entrySet().forEach(list::add);
        ObservableList<Map.Entry<String, Integer>> itemsList = FXCollections.observableArrayList(list);
        waybillData.setItems(itemsList);
    }

    public void addRecyclableUnit(RecyclableUnit recyclableUnit) {
        boolean unitAlreadyAdded = false;
        for (String key : wayBill.getWayBillData().keySet()) {
            if (recyclableUnit.getName().equals(key)) {
                unitAlreadyAdded = true;
                break;
            }
        }
        if (!unitAlreadyAdded) {
            wayBill.getWayBillData().put(recyclableUnit.getName(), 0);
            List<Map.Entry<String, Integer>> list = new ArrayList<>();
            wayBill.getWayBillData().entrySet().forEach(list::add);
            ObservableList<Map.Entry<String, Integer>> itemsList = FXCollections.observableArrayList(list);
            waybillData.setItems(itemsList);
        }
    }
}
