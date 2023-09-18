package chessknight.calculators

import spock.lang.Specification

class SquarePathCalculatorSpec extends Specification {
    def "should find correct path for size 4n+1"() {
        def calculator = new SquarePathCalculator1X1()

        def path = calculator.calculatePath(size)
        print(path)

        where:
        size | _
        5    | _
        9    | _
        13   | _
    }

    def "should find correct path for size 4n+2"() {
        def calculator = new SquarePathCalculator2X2()

        def path = calculator.calculatePath(size)
        print(path)

        where:
        size | _
        6    | _
        10   | _
        14   | _
    }
}
