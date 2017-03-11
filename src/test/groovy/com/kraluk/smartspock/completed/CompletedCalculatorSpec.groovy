package com.kraluk.smartspock.completed

import com.kraluk.smartspock.calculator.Calculator
import spock.lang.Specification

class CompletedCalculatorSpec extends Specification {

    def "should calculate a + b"() {
        given:
            def a = 1.0
            def b = 1.0
            def expected = 2.0
            def calculator = new Calculator(a, b)

        when:
            def result = calculator.add()

        then:
            result == expected
            someComplexAssertions(result)
            moreUsefulComplexAssertions(result)
    }

    def "should calculate a - b"() {
        setup:
            def calculator = new Calculator(a, b)

        expect:
            result == calculator.subtract()

        where:
            a    || b    || result
            2.0  || 2.0  || 0.0
            9.99 || 0.99 || 9
    }

    def someComplexAssertions(a) {
        a > 0 && a != 0 && a != null
    }

    void moreUsefulComplexAssertions(a) {
        assert a > 0
        assert a != 0
        assert a != null
    }

    void someFalseComplexAssertions(a) {
        assert a < 0
        assert a == 0
        assert a == null
    }
}
