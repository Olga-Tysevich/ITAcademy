package inProgress.lesson20;

public class Calculator {
    public double calculate(double firstNumber, double secondNumber, String operator) {
        switch (operator) {
            case "+" -> {
                return firstNumber + secondNumber;
            }
            case "-" -> {
                return firstNumber - secondNumber;
            }
            case "x" -> {
                return firstNumber * secondNumber;
            }
            case "/" -> {
                return firstNumber / secondNumber;
            }
        }
        return 0;
    }
}
