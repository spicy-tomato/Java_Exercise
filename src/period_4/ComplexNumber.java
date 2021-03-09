package period_4;

public class ComplexNumber {

    private final double real;
    private final double imaginary;

    public ComplexNumber() {
        real = 1;
        imaginary = -1;
    }

    public ComplexNumber(double real, double virtual) {
        this.real = real;
        this.imaginary = virtual;
    }

        public double getReal() {
            return real;
        }

        public double getImaginary() {
            return imaginary;
        }

    public ComplexNumber add(ComplexNumber number) {
        double _real = real + number.real;
        double _virtual = imaginary + number.imaginary;

        return new ComplexNumber(_real, _virtual);
    }

    public ComplexNumber divide(double number) {
        double _real = real/number;
        double _virtual = imaginary/number;

        return new ComplexNumber(_real, _virtual);
    }

    public double module() {
        return Math.sqrt(real*real + imaginary*imaginary);
    }

    public boolean isRealNumber() {
        return imaginary == 0;
    }

    @Override
    public String toString() {
        if (imaginary < 0) {
            return String.format("%.1f - %.1fi", real, -imaginary);
        }

        return String.format("%.1f + %.1fi", real, imaginary);
    }
}
