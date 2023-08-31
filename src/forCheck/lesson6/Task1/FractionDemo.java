package forCheck.lesson6.Task1;


public class FractionDemo {
    public static void main(String[] args) {
        //task #1
        Fraction firtsFraction = new Fraction(1, 3);

        firtsFraction.printFraction(false, "Введена обыкновенная дробь: ");
        firtsFraction.printFraction(true, "Введенная дробь в десятичном виде: ");

        firtsFraction = firtsFraction.addFractions(1.6);
        firtsFraction.printFraction(false, "Сумма дробей в обыкновенном виде: ");
        firtsFraction.printFraction(true, "Сумма дробей в десятичном виде: ");
        System.out.println();

        Fraction secondFraction = firtsFraction.addFractions(5, 3);

        secondFraction.printFraction(false, "Сумма дробей в обыкновенном виде: ");
        secondFraction.printFraction(true, "Сумма дробей в десятичном виде: ");
        System.out.println();

        Fraction thirdFraction = secondFraction.multiplyFractions(0.5);

        thirdFraction.printFraction(false, "Произведение дробей в обыкновенном виде: ");
        thirdFraction.printFraction(true, "Произведение дробей в десятичном виде: ");
        System.out.println();

        Fraction fourthFraction = thirdFraction.divideFractions(0.2);

        fourthFraction.printFraction(false, "Частное дробей в обыкновенном виде: ");
        fourthFraction.printFraction(true, "Частное дробей в десятичном виде: ");
        System.out.println();

    }
}
