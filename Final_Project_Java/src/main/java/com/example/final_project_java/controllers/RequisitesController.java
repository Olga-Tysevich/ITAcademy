package com.example.final_project_java.controllers;

import com.example.final_project_java.model.requisites.Requisites;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Objects;

import static com.example.final_project_java.controllers.Constants.*;

public class RequisitesController extends BaseController {
    private Requisites requisites;
    private boolean isOwnerRequisites = false;
    @FXML
    private Label warning;
    @FXML
    private Label name;
    @FXML
    private TextField nameForPrint;
    @FXML
    private TextField taxpayerID;
    @FXML
    private TextField classifierCode;
    @FXML
    private TextField legalAddress;
    @FXML
    private TextField mailingAddress;
    @FXML
    private TextField phone;

    @FXML
    private void changeName() {
        requisites.setNameForPrint(nameForPrint.getText());
    }

    @FXML
    private void changeTaxpayerID() {
        try {
            String taxpayerIdTemp = taxpayerID.getText();
            if (taxpayerIdTemp.length() == 9) {
                warning.setText("");
                requisites.setTaxpayerID(Integer.parseInt(taxpayerIdTemp));
            } else {
                warning.setText("Length taxpayer code incorrect!");
            }
        } catch (RuntimeException e) {
            warning.setText("Input valid taxpayer code!");
        }
    }

    @FXML
    private void changeClassifierCode() {
        try {
            String classifierCodeTemp = classifierCode.getText();
            if (classifierCodeTemp.length() > 4 && classifierCodeTemp.length() < 13) {
                warning.setText("");
                requisites.setClassifierCode(Long.parseLong(classifierCodeTemp));
            } else {
                warning.setText("Length classifier code incorrect!");
            }
        } catch (RuntimeException e) {
            warning.setText("Input valid classifier code!");
        }
    }

    @FXML
    private void changeLegalAddress() {
        warning.setText("");
        requisites.setLegalAddress(legalAddress.getText());
    }

    @FXML
    private void changeMailingAddress() {
        warning.setText("");
        requisites.setMailingAddress(mailingAddress.getText());
    }

    @FXML
    private void changePhone() {
        warning.setText("");
        requisites.setPhone(phone.getText());
    }

    @FXML
    private void saveBtnClick() {
        if (nameForPrint.getText().equals("")) {
            warning.setText("Input owner name!");
        } else if (taxpayerID.getText().equals("")) {
            warning.setText("Input taxpayer code!");
        } else if (classifierCode.getText().equals("")) {
            warning.setText("Input classifier code!");
        } else if (legalAddress.getText().equals("")) {
            warning.setText("Input legal address!");
        } else if (mailingAddress.getText().equals("")) {
            warning.setText("Input mailing address!");
        } else if (phone.getText().equals("")) {
            warning.setText("Input phone!");
        } else {
            warning.setText("");
            changeRequisites(requisites);
            MainScreenController main = getLoader(MAIN_MENU_LOADER).getController();
            main.setName();
            if (isOwnerRequisites) {
                isOwnerRequisites = false;
                activateScene(MAIN_SCENE);
            } else {
                sceneExit();
            }
        }
    }

    @FXML
    private void cancelBtnClick() {
        if (isOwnerRequisites) {
            isOwnerRequisites = false;
            activateScene(MAIN_SCENE);
        } else {
            sceneExit();
        }
    }

    private void sceneExit() {
        ObjectListMenuController<Requisites> requisitesList = getLoader(LIST_LOADER).getController();
        requisitesList.setName("Requisites: " + getCustomerDB().select(requisites.getOWNER_ID()).getName());
        requisitesList.setItem(new Requisites(getCustomerDB().select(requisites.getOWNER_ID()).getId()));
        requisitesList.setList(getRequisitesDB().selectAll(this.requisites.getOWNER_ID()));
        activateScene(LIST_SCENE);
    }

    public void setRequisites(Requisites requisites) {
        this.requisites = requisites;
    }

    public void setRequisitesData(Requisites requisites) {
        this.requisites = requisites;
        this.name.setText(name.getText() + Objects.requireNonNullElse(requisites.getNameForPrint(), ""));
        this.nameForPrint.setText(Objects.requireNonNullElse(requisites.getNameForPrint(), ""));
        String taxpayerIdTemp = requisites.getTaxpayerID() == 0 ? "" : String.valueOf(requisites.getTaxpayerID());
        this.taxpayerID.setText(taxpayerIdTemp);
        String classifierCodeTemp = requisites.getClassifierCode() == 0? "" :String.valueOf(requisites.getClassifierCode());
        this.classifierCode.setText(classifierCodeTemp);
        this.legalAddress.setText(Objects.requireNonNullElse(requisites.getLegalAddress(), ""));
        this.mailingAddress.setText(Objects.requireNonNullElse(requisites.getMailingAddress(), ""));
        this.phone.setText(Objects.requireNonNullElse(requisites.getPhone(), ""));
    }

    public void setTypeOwner(boolean ownerRequisites) {
        isOwnerRequisites = ownerRequisites;
    }
}
