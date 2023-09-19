package chessknight.calculators

import spock.lang.Specification

class SquarePathCalculatorSpec extends Specification {
    def "should find correct path for size 4n+1"() {
        def path = new SquarePathCalculator1X1().calculatePath(size)
        print(path)

        where:
        size | _
        5    | _
        9    | _
        13   | _
    }

    def "should find correct path for size 4n+2"() {
        def path = new SquarePathCalculator2X2().calculatePath(size)
        print(path)

        where:
        size | _
        6    | _
        10   | _
        14   | _
    }

    def "should find correct path for size 4n+3"() {
        def path = new SquarePathCalculator3X3().calculatePath(size)
        print(path)

        where:
        size | _
        7    | _
        11   | _
        15   | _
        19   | _
    }
}
