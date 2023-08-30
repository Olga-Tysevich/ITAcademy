package inProgress.lesson6.Task1;


public class FractionDemo {
    public static void main(String[] args) {
        //task #1
        Fraction firtsFraction = new Fraction(5, 8);

        firtsFraction.printFraction("Введена обыкновенная дробь: ");
        firtsFraction.printDecimalFraction("Введенная дробь в десятичном виде: ");

        firtsFraction = firtsFraction.addFractions(0.5);
        firtsFraction.printFraction("Сумма дробей в обыкновенном виде: ");
        firtsFraction.printDecimalFraction("Сумма дробей в десятичном виде: ");
        System.out.println();

        Fraction secondFraction = firtsFraction.addFractions(5, 8);

        secondFraction.printFraction("Сумма дробей в обыкновенном виде: ");
        secondFraction.printDecimalFraction("Сумма дробей в десятичном виде: ");
        System.out.println();

        Fraction thirdFraction = secondFraction.multiplyFractions(0.5);

        thirdFraction.printFraction("Произведение дробей в обыкновенном виде: ");
        thirdFraction.printDecimalFraction("Произведение дробей в десятичном виде: ");
        System.out.println();

        Fraction fourthFraction = thirdFraction.divideFraction(5);

        fourthFraction.printFraction("Частное дробей в обыкновенном виде: ");
        fourthFraction.printDecimalFraction("Частное дробей в десятичном виде: ");
        System.out.println();

    }
}
