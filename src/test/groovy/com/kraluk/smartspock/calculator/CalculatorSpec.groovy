package com.kraluk.smartspock.calculator

import spock.lang.Specification
import spock.lang.Unroll

class CalculatorSpec extends Specification {

    def "should calculate a + b"() {

        given:
            def a = 1.0
            def b = 1.0
            def expected = 2.0 as double
            def calculator = new Calculator(a, b)

        when:
            def result = calculator.add()

        then:
            result == expected
            someComplexAssertions(result)
            moreUsefulComplexAssertions(result)
    }

    @Unroll
    def "should calculate #a - #b = #expected"() {

        setup:
            def calculator = new Calculator(a, b)

        expect:
            expected == calculator.subtract()

        where:
            a    || b    || expected
            2.0  || 2.0  || 0.0
            9.99 || 0.99 || 9
    }

    def "should calculate a * b"() {

        given:
            def calculator = new Calculator(a, b)

        expect:
            result as double == calculator.multiply()

        where:
            a << [2.0, 2.5]
            b << [2.0, 2.5]
            result << [4.0, 6.25]
    }

    def "should calculate a / b"() {

        given:
            def calculator = new Calculator(a, b)

        when:
            def result = calculator.divide()

        then:
            result == expected
            noExceptionThrown()

        where:
            a   || b   || expected
            2.0 || 2.0 || 1.0 as double
            9.0 || 3.0 || 3.0
    }

    def "should *not* calculate a / b"() {

        when: "we try to divide by 0"
            new Calculator(1, 0).divide()

        then: "an Exception should be thrown!"
            def e = thrown(IllegalArgumentException)
        and: "with no previous cause"
            e.cause == null
        and: "and with some important message"
            e.message != null
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
