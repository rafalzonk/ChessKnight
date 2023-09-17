package chessknight.calculators

import spock.lang.Specification

class MatrixUtilsTest extends Specification implements MatrixUtilsTestData {
    def "should correctly compare two matrices"() {
        expect:
        MatrixUtils.equals(a, b) == result

        where:
        a           | b                    | result
        null        | null                 | true
        null        | matrix2x2()          | false
        matrix2x2() | null                 | false
        matrix1x1() | matrix1x1()          | true
        matrix2x2() | matrix2x2()          | true
        matrix1x1() | matrix2x2()          | false
        matrix2x2() | matrix1x1()          | false
        matrix1x1() | [[13]] as int[][]    | true
        matrix1x1() | [[14]] as int[][]    | false
        matrix2x2() | theSameMatrix2x2()   | true
        matrix2x2() | differentMatrix2x2() | false
    }

    int[][] theSameMatrix2x2() {
        [[1, 2], [3, 4]]
    }

    int[][] differentMatrix2x2() {
        [[1, 2], [5, 6]]
    }
}
