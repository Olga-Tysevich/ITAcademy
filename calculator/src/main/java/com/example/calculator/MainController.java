package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    TextField inputField;

    private Double number;
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
        try {
            String value = ((Button) event.getSource()).getText();
            if (value.equals(".") && !inputField.getText().contains(".")) {
                inputField.setText(inputField.getText() + value);
            } else if (value.equals("C") || number == null && value.equals("=")) {
                number = null;
                operator = "";
                inputField.setText("");
            } else if (number != null && !inputField.getText().equals("") && !operator.isEmpty() && value.equals("=")) {
                Double result = calculator.calculate(number, Double.parseDouble(inputField.getText()), operator);
                inputField.setText(String.valueOf(result));
                number = null;
                operator = "";
            } else if (operator.isEmpty() && number == null && !value.equals(".")) {
                number = Double.parseDouble(inputField.getText());
                inputField.setText("");
                operator = value;
            } else if (number != null && !value.equals(".")) {
                Double result = calculator.calculate(number, Double.parseDouble(inputField.getText()), operator);
                inputField.setText(String.valueOf(result));
                operator = value;
                number = result;
                start = true;
            }
        } catch (RuntimeException e) {
            System.out.println("The user did not enter a number");
        }
    }
}
