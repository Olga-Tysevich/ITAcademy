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
        try {
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/MainScene.fxml"));
            Scene mainScene = new Scene(mainLoader.load());
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Calculator");
            primaryStage.setMaxWidth(280);
            primaryStage.setMinWidth(280);
            primaryStage.setMaxHeight(420);
            primaryStage.setMinHeight(420);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
