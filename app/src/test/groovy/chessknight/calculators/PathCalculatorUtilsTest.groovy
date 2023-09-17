package chessknight.calculators

import spock.lang.Specification

import static chessknight.calculators.PathCalculatorUtils.goEast

class PathCalculatorUtilsTest extends Specification implements PathCalculatorUtilsTestData {

    def "should fill path correctly going east on first ring"() {
        given:
        def board = new int[size][size];

        expect:
        position == goEast(board, 1, startX, startY, 0);
        MatrixUtils.equals(board, expected)

        where:
        size | startX | startY || expected                                                                                         | position
        5    | 0      | 0      || [[1, 0, 0, 0, 3], [0, 0, 2, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]] as int[][] | null
        5    | 0      | 1      || [[0, 1, 0, 0, 0], [0, 0, 0, 2, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]] as int[][] | null
        5    | 1      | 0      || [[0, 0, 2, 0, 0], [1, 0, 0, 0, 3], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]] as int[][] | null
        5    | 1      | 1      || [[0, 0, 0, 2, 0], [0, 1, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]] as int[][] | null
        5    | 1      | 1      || [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]] as int[][] | null
    }

}