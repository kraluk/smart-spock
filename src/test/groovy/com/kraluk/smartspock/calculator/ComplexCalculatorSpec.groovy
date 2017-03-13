package com.kraluk.smartspock.calculator

import spock.lang.Specification
import spock.lang.Unroll

import static com.kraluk.smartspock.calculator.ComplexCalculator.Complex

class ComplexCalculatorSpec extends Specification {

    def "should add complex numbers"() {

        given:
            def a = new Complex(1, 2)
            def b = new Complex(1, 2)

            def calculator = new ComplexCalculator(a, b)

        when:
            def result = calculator.add()

        then:
            with(result) {
                re == 2
                im == 4
            }
    }

    @Unroll
    def "should subtract complex numbers"() {

        given:
            def a = new Complex(aRe, aIm)
            def b = new Complex(bRe, bIm)

            def calculator = new ComplexCalculator(a, b)

        when:
            def result = calculator.subtract()

        then:
            with(result) {
                re == resultRe as double
                im == resultIm
            }

            notThrown(Exception.class) // == noExceptionThrown()

        where:
            aRe || aIm || bRe || bIm || resultRe || resultIm
            1.0 || 1.0 || 2.0 || 2.0 || -1.0     || -1.0
            4.0 || 2.0 || 1.0 || 1.0 || 3.0      || 1.0

    }
}
