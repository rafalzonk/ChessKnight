package chessknight.calculators;

class PathCalculatorUtils {

    static boolean withinRing(int[][] board, int x, int y, int ringLevel) {
        return !withinInnerRing(board, x, y, ringLevel) && !withinOuterRing(board, x, y, ringLevel);
    }

    static boolean withinOuterRing(int[][] board, int x, int y, int ringLevel) {
        return ringLevel < 0 ||
                !withinInnerRing(board, x, y, ringLevel - 1);
    }

    static boolean withinInnerRing(int[][] board, int x, int y, int ringLevel) {
        return x >= (1 + ringLevel) * 2 && x < (board.length - (1 + ringLevel) * 2) &&
                y >= (1 + ringLevel) * 2 && y < (board[0].length - (1 + ringLevel) * 2);
    }

    static boolean isFree(int[][] board, int x, int y) {
        return x >= 0 && x < board.length &&
                y >= 0 && y < board[0].length &&
                board[x][y] == 0;
    }

    static boolean canMove(int[][] board, int ringLevel, int x, int y) {
        return isFree(board, x, y) && withinRing(board, x, y, ringLevel);
    }

}
