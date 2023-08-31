package forCheck.lesson6.Task1;

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

        return reduceFraction(numerator, denominator);
    }

    public Fraction addFractions(int numeratorOfSecondSummand, int denominatorOfSecondSummand) {
        int numerator = (numeratorOfSecondSummand * this.denominator + this.numerator * denominatorOfSecondSummand);
        int denominator = (denominatorOfSecondSummand * this.denominator);

        return reduceFraction(numerator, denominator);
    }

    public Fraction multiplyFractions(double multiplier) {
        int numerator = this.numerator * (int) Math.round(multiplier * 100);
        int denominator = this.denominator * 100;

        return reduceFraction(numerator, denominator);
    }

    public Fraction divideFractions(double divisor) {
        int numerator = this.numerator * (int) Math.round(1 / divisor * 100);
        int denominator = this.denominator * 100;

        return reduceFraction(numerator, denominator);
    }

    private Fraction reduceFraction(int numerator, int denominator) {
        for (int i = 1000; i > 0; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;
            }
        }
        return new Fraction(numerator,denominator);
    }

    public void printFraction(boolean printDecimal, String messageBeforeFraction) {
        if (printDecimal){
            System.out.println(messageBeforeFraction + String.format("%.2f", (double) numerator / denominator));
        } else {
            System.out.println(messageBeforeFraction + numerator + "/" + denominator);
        }
    }
}
