package com.example.final_project_java.controllers;

import com.example.final_project_java.model.customer.WayBill;
import com.example.final_project_java.model.recyclableUnits.RecyclableUnit;
import com.example.final_project_java.model.requisites.BankAccount;
import com.example.final_project_java.model.requisites.Requisites;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

import static com.example.final_project_java.controllers.Constants.*;

public class ListToAddMenuController<E> extends BaseController {
    private int ownerID;
    private String prevScene;
    private E item;
    @FXML
    private Label sceneName;
    @FXML
    private Label nothingFoundError;
    @FXML
    private TextField findField;
    @FXML
    private ListView<E> listView;


    @FXML
    private void addBtnClick() {
        try {
            MultipleSelectionModel<E> selectionModel = listView.getSelectionModel();
            int itemPosition = selectionModel.getSelectedIndices().get(0);
            item = listView.getItems().get(itemPosition);
            if (item instanceof RecyclableUnit) {
                WayBillController wayBillController = getLoader(WAYBILL_LOADER).getController();
                wayBillController.addRecyclableUnit((RecyclableUnit) item);
            } else if (item instanceof BankAccount) {
                BillController billController = getLoader(BILL_LOADER).getController();
                billController.addBankAccount((BankAccount) item, ownerID);
            } else if (item instanceof Requisites) {
                BillController billController = getLoader(BILL_LOADER).getController();
                billController.addCustomerRequisites((Requisites) item);
            } else if (item instanceof WayBill) {
                BillController billController = getLoader(BILL_LOADER).getController();
                billController.addWayBill((WayBill) item);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        activateScene(prevScene);
    }

    @FXML
    private void cancelBtnClick() {
        activateScene(prevScene);
    }

    public void setList(List<E> list) {
        ObservableList<E> itemsList = FXCollections.observableArrayList(list);
        listView.setItems(itemsList);
    }

    public void setSceneName(String listName) {
        this.sceneName.setText(listName);
    }

    public void setItem(E item) {
        this.item = item;
    }

    public void setPrevScene(String prevScene) {
        this.prevScene = prevScene;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }
}
