package chessknight.calculators

import spock.lang.Specification

class SquarePathCalculator1X1Spec extends Specification {
    def "should find correct path for size"() {
        SquarePathCalculator1X1 calculator1X1 = new SquarePathCalculator1X1()

        def path = calculator1X1.calculatePath(size)
        print(path)

        where:
        size | _
        5    | _
        9    | _
        13   | _
    }
}
