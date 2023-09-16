package chessknight

import spock.lang.Specification

class BoardTest extends Specification implements Matrices {

    def "should check whether toString() on Board returns expected value"() {
        expect:
        actual.toString() == expected

        where:
        expected                           | actual
        expectedMatrix3By4()               | matrix3By4()
        expectedMatrix10By10()             | matrix10By10()
        expectedMatrix3By4WithEmptyCells() | matrix3By4WithEmptyCells()
    }

}
