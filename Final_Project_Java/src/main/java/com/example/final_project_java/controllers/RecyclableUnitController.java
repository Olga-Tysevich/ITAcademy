package com.example.final_project_java.controllers;

import com.example.final_project_java.model.recyclableUnits.Material;
import com.example.final_project_java.model.recyclableUnits.RecyclableType;
import com.example.final_project_java.model.recyclableUnits.RecyclableUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.*;

import static com.example.final_project_java.controllers.Constants.*;

public class RecyclableUnitController extends BaseController {
    private RecyclableUnit recyclableUnit;
    @FXML
    private Label sceneName;
    @FXML
    private TextField unitName;
    @FXML
    private Label unitNameError;
    @FXML
    ChoiceBox<RecyclableType> types;
    @FXML
    private Label diagonalError;
    @FXML
    private TextField diagonal;
    @FXML
    private Label materialName;
    @FXML
    private Label amountError;
    @FXML
    private TextField materialAmount;

    @FXML
    private ListView<Map.Entry<Material, Double>> materials;

    @FXML
    private void saveNameBtnClick() {
        if (!Objects.equals(unitName.getText(),"")){
            unitNameError.setText("");
            recyclableUnit.setName(unitName.getText());
            sceneName.setText("Recyclable unit: " + unitName.getText());
        } else {
            unitNameError.setText("Input Recyclable unit name!");
        }
    }

    @FXML
    private void changeType() {
        recyclableUnit.setType(types.getValue());
    }

    @FXML
    private void changeAmountOfMaterial() {
        try {
            recyclableUnit.getMaterials().put(Material.valueOf(materialName.getText()), Double.parseDouble(materialAmount.getText()));
            amountError.setText("");
            displayMaterials();
        } catch (NumberFormatException e) {
            amountError.setText("Please enter a valid number!");
        }
    }

    @FXML
    private void changeDiagonal() {
        if (unitName.getText() != null) {
            try {
                recyclableUnit.setDiagonal(Integer.parseInt(diagonal.getText()));
                diagonalError.setText("");
                recyclableUnit.setName(unitName.getText().replaceAll("(\\s+\\d+)+", " " + diagonal.getText()));
                unitName.setText(recyclableUnit.getName());
            } catch (NumberFormatException e) {
                diagonalError.setText("Please enter a valid diagonal!");
            }

        }
    }

    @FXML
    private void displayMaterialData() {
        MultipleSelectionModel<Map.Entry<Material, Double>> selectionModel = materials.getSelectionModel();
        try {
            int itemPosition = selectionModel.getSelectedIndices().get(0);
            Map.Entry<Material, Double> entry = materials.getItems().get(itemPosition);
            materialName.setText(String.valueOf(entry.getKey()));
            materialAmount.setText(String.valueOf(entry.getValue()));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void saveBtnClick() {
        if (!Objects.equals(unitName.getText(), "")) {
            resetScene();
            recyclableUnit.setName(unitName.getText());
            changeRecyclableUnit(recyclableUnit);
            displayRecyclableUnitsList(new RecyclableUnit());
        } else {
            unitNameError.setText("Input Recyclable unit name!");
        }
    }

    @FXML
    private void cancelBtnClick() {
        resetScene();
        displayRecyclableUnitsList(new RecyclableUnit());
    }

    private void resetScene(){
        diagonalError.setText("");
        amountError.setText("");
        materialName.setText("");
        materialAmount.setText("");
    }

    public void setRecyclableUnitData(RecyclableUnit recyclableUnit) {
        this.recyclableUnit = recyclableUnit;
        sceneName.setText("Recyclable unit: " + recyclableUnit.getName());
        unitName.setText(Objects.requireNonNullElse(recyclableUnit.getName(), ""));
        diagonal.setText(String.valueOf(recyclableUnit.getDiagonal()));
        ObservableList<RecyclableType> itemsList = FXCollections.observableArrayList(RecyclableType.values());
        types.setItems(itemsList);
        types.setValue(recyclableUnit.getType());
        displayMaterials();
    }

    private void displayMaterials() {
        List<Map.Entry<Material, Double>> list = new ArrayList<>();
        recyclableUnit.getMaterials().entrySet().forEach(list::add);
        ObservableList<Map.Entry<Material, Double>> itemsList = FXCollections.observableArrayList(list);
        materials.setItems(itemsList);
    }

    private void displayRecyclableUnitsList(RecyclableUnit recyclableUnit) {
        ObjectListMenuController<RecyclableUnit> controller = getLoader(LIST_LOADER).getController();
        controller.setItem(recyclableUnit);
        controller.setList(getRecyclableUnitDB().selectAll(OWNER_ID));
        controller.setPrevScene(MAIN_SCENE);
        activateScene(LIST_SCENE);
    }
}
