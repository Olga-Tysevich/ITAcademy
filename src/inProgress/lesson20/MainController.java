package inProgress.lesson20;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    TextField inputField;
    @FXML
    Button button1;
    @FXML
    Button button2;
    @FXML
    Button button3;
    @FXML
    Button button4;
    @FXML
    Button button5;
    @FXML
    Button button6;
    @FXML
    Button button7;
    @FXML
    Button button8;
    @FXML
    Button button9;
    @FXML
    Button button0;
    @FXML
    Button buttonDot;
    @FXML
    Button buttonSum;
    @FXML
    Button buttonSub;
    @FXML
    Button buttonMult;
    @FXML
    Button buttonDiv;
    @FXML
    Button buttonEquals;

    private double item1 = 0;
    private double item2 = 0;
    private boolean start = true;
    private String operator = "";
    private Calculator calculator = new Calculator();

    @FXML
    private void getNum(ActionEvent event) {
        if (start) {
            inputField.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        inputField.setText(inputField.getText() + value);
    }

    @FXML
    private void getOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!"=".equals(value)) {
            if (!operator.isEmpty()) {
                return;
            }
            operator = value;
            item1 = Double.parseDouble(inputField.getText());
            inputField.setText("");
        } else {
            if (operator.isEmpty()) {
                return;
            }
            inputField.setText(String.valueOf(calculator.calculate(item1, Double.parseDouble(inputField.getText()), operator)));
            operator = "";
            start = true;
        }
    }
}
