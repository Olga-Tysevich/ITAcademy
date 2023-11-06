package com.example.final_project_java;

import com.example.final_project_java.controllers.BaseController;
import com.example.final_project_java.controllers.MainScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

import static com.example.final_project_java.controllers.Constants.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            stage.setTitle("Company");

            FXMLLoader mainMenuLoader = new FXMLLoader(Main.class.getResource("screens/MainScreen.fxml"));
            FXMLLoader listMenuLoader = new FXMLLoader(Main.class.getResource("screens/ListScreen.fxml"));
            FXMLLoader requisitesMenuLoader = new FXMLLoader(Main.class.getResource("screens/requisitesScreen.fxml"));
            FXMLLoader bankAccountMenuLoader = new FXMLLoader(Main.class.getResource("screens/BankAccountScreen.fxml"));
            FXMLLoader customerLoader = new FXMLLoader(Main.class.getResource("screens/CustomerScreen.fxml"));
            FXMLLoader contractLoader = new FXMLLoader(Main.class.getResource("screens/ContractScreen.fxml"));
            FXMLLoader recyclableUnitLoader = new FXMLLoader(Main.class.getResource("screens/RecyclableUnitScreen.fxml"));
            FXMLLoader waybillLoader = new FXMLLoader(Main.class.getResource("screens/WayBillScreen.fxml"));
            FXMLLoader billLoader = new FXMLLoader(Main.class.getResource("screens/BillScreen.fxml"));
            FXMLLoader listToAddLoader = new FXMLLoader(Main.class.getResource("screens/ListToAddScreen.fxml"));


            Scene mainScene = new Scene(mainMenuLoader.load());
            Scene listScene = new Scene(listMenuLoader.load());
            Scene requisitesScene = new Scene(requisitesMenuLoader.load());
            Scene bankAccountScene = new Scene(bankAccountMenuLoader.load());
            Scene customerScene = new Scene(customerLoader.load());
            Scene contractScene = new Scene(contractLoader.load());
            Scene recyclableUnitScene = new Scene(recyclableUnitLoader.load());
            Scene waybillScene = new Scene(waybillLoader.load());
            Scene billScene = new Scene(billLoader.load());
            Scene listToAddScene = new Scene(listToAddLoader.load());

            MainScreenController mainController = mainMenuLoader.getController();
            mainController.setName();

            HashMap<String, FXMLLoader> loadersHashMap = new HashMap<>();
            HashMap<String, Scene> sceneHashMap = new HashMap<>();

            loadersHashMap.put(MAIN_MENU_LOADER, mainMenuLoader);
            loadersHashMap.put(REQUISITES_MENU_LOADER, requisitesMenuLoader);
            loadersHashMap.put(BANK_ACCOUNT_MENU_LOADER, bankAccountMenuLoader);
            loadersHashMap.put(LIST_LOADER, listMenuLoader);
            loadersHashMap.put(CUSTOMER_LOADER, customerLoader);
            loadersHashMap.put(CONTRACT_LOADER, contractLoader);
            loadersHashMap.put(RECYCLABLE_UNIT_LOADER, recyclableUnitLoader);
            loadersHashMap.put(WAYBILL_LOADER, waybillLoader);
            loadersHashMap.put(BILL_LOADER, billLoader);
            loadersHashMap.put(LIST_TO_ADD_LOADER, listToAddLoader);

            loadersHashMap.forEach((n, l) -> ((BaseController) l.getController()).setStage(stage));

            sceneHashMap.put(MAIN_SCENE, mainScene);
            sceneHashMap.put(REQUISITES_SCENE, requisitesScene);
            sceneHashMap.put(LIST_SCENE, listScene);
            sceneHashMap.put(BANK_ACCOUNT_SCENE, bankAccountScene);
            sceneHashMap.put(CUSTOMER_SCENE, customerScene);
            sceneHashMap.put(CONTRACT_SCENE, contractScene);
            sceneHashMap.put(RECYCLABLE_UNIT_SCENE, recyclableUnitScene);
            sceneHashMap.put(WAYBILL_SCENE, waybillScene);
            sceneHashMap.put(BILL_SCENE, billScene);
            sceneHashMap.put(LIST_TO_ADD_SCENE, listToAddScene);

            loadersHashMap.forEach((n, l) -> ((BaseController) l.getController()).addLoaders(loadersHashMap));
            loadersHashMap.forEach((n, l) -> ((BaseController) l.getController()).addScenes(sceneHashMap));

            stage.setScene(mainScene);
            stage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
