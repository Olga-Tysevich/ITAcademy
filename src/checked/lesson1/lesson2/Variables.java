package checked.lesson1.lesson2;

public class Variables {
    public static void main(String[] args) {
        //task #1
        int variableTaskOne = -115;
        int lastDigit = variableTaskOne % 10;

        System.out.println("Последняя цифра целого числа: " + variableTaskOne + " равна: " + Math.abs(lastDigit));

        //task #2
        int variableAbCd = 5223;
        int sumAbCd = (variableAbCd / 100) + (variableAbCd % 100);

        System.out.println("Сумма ab и cd из числа abcd: " + variableAbCd + " равна: " + sumAbCd);

        //task #3
        int variableTaskThree = -25698;
        int thirdDigit = (variableTaskThree / 100) % 10;

        System.out.println("Третья цифра пятизначного числа: " + variableTaskThree + " равна: " + Math.abs(thirdDigit));

        //task #4
        double pointXOne = -2;
        double pointXTwo = 4;
        double pointYOne = 4;
        double pointYTwo = 1;

        double lengthLine = Math.sqrt(Math.pow((pointXTwo - pointXOne), 2) + Math.pow((pointYTwo - pointYOne), 2));

        System.out.println("Длина отрезка AB с координатами A(х1: " + pointXOne + ", у1: " + pointYOne + "), B(х2: "
                            + pointXTwo + ", у2: " + pointYTwo + ") равна: " + String.format("%.2f", lengthLine));

        //task #5
        double widthRectangle = 6;
        double lengthRectangle = 8;
        double circleRadius = 5;

        double diagonal = Math.sqrt(Math.pow(widthRectangle, 2) + Math.pow(lengthRectangle, 2));

        String resultTaskFive = diagonal <= (circleRadius * 2) ? " закрывает" : " не закрывает";
        System.out.println("Окружность с радиусом: " + circleRadius + resultTaskFive + " прямоугольное отверстие размером: "
                            + widthRectangle + " x " + lengthRectangle);

        //task #6 (y = kx + b)
        double pointAX = 3;
        double pointAY = 2;
        double pointBX = -1;
        double pointBY = -1;

        double k = (pointAY - pointBY) / (pointAX - pointBX);
        double b = pointBY - k * pointBX;

        //Следующая строка нужна просто чтобы выводилось симпатичнее
        String characterBeforeB = (b < 0) ? (" ") : (" + ");

        System.out.println("y = " + String.format("%.2f", k) + "x" + characterBeforeB + String.format("%.2f", b));

    }
}
