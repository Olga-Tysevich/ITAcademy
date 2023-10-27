package inProgress.lesson20;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    TextField inputField;

    private double item = 0;
    private boolean start = true;
    private String operator = "";
    private final Calculator calculator = new Calculator();

    @FXML
    private void getNum(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (start) {
            inputField.setText(value);
            start = false;
        } else {
            inputField.setText(inputField.getText() + value);
        }
    }

    @FXML
    private void getOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (".".equals(value) && !inputField.getText().contains(".")) {
            inputField.setText(inputField.getText() + value);
        } else if (".".equals(value) && inputField.getText().contains(".")) {
            return;
        }
        if (!"=".equals(value)) {
            if (!operator.isEmpty()) {
                return;
            }
            operator = value;
            item = Double.parseDouble(inputField.getText());
            inputField.setText("");
        } else {
            if (operator.isEmpty()) {
                return;
            }
            inputField.setText(String.valueOf(calculator.calculate(item, Double.parseDouble(inputField.getText()), operator)));
            operator = "";
            start = true;
        }
    }
}
