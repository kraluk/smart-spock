package com.kraluk.smartspock.calculator;

/**
 * Simple calculator
 *
 * @author lukasz
 */
public final class Calculator {

    private final double a;
    private final double b;

    public Calculator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double add() {
        return a + b;
    }

    public double subtract() {
        return a - b;
    }

    public double multiply() {
        return a * b;
    }

    public double divide() {
        if (b == 0) {
            throw new IllegalArgumentException("Dividing by 0 is illegal!");
        }

        return a / b;
    }
}
