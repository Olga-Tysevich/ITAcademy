package forCheck.lesson20;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/MainScene.fxml"));
        Scene mainScene = null;
        try {
            mainScene = new Scene(mainLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MainController mainController = mainLoader.getController();

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Calculator");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }
}
