package inProgress.lesson6.Task1;

public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction addFractions(double summand) {
        double sum = (double) numerator / denominator + summand;
        int numerator = (int) (Math.round(sum * this.denominator * 1000));
        int denominator = this.denominator * 1000;
        int[] arrayReducedFraction = reduceFraction(numerator, denominator);
        numerator = arrayReducedFraction[0];
        denominator = arrayReducedFraction[1];

        return new Fraction(numerator, denominator);
    }

    public Fraction addFractions(int numeratorOfSecondSummand, int denominatorOfSecondSummand) {
        int numerator = (numeratorOfSecondSummand * this.denominator + this.numerator * denominatorOfSecondSummand);
        int denominator = (denominatorOfSecondSummand * this.denominator);
        int[] arrayReducedFraction = reduceFraction(numerator, denominator);
        numerator = arrayReducedFraction[0];
        denominator = arrayReducedFraction[1];

        return new Fraction(numerator, denominator);
    }

    public Fraction multiplyFractions(double multiplier) {
        int numerator = this.numerator * (int) Math.round(multiplier * 100);
        int denominator = this.denominator * 100;
        int[] arrayReducedFraction = reduceFraction(numerator, denominator);
        numerator = arrayReducedFraction[0];
        denominator = arrayReducedFraction[1];

        return new Fraction(numerator, denominator);
    }

    public Fraction divideFractions(double divisor) {
        int numerator = this.numerator * (int) Math.round(1 / divisor * 100);
        int denominator = this.denominator * 100;
        int[] arrayReducedFraction = reduceFraction(numerator, denominator);
        numerator = arrayReducedFraction[0];
        denominator = arrayReducedFraction[1];

        return new Fraction(numerator, denominator);
    }

    private int[] reduceFraction(int numerator, int denominator) {
        for (int i = 1000; i > 0; i--) {
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
        System.out.println(message + String.format("%.2f", (double) numerator / denominator));
    }
}
