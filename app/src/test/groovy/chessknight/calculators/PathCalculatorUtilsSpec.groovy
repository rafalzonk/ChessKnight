package chessknight.calculators

import spock.lang.Specification

import static chessknight.calculators.MatrixUtils.equals
import static chessknight.calculators.PathCalculatorUtils.circleStartingEast
import static chessknight.calculators.PathCalculatorUtils.circleStartingSouth
import static chessknight.calculators.PathCalculatorUtils.circleStartingWest
import static chessknight.calculators.PathCalculatorUtils.goEast
import static chessknight.calculators.PathCalculatorUtils.goNorth
import static chessknight.calculators.PathCalculatorUtils.goSouth
import static chessknight.calculators.PathCalculatorUtils.goWest
import static chessknight.calculators.PathCalculatorUtils.stepEN
import static chessknight.calculators.PathCalculatorUtils.stepES
import static chessknight.calculators.PathCalculatorUtils.stepNE
import static chessknight.calculators.PathCalculatorUtils.stepNW
import static chessknight.calculators.PathCalculatorUtils.stepSE
import static chessknight.calculators.PathCalculatorUtils.stepSW
import static chessknight.calculators.PathCalculatorUtils.stepWN
import static chessknight.calculators.PathCalculatorUtils.stepWS

class PathCalculatorUtilsSpec extends Specification {

    def "should fill path correctly going east on first ring"() {
        given:
        def board = new int[size][size]

        expect:
        position == goEast(board, 1, startX, startY, 0)
        equals(board, expected)

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
        def board = new int[size][size]

        expect:
        position == goSouth(board, 1, startX, startY, 0)
        equals(board, expected)

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
        def board = new int[size][size]

        expect:
        position == goWest(board, 1, startX, startY, 0)
        equals(board, expected)

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
        def board = new int[size][size]

        expect:
        position == goNorth(board, 1, startX, startY, 0)
        equals(board, expected)

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

    def "should choose alternative path within same ring when going east"() {
        given:
        def board = new int[size][size]
        board[0][4] = 13

        expect:
        position == goEast(board, 1, startX, startY, 0)
        equals(board, expected)

        where:
        size | startX | startY || position                    | expected
        5    | 0      | 0      || new KnightPosition(2, 4, 3) | [[1, 0, 0, 0, 13], [0, 0, 2, 0, 0], [0, 0, 0, 0, 3], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]] as int[][]
    }

    def "should choose alternative path within same ring when going south"() {
        given:
        def board = new int[size][size]
        board[4][4] = 13

        expect:
        position == goSouth(board, 1, startX, startY, 0)
        equals(board, expected)

        where:
        size | startX | startY || position                    | expected
        5    | 0      | 4      || new KnightPosition(4, 2, 3) | [[0, 0, 0, 0, 1], [0, 0, 0, 0, 0], [0, 0, 0, 2, 0], [0, 0, 0, 0, 0], [0, 0, 3, 0, 13]] as int[][]
    }

    def "should choose alternative path within same ring when going west"() {
        given:
        def board = new int[size][size]
        board[4][0] = 13

        expect:
        position == goWest(board, 1, startX, startY, 0)
        equals(board, expected)

        where:
        size | startX | startY || position                    | expected
        5    | 4      | 4      || new KnightPosition(2, 0, 3) | [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [3, 0, 0, 0, 0], [0, 0, 2, 0, 0], [13, 0, 0, 0, 1]] as int[][]
    }

    def "should choose alternative path within same ring when going north"() {
        given:
        def board = new int[size][size]
        board[0][0] = 13

        expect:
        position == goNorth(board, 1, startX, startY, 0)
        equals(board, expected)

        where:
        size | startX | startY || position                    | expected
        5    | 4      | 0      || new KnightPosition(0, 2, 3) | [[13, 0, 3, 0, 0], [0, 0, 0, 0, 0], [0, 2, 0, 0, 0], [0, 0, 0, 0, 0], [1, 0, 0, 0, 0]] as int[][]
    }

    def "should correctly use all steps"() {
        given:
        def board = new int[7][7]
        def position = new KnightPosition(0, 3, 0)

        when:
        position = stepES(board, position)
        position = stepSE(board, position)
        position = stepSW(board, position)
        position = stepWS(board, position)
        position = stepWN(board, position)
        position = stepNW(board, position)
        position = stepNE(board, position)
        position = stepEN(board, position)

        then:
        position == new KnightPosition(0, 3, 8)
        def expected = [[0, 0, 0, 8, 0, 0, 0], [0, 7, 0, 0, 0, 1, 0], [0, 0, 0, 0, 0, 0, 0], [6, 0, 0, 0, 0, 0, 2], [0, 0, 0, 0, 0, 0, 0], [0, 5, 0, 0, 0, 3, 0], [0, 0, 0, 4, 0, 0, 0]] as int[][]
        equals(board, expected)
    }

    def "should fill path correctly when going in circles starting east"() {
        given:
        def board = new int[size][size]
        var position = new KnightPosition(0, 0, 1);

        expect:
        expectedPosition == circleStartingEast(position, board, 0);
        equals(board, expectedBoard as int[][])

        expectedPosition2 == circleStartingEast(expectedPosition, board, 0);
        equals(board, expectedBoard2 as int[][])

        where:
        size || expectedPosition             | expectedPosition2            | expectedBoard                                                                                                                                                                                                        | expectedBoard2
        5    || new KnightPosition(0, 2, 9)  | new KnightPosition(0, 1, 14) | [[1, 0, 9, 0, 3], [0, 0, 2, 0, 0], [0, 8, 0, 4, 0], [0, 0, 6, 0, 0], [7, 0, 0, 0, 5]]                                                                                                                                | [[1, 14, 9, 0, 3], [0, 0, 2, 0, 10], [13, 8, 0, 4, 0], [0, 0, 6, 11, 0], [7, 12, 0, 0, 5]]
        6    || new KnightPosition(0, 2, 9)  | new KnightPosition(1, 0, 16) | [[1, 0, 9, 0, 3, 0], [0, 0, 2, 0, 0, 0], [0, 8, 0, 0, 0, 4], [0, 0, 0, 0, 0, 0], [7, 0, 0, 0, 5, 0], [0, 0, 6, 0, 0, 0]]                                                                                             | [[1, 0, 9, 0, 3, 0], [16, 0, 2, 0, 10, 0], [0, 8, 0, 0, 0, 4], [0, 15, 0, 0, 0, 11], [7, 0, 13, 0, 5, 0], [14, 0, 6, 0, 12, 0]]
        7    || new KnightPosition(0, 1, 12) | new KnightPosition(1, 0, 22) | [[1, 12, 0, 0, 3, 0, 0], [0, 0, 2, 0, 0, 0, 4], [11, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 5, 0], [0, 10, 0, 0, 0, 0, 0], [0, 0, 8, 0, 0, 0, 6], [9, 0, 0, 0, 7, 0, 0]]                                                 | [[1, 12, 0, 0, 3, 14, 0], [22, 0, 2, 13, 0, 0, 4], [11, 0, 0, 0, 0, 0, 15], [0, 21, 0, 0, 0, 5, 0], [0, 10, 0, 0, 0, 16, 0], [20, 0, 8, 0, 18, 0, 6], [9, 0, 19, 0, 7, 0, 17]]
        8    || new KnightPosition(0, 2, 13) | new KnightPosition(1, 0, 24) | [[1, 0, 13, 0, 3, 0, 0, 0], [0, 0, 2, 0, 0, 0, 4, 0], [0, 12, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 5], [11, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 6, 0], [0, 10, 0, 0, 0, 8, 0, 0], [0, 0, 0, 9, 0, 0, 0, 7]] | [[1, 0, 13, 0, 3, 0, 15, 0], [24, 0, 2, 0, 14, 0, 4, 0], [0, 12, 0, 0, 0, 0, 0, 16], [0, 23, 0, 0, 0, 0, 0, 5], [11, 0, 0, 0, 0, 0, 17, 0], [22, 0, 0, 0, 0, 0, 6, 0], [0, 10, 0, 20, 0, 8, 0, 18], [0, 21, 0, 9, 0, 19, 0, 7]]

    }

    def "should fill path correctly when going in circles starting west"() {
        given:
        def board = new int[size][size]
        var position = new KnightPosition(size - 1, size - 1, 1);

        expect:
        expectedPosition == circleStartingWest(position, board, 0);
        equals(board, expectedBoard as int[][])

        expectedPosition2 == circleStartingWest(expectedPosition, board, 0);
        equals(board, expectedBoard2 as int[][])

        where:
        size || expectedPosition                           | expectedPosition2                          | expectedBoard                                                                                                                                                                                                        | expectedBoard2
        5    || new KnightPosition(size - 1, size - 3, 9)  | new KnightPosition(size - 1, size - 2, 14) | [[5, 0, 0, 0, 7], [0, 0, 6, 0, 0], [0, 4, 0, 8, 0], [0, 0, 2, 0, 0], [3, 0, 9, 0, 1]]                                                                                                                                | [[5, 0, 0, 12, 7], [0, 11, 6, 0, 0], [0, 4, 0, 8, 13], [10, 0, 2, 0, 0], [3, 0, 9, 14, 1]]
        6    || new KnightPosition(size - 1, size - 3, 9)  | new KnightPosition(size - 2, size - 1, 16) | [[0, 0, 0, 6, 0, 0], [0, 5, 0, 0, 0, 7], [0, 0, 0, 0, 0, 0], [4, 0, 0, 0, 8, 0], [0, 0, 0, 2, 0, 0], [0, 3, 0, 9, 0, 1]]                                                                                             | [[0, 12, 0, 6, 0, 14], [0, 5, 0, 13, 0, 7], [11, 0, 0, 0, 15, 0], [4, 0, 0, 0, 8, 0], [0, 10, 0, 2, 0, 16], [0, 3, 0, 9, 0, 1]]
        7    || new KnightPosition(size - 1, size - 2, 12) | new KnightPosition(size - 2, size - 1, 22) | [[0, 0, 7, 0, 0, 0, 9], [6, 0, 0, 0, 8, 0, 0], [0, 0, 0, 0, 0, 10, 0], [0, 5, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 11], [4, 0, 0, 0, 2, 0, 0], [0, 0, 3, 0, 0, 12, 1]]                                                 | [[17, 0, 7, 0, 19, 0, 9], [6, 0, 18, 0, 8, 0, 20], [0, 16, 0, 0, 0, 10, 0], [0, 5, 0, 0, 0, 21, 0], [15, 0, 0, 0, 0, 0, 11], [4, 0, 0, 13, 2, 0, 22], [0, 14, 3, 0, 0, 12, 1]]
        8    || new KnightPosition(size - 1, size - 3, 13) | new KnightPosition(size - 2, size - 1, 24) | [[7, 0, 0, 0, 9, 0, 0, 0], [0, 0, 8, 0, 0, 0, 10, 0], [0, 6, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 11], [5, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 12, 0], [0, 4, 0, 0, 0, 2, 0, 0], [0, 0, 0, 3, 0, 13, 0, 1]] | [[7, 0, 19, 0, 9, 0, 21, 0], [18, 0, 8, 0, 20, 0, 10, 0], [0, 6, 0, 0, 0, 0, 0, 22], [0, 17, 0, 0, 0, 0, 0, 11], [5, 0, 0, 0, 0, 0, 23, 0], [16, 0, 0, 0, 0, 0, 12, 0], [0, 4, 0, 14, 0, 2, 0, 24], [0, 15, 0, 3, 0, 13, 0, 1]]

    }

}