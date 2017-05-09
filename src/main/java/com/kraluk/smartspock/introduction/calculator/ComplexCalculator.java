package com.kraluk.smartspock.introduction.calculator;

/**
 * Provides some more complex math operations on {@link Double} values
 *
 * @author lukasz
 */
public final class ComplexCalculator {

    private final Complex a;
    private final Complex b;

    private final Calculator reCalculator;
    private final Calculator imCalculator;

    public ComplexCalculator(final Complex a, final Complex b) {
        this.a = a;
        this.b = b;

        this.reCalculator = new Calculator(a.getRe(), b.getRe());
        this.imCalculator = new Calculator(a.getIm(), b.getIm());
    }

    public Complex add() {
        return new Complex(
            reCalculator.add(),
            imCalculator.add()
        );
    }

    public Complex subtract() {
        return new Complex(
            reCalculator.subtract(),
            imCalculator.subtract()
        );
    }

    // ----------------- Complex number class

    public static class Complex {

        private final double re;
        private final double im;

        public Complex(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }
    }
}
