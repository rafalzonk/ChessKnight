package chessknight.calculators

import spock.lang.Specification

import static chessknight.calculators.PathCalculatorUtils.goEast
import static chessknight.calculators.PathCalculatorUtils.goNorth
import static chessknight.calculators.PathCalculatorUtils.goSouth
import static chessknight.calculators.PathCalculatorUtils.goWest

class PathCalculatorUtilsSpec extends Specification {

    def "should fill path correctly going east on first ring"() {
        given:
        def board = new int[size][size];

        expect:
        position == goEast(board, 1, startX, startY, 0);
        MatrixUtils.equals(board, expected)

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

    def "should fill path correctly going south on first ring"() {
        given:
        def board = new int[size][size];

        expect:
        position == goSouth(board, 1, startX, startY, 0);
        MatrixUtils.equals(board, expected)

        where:
        size | startX | startY || position                    | expected
        5    | 0      | 4      || new KnightPosition(4, 4, 3) | [[0, 0, 0, 0, 1], [0, 0, 0, 0, 0], [0, 0, 0, 2, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 3]] as int[][]
        5    | 0      | 3      || new KnightPosition(4, 3, 3) | [[0, 0, 0, 1, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 2], [0, 0, 0, 0, 0], [0, 0, 0, 3, 0]] as int[][]
        5    | 1      | 3      || new KnightPosition(3, 4, 2) | [[0, 0, 0, 0, 0], [0, 0, 0, 1, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 2], [0, 0, 0, 0, 0]] as int[][]
        5    | 1      | 4      || new KnightPosition(3, 3, 2) | [[0, 0, 0, 0, 0], [0, 0, 0, 0, 1], [0, 0, 0, 0, 0], [0, 0, 0, 2, 0], [0, 0, 0, 0, 0]] as int[][]
        9    | 0      | 8      || new KnightPosition(8, 8, 5) | [[0, 0, 0, 0, 0, 0, 0, 0, 1], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 2, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 3], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 4, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 5]] as int[][]
        9    | 0      | 7      || new KnightPosition(8, 7, 5) | [[0, 0, 0, 0, 0, 0, 0, 1, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 2], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 3, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 4], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 5, 0]] as int[][]
        9    | 1      | 7      || new KnightPosition(7, 8, 4) | [[0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 1, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 2], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 3, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 4], [0, 0, 0, 0, 0, 0, 0, 0, 0]] as int[][]
        9    | 1      | 8      || new KnightPosition(7, 7, 4) | [[0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 1], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 2, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 3], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 4, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0]] as int[][]
    }

    def "should fill path correctly going west on first ring"() {
        given:
        def board = new int[size][size];

        expect:
        position == goWest(board, 1, startX, startY, 0);
        MatrixUtils.equals(board, expected)

        where:
        size | startX | startY || position                    | expected
        5    | 3      | 4      || new KnightPosition(3, 0, 3) | [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [3, 0, 0, 0, 1], [0, 0, 2, 0, 0]] as int[][]
        5    | 4      | 4      || new KnightPosition(4, 0, 3) | [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 2, 0, 0], [3, 0, 0, 0, 1]] as int[][]
        5    | 3      | 3      || new KnightPosition(4, 1, 2) | [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 1, 0], [0, 2, 0, 0, 0]] as int[][]
        5    | 4      | 3      || new KnightPosition(3, 1, 2) | [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 2, 0, 0, 0], [0, 0, 0, 1, 0]] as int[][]
        9    | 7      | 8      || new KnightPosition(7, 0, 5) | [[0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [5, 0, 0, 0, 3, 0, 0, 0, 1], [0, 0, 4, 0, 0, 0, 2, 0, 0]] as int[][]
        9    | 8      | 8      || new KnightPosition(8, 0, 5) | [[0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 4, 0, 0, 0, 2, 0, 0], [5, 0, 0, 0, 3, 0, 0, 0, 1]] as int[][]
        9    | 7      | 7      || new KnightPosition(8, 1, 4) | [[0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 3, 0, 0, 0, 1, 0], [0, 4, 0, 0, 0, 2, 0, 0, 0]] as int[][]
        9    | 8      | 7      || new KnightPosition(7, 1, 4) | [[0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 4, 0, 0, 0, 2, 0, 0, 0], [0, 0, 0, 3, 0, 0, 0, 1, 0]] as int[][]
    }

    def "should fill path correctly going north on first ring"() {
        given:
        def board = new int[size][size];

        expect:
        position == goNorth(board, 1, startX, startY, 0);
        MatrixUtils.equals(board, expected)

        where:
        size | startX | startY || position                    | expected
        5    | 4      | 1      || new KnightPosition(0, 1, 3) | [[0, 3, 0, 0, 0], [0, 0, 0, 0, 0], [2, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 1, 0, 0, 0]] as int[][]
        5    | 4      | 0      || new KnightPosition(0, 0, 3) | [[3, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 2, 0, 0, 0], [0, 0, 0, 0, 0], [1, 0, 0, 0, 0]] as int[][]
        5    | 3      | 1      || new KnightPosition(1, 0, 2) | [[0, 0, 0, 0, 0], [2, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 1, 0, 0, 0], [0, 0, 0, 0, 0]] as int[][]
        5    | 3      | 0      || new KnightPosition(1, 1, 2) | [[0, 0, 0, 0, 0], [0, 2, 0, 0, 0], [0, 0, 0, 0, 0], [1, 0, 0, 0, 0], [0, 0, 0, 0, 0]] as int[][]
        9    | 8      | 1      || new KnightPosition(0, 1, 5) | [[0, 5, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [4, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 3, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [2, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 1, 0, 0, 0, 0, 0, 0, 0]] as int[][]
        9    | 8      | 0      || new KnightPosition(0, 0, 5) | [[5, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 4, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [3, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 2, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [1, 0, 0, 0, 0, 0, 0, 0, 0]] as int[][]
        9    | 7      | 1      || new KnightPosition(1, 0, 4) | [[0, 0, 0, 0, 0, 0, 0, 0, 0], [4, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 3, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [2, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 1, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0]] as int[][]
        9    | 7      | 0      || new KnightPosition(1, 1, 4) | [[0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 4, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [3, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 2, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [1, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0]] as int[][]
    }

    def "should not override existing value when going east"() {
        given:
        def board = new int[size][size];
        board[0][4] = 13

        expect:
        position == goEast(board, 1, startX, startY, 0);
        MatrixUtils.equals(board, expected)

        where:
        size | startX | startY || position                    | expected
        5    | 0      | 0      || new KnightPosition(1, 2, 2) | [[1, 0, 0, 0, 13], [0, 0, 2, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]] as int[][]
    }

    def "should not override existing value when going south"() {
        given:
        def board = new int[size][size];
        board[4][4] = 13

        expect:
        position == goSouth(board, 1, startX, startY, 0);
        MatrixUtils.equals(board, expected)

        where:
        size | startX | startY || position                    | expected
        5    | 0      | 4      || new KnightPosition(2, 3, 2) | [[0, 0, 0, 0, 1], [0, 0, 0, 0, 0], [0, 0, 0, 2, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 13]] as int[][]
    }

    def "should not override existing value when going west"() {
        given:
        def board = new int[size][size];
        board[4][0] = 13

        expect:
        position == goWest(board, 1, startX, startY, 0);
        MatrixUtils.equals(board, expected)

        where:
        size | startX | startY || position                    | expected
        5    | 4      | 4      || new KnightPosition(3, 2, 2) | [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 2, 0, 0], [13, 0, 0, 0, 1]] as int[][]
    }

    def "should not override existing value when going north"() {
        given:
        def board = new int[size][size];
        board[0][0] = 13

        expect:
        position == goNorth(board, 1, startX, startY, 0);
        MatrixUtils.equals(board, expected)

        where:
        size | startX | startY || position                    | expected
        5    | 4      | 0      || new KnightPosition(2, 1, 2) | [[13, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 2, 0, 0, 0], [0, 0, 0, 0, 0], [1, 0, 0, 0, 0]] as int[][]
    }

}