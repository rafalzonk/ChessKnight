package chessknight.calculators

import spock.lang.Specification

import static chessknight.calculators.PathCalculatorUtils.goEast

class PathCalculatorUtilsSpec extends Specification {

    def "should fill path correctly going east on first ring"() {
        given:
        def board = new int[size][size];

        expect:
        position == goEast(board, 1, startX, startY, 0);
        MatrixUtils.equals(board, expected)

        print(board)
        print(expected)

        where:
        size | startX | startY || position                    | expected
        5    | 0      | 0      || new KnightPosition(0, 4, 3) | [[1, 0, 0, 0, 3], [0, 0, 2, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]] as int[][]
        5    | 0      | 1      || new KnightPosition(1, 3, 2) | [[0, 1, 0, 0, 0], [0, 0, 0, 2, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]] as int[][]
        5    | 1      | 0      || new KnightPosition(1, 4, 3) | [[0, 0, 2, 0, 0], [1, 0, 0, 0, 3], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]] as int[][]
        5    | 1      | 1      || new KnightPosition(0, 3, 2) | [[0, 0, 0, 2, 0], [0, 1, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]] as int[][]
        9    | 0      | 0      || new KnightPosition(0, 8, 5) | [[1, 0, 0, 0, 3, 0, 0, 0, 5], [0, 0, 2, 0, 0, 0, 4, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0]] as int[][]
        9    | 0      | 1      || new KnightPosition(1, 7, 4) | [[0, 1, 0, 0, 0, 3, 0, 0, 0], [0, 0, 0, 2, 0, 0, 0, 4, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0]] as int[][]
        9    | 1      | 0      || new KnightPosition(1, 8, 5) | [[0, 0, 2, 0, 0, 0, 4, 0, 0], [1, 0, 0, 0, 3, 0, 0, 0, 5], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0]] as int[][]
        9    | 1      | 1      || new KnightPosition(0, 7, 4) | [[0, 0, 0, 2, 0, 0, 0, 4, 0], [0, 1, 0, 0, 0, 3, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0]] as int[][]
    }

}