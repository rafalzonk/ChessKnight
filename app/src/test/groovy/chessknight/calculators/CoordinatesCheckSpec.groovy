package chessknight.calculators

import spock.lang.Specification

import static chessknight.calculators.PathCalculatorUtils.withinInnerRing
import static chessknight.calculators.PathCalculatorUtils.withinOuterRing
import static chessknight.calculators.PathCalculatorUtils.withinRing

class CoordinatesCheckSpec extends Specification {
    def "should check whether coordinates are within outer ring"() {
        given:
        def board = matrix10x10()

        expect:
        result == withinOuterRing(board, x, y, ringLevel)

        where:
        x | y | ringLevel || result
        0 | 0 | 0         || false
        1 | 1 | 0         || false
        9 | 9 | 0         || false
        0 | 0 | 1         || true
        1 | 1 | 1         || true
        9 | 9 | 1         || true
        3 | 3 | 0         || false
        3 | 3 | 1         || false
        3 | 3 | 2         || true
    }

    def "should check whether coordinates are within inner ring"() {
        given:
        def board = matrix10x10()

        expect:
        result == withinInnerRing(board, x, y, ringLevel)

        where:
        x | y | ringLevel || result
        0 | 0 | 0         || false
        1 | 1 | 0         || false
        2 | 2 | 0         || true
        7 | 7 | 0         || true
        8 | 8 | 0         || false
        9 | 9 | 0         || false
        2 | 2 | 1         || false
        3 | 3 | 1         || false
        4 | 4 | 1         || true
        5 | 5 | 1         || true
        6 | 6 | 1         || false
        7 | 7 | 1         || false
    }

    def "should check whether coordinates are within given ring"() {
        given:
        def board = matrix10x10()

        expect:
        result == withinRing(board, x, y, ringLevel)

        where:
        x | y | ringLevel || result
        0 | 0 | 0         || true
        1 | 1 | 0         || true
        2 | 2 | 0         || false
        7 | 7 | 0         || false
        8 | 8 | 0         || true
        9 | 9 | 0         || true
        0 | 0 | 1         || false
        1 | 1 | 1         || false
        2 | 2 | 1         || true
        3 | 3 | 1         || true
        4 | 4 | 1         || false
        5 | 5 | 1         || false
        6 | 6 | 1         || true
        7 | 7 | 1         || true
        8 | 8 | 1         || false
        3 | 3 | 2         || false
        4 | 4 | 2         || true
        5 | 5 | 2         || true
        6 | 6 | 2         || false
    }

    private matrix10x10() {
        new int[10][10]
    }
}
