package inProgress.lesson20;

public class Calculator {
    public double calculate(double item1, double item2, String operator) {
        switch (operator) {
            case "+" -> {
                return sum(item1, item2);
            }
            case "-" -> {
                return subtraction(item1, item2);
            }
            case "*" -> {
                return multiplication(item1, item2);
            }
            case "/" -> {
                return division(item1, item2);
            }
        }
        return -1;
    }

    private double sum(double item1, double item2) {
        return item1 + item2;
    }

    private double subtraction(double item1, double item2) {
        return item1 - item2;
    }

    private double multiplication(double item1, double item2) {
        return item1 * item2;
    }

    private double division(double item1, double item2) {
        return item1 / item2;
    }
}
