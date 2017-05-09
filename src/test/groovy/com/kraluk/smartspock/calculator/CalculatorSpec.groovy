package com.kraluk.smartspock.calculator

import spock.lang.Specification
import spock.lang.Unroll

class CalculatorSpec extends Specification {

    @Unroll
    def "should add #a + #b = #c"() {
        given:
            def calculator = new Calculator(a, b)
        when:
            def result = calculator.add()

        then:
            result == c as double

        where:
            a   || b   || c
            2.0 || 1.0 || 3.0
            2.3 || 2.0 || 4.3
    }

    def "should add a / b = c"() {
        given: "given"
            def calculator = new Calculator(a, b)
        when:
            def result = calculator.divide()

        then:
            def e = thrown(Exception)
        and:
            e.cause == null && e.message == null

        where:
            a || b || c
            1 || 0 || _
    }
}
