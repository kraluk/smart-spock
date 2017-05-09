package com.kraluk.smartspock.introduction.task

import com.kraluk.smartspock.introduction.service.UltimateAnswerProvider
import spock.lang.Specification

class CalculationTaskSpec extends Specification {
    static double ULTIMATE_ANSWER_MOCK = 1

    def "should calculate the result without using any mock"() {
        given:
            def provider = new UltimateAnswerProvider()
        and:
            def task = new CalculationTask(provider)

        when:
            def result = task.getResult()

        then:
            result == 42 + 42
    }

    def "should calculate the result with using an UltimateAnswerProvider mock"() {
        given:
            UltimateAnswerProvider provider = Mock() {
                2 * getAnswer() >> ULTIMATE_ANSWER_MOCK
            }
        and:
            def task = new CalculationTask(provider)

        when:
            def result = task.getResult()

        then:
            result == ULTIMATE_ANSWER_MOCK + ULTIMATE_ANSWER_MOCK
    }
}
