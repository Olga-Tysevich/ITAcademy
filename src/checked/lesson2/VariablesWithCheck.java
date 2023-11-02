package checked.lesson2;

import java.util.Scanner;

public class VariablesWithCheck {
    public static void main(String[] args) {
        //task #1
        int variableTaskOne = (int) getNumber("task #1");
        int lastDigit = variableTaskOne % 10;

        System.out.println("Последняя цифра целого числа: " + variableTaskOne + " равна: " + Math.abs(lastDigit));
        System.out.println();

        //task #2
        int variableAbCd = (int) getNumber("task #2");
        int sumAbCd = (variableAbCd / 100) + (variableAbCd % 100);

        System.out.println("Сумма ab и cd из числа abcd: " + variableAbCd + " равна: " + sumAbCd);
        System.out.println();

        //task #3
        int variableTaskThree = (int) getNumber("task #3");
        int thirdDigit = (variableTaskThree / 100) % 10;
        System.out.println("Третья цифра пятизначного числа: " + variableTaskThree + " равна: " + Math.abs(thirdDigit));
        System.out.println();

        //task #4
        System.out.println();
        System.out.println("Необходимо ввести четыре координаты: x1, x2, y1, y2: ");
        double pointXOne = getNumber("task #4");
        double pointXTwo = getNumber("task #4");
        double pointYOne = getNumber("task #4");
        double pointYTwo = getNumber("task #4");

        double lengthLine = Math.sqrt(Math.pow((pointXTwo - pointXOne), 2) + Math.pow((pointYTwo - pointYOne), 2));
        System.out.println("Длина отрезка с координатами х1: " + pointXOne + ", х2: " + pointXTwo + ", у1: " + pointYOne + ", у2: " + pointYTwo
                + " равна: " + lengthLine);
        System.out.println();

        //task #5
        System.out.println("Необходимо ввести три координаты: ширина отверстия, длина отверстия, радиус окружности: ");
        double widthRectangle = getNumber("task #5");
        double lengthRectangle = getNumber("task #5");
        double circleRadius = getNumber("task #5");

        double diagonal = Math.sqrt(Math.pow(widthRectangle, 2) + Math.pow(lengthRectangle, 2));
        String resultTaskFive = diagonal <= (circleRadius * 2) ? " закрывает" : " не закрывает";
        System.out.println("Окружность с радиусом: " + circleRadius + resultTaskFive + " прямоугольное отверстие размером: "
                + widthRectangle + " x " + lengthRectangle);
        System.out.println();

        //task #6 (y = kx + b)
        System.out.println();
        System.out.println("Необходимо ввести четыре координаты: А(x), A(y), B(x), B(y): ");
        double pointAX = getNumber("task #6");
        double pointAY = getNumber("task #6");
        double pointBX = getNumber("task #6");
        double pointBY = getNumber("task #6");

        double k = (pointAY - pointBY) / (pointAX - pointBX);
        double b = pointBY - k * pointBX;

        String resultB = (b < 0) ? (" " + b) : (" + " + b);

        System.out.println("y = " + k + "x" + resultB);

    }

    public static double getNumber(String requirement) {
        boolean check;
        boolean checkString = false;
        boolean condition = false;
        int variable = 0;
        String task = requirement;
        String taskTextFirst = "text";
        String taskTextSecond = "text";
        String taskTextThird = "text";
        String taskTextForth = "text";

        switch (task) {
            case "task #1":
                taskTextFirst = "Введите целое число: ";
                taskTextSecond = "Вы ввели не целое число! Оно будет округлено!";
                taskTextThird = "Вы ввели не число! Введите целое число!";
                break;
            case "task #2":
                taskTextFirst = "Введите целое четырехзначное число: ";
                taskTextSecond = "Вы ввели не целое число! Оно будет округлено!";
                taskTextThird = "Вы ввели не число! Введите целое четырехзначное число!";
                taskTextForth = "Вы ввели число в неверном формате! Введите целое четырехзначное число!";
                break;
            case "task #3":
                taskTextFirst = "Введите целое пятизначное число: ";
                taskTextSecond = "Вы ввели не целое число! Оно будет округлено!";
                taskTextThird = "Вы ввели не число! Введите целое пятизначное число!";
                taskTextForth = "Вы ввели число в неверном формате! Введите целое пятизначное число!";
                break;
            case "task #4", "task #5", "task #6":
                taskTextFirst = "Введите кординату: ";
        }
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print(taskTextFirst);
            check = scanner.hasNextInt();
            if (check == true) {
                variable = scanner.nextInt();
            } else if (scanner.hasNextLine()) {
                try {
                    variable = (int) (Math.round(Double.parseDouble(scanner.nextLine())));
                    System.out.println(taskTextSecond);
                    check = true;
                } catch (NumberFormatException e) {
                    System.out.println(taskTextThird);
                    checkString = true;
                }
            }
            switch (task) {
                case "task #1", "task #4", "task #5", "task #6":
                    condition = true;
                    break;
                case "task #2":
                    condition = Math.abs(variable / 1000) > 0 && Math.abs(variable / 1000) < 10;
                    break;
                case "task #3":
                    condition = Math.abs(variable / 10000) > 0 && Math.abs(variable / 10000) < 10;
                    break;
            }
            if (condition == true) {

            } else if (checkString != true){
                System.out.println(taskTextForth);
                check = false;
            }

        } while (check == false);
        return variable;
    }
}
