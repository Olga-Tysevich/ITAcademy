package inProgress.lesson6;

public class Fraction {
    private int numerator;
    private int denominator;
    private double fraction;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        fraction = (double) numerator / denominator;
    }

    public Fraction addFractions(double summand) {

        fraction += summand;
        numerator = (int) (Math.round(fraction * 100 * denominator));
        denominator= denominator * 100;
        reduceFraction();

        return new Fraction(numerator, denominator);
    }

    public Fraction addFractions(int numeratorOfSecondSummand, int denominatorOfSecondSummand) {
        fraction += (double) numeratorOfSecondSummand /denominatorOfSecondSummand;
        int divisor = denominatorOfSecondSummand;

        numeratorOfSecondSummand = numeratorOfSecondSummand * denominator;
        denominatorOfSecondSummand = denominatorOfSecondSummand * denominator;

        int numeratorAddFractions = numerator * divisor;
        numerator = (numeratorOfSecondSummand + numeratorAddFractions);
        denominator = (denominatorOfSecondSummand);
        reduceFraction();

        return new Fraction(numerator, denominator);
    }

    public Fraction multiplyFractions(double multiplier) {
        fraction *= multiplier;
        numerator *= Math.round(multiplier * 1000);
        denominator *= 1000;
        reduceFraction();
        return new Fraction(numerator, denominator);
    }

    public Fraction divideFraction(double divisor) {
        fraction /= divisor;
        numerator *= 1000;
        denominator *= Math.round(divisor * 1000);
        reduceFraction();
        return new Fraction(numerator, denominator);
    }

    private void reduceFraction() {
        for (int i = 100; i > 0; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;
            }
        }
    }

    public void printFraction(String message) {
        System.out.println(message + numerator + "/" + denominator);
    }

    public void printDecimalFraction(String message) {
        System.out.println(message + String.format("%.2f", fraction));
    }
}
