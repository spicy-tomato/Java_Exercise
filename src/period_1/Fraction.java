package period_1;

import java.math.BigInteger;

class Fraction implements Comparable<Fraction> {

    private final int numerator;
    private final int denominator;


    Fraction(int numerator, int denominator) {
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
        else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction add(Fraction f) {
        int n = numerator*f.getDenominator() + f.getNumerator()*denominator;
        int d = denominator*f.getDenominator();
        return new Fraction(n, d).reduce();
    }

    public Fraction subtract(Fraction f) {
        int n = numerator*f.getDenominator() - f.getNumerator()*denominator;
        int d = denominator*f.getDenominator();
        return new Fraction(n, d).reduce();
    }

    public Fraction multiply(Fraction f) {
        int n = numerator*f.getNumerator();
        int d = denominator*f.getDenominator();
        return new Fraction(n, d).reduce();
    }

    public Fraction divide(Fraction f) {
        int n = numerator*f.getDenominator();
        int d = denominator*f.getNumerator();
        return new Fraction(n, d).reduce();
    }

    public Fraction reduce() {
        int k = _gcd(numerator, denominator);
        return new Fraction(numerator/k, denominator/k);
    }

    public boolean isInteger(){
        return numerator % denominator == 0;
    }

    @Override
    public int compareTo(Fraction f) {
        double v1 = 1.0*numerator/denominator;
        double v2 = 1.0*f.getNumerator()/f.getDenominator();

        return Double.compare(v1, v2);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }

    private int _gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return 1;
        }

        a = Math.abs(a);
        b = Math.abs(b);

        while (a != b) {
            if (a % b == 0){
                return b;
            }

            if (b % a == 0){
                return a;
            }

            if (a > b) {
                a -= b;
            }
            else {
                b -= a;
            }
        }

        return a;
    }
}