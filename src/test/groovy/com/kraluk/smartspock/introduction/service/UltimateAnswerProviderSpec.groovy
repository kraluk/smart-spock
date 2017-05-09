package com.kraluk.smartspock.introduction.service

import spock.lang.Specification

class UltimateAnswerProviderSpec extends Specification {

    def "should get the only possible answer"() {
        given:
            def service = new UltimateAnswerProvider()

        when:
            def result = service.getAnswer()

        then:
            // https://issues.apache.org/jira/browse/GROOVY-1875
            result == UltimateAnswerProvider.THE_ANSWER_TO_THE_ULTIMATE_QUESTION_OF_LIFE_THE_UNIVERSE_AND_EVERYTHING
    }
}
