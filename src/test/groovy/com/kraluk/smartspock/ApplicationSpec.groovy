package com.kraluk.smartspock

import spock.lang.Specification

class ApplicationSpec extends Specification {

    def "should start the application"() {
        when:
            Application.main()

        then:
            noExceptionThrown()
    }
}
