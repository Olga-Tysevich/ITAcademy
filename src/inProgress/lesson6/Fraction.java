package inProgress.lesson6;

public class Fraction {
    private final int numerator;
    private final int denominator;
    private final double fraction;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        fraction = (double) numerator / denominator;
    }

    public Fraction addFractions(double summand) {
        double fraction = this.fraction + summand;
        int numerator = (int) (Math.round(fraction * 100 * this.denominator));
        int denominator = this.denominator * 100;
        int[] arrayOfNumAndDen = reduceFraction(numerator, denominator);
        numerator = arrayOfNumAndDen[0];
        denominator = arrayOfNumAndDen[1];

        return new Fraction(numerator, denominator);
    }

    public Fraction addFractions(int numeratorOfSecondSummand, int denominatorOfSecondSummand) {
//        double fraction = (double) numeratorOfSecondSummand / denominatorOfSecondSummand + this.fraction;
        int divisor = denominatorOfSecondSummand;

        numeratorOfSecondSummand = numeratorOfSecondSummand * this.denominator;
        denominatorOfSecondSummand = denominatorOfSecondSummand * this.denominator;

        int numeratorAddFractions = this.numerator * divisor;
        int numerator = (numeratorOfSecondSummand + numeratorAddFractions);
        int denominator = (denominatorOfSecondSummand);
        int[] arrayOfNumAndDen = reduceFraction(numerator, denominator);
        numerator = arrayOfNumAndDen[0];
        denominator = arrayOfNumAndDen[1];

        return new Fraction(numerator, denominator);
    }

    public Fraction multiplyFractions(double multiplier) {
//        double fraction = this.fraction * multiplier;
        int numerator = this.numerator * (int) Math.round(multiplier * 1000);
        int denominator = this.denominator * 1000;
        int[] arrayOfNumAndDen = reduceFraction(numerator, denominator);
        numerator = arrayOfNumAndDen[0];
        denominator = arrayOfNumAndDen[1];

        return new Fraction(numerator, denominator);
    }

    public Fraction divideFraction(double divisor) {
//        double fraction = this.fraction / divisor;
        int numerator = this.numerator * 1000;
        int denominator = this.denominator * (int) Math.round(divisor * 1000);
        int[] arrayOfNumAndDen = reduceFraction(numerator, denominator);
        numerator = arrayOfNumAndDen[0];
        denominator = arrayOfNumAndDen[1];

        return new Fraction(numerator, denominator);
    }

    private int[] reduceFraction(int numerator, int denominator) {
        for (int i = 100; i > 0; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;
            }
        }
        return new int[]{numerator, denominator};
    }

    public void printFraction(String message) {
        System.out.println(message + numerator + "/" + denominator);
    }

    public void printDecimalFraction(String message) {
        System.out.println(message + String.format("%.2f", fraction));
    }
}
