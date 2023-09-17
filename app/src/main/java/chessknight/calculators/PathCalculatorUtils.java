package chessknight.calculators;

class PathCalculatorUtils {

    static KnightPosition goEast(int[][] board, int step, int startX, int startY, int ringLevel) {
        var x = startX;
        var y = startY;

        var tmpX = x;
        var tmpY = y;

        do {
            board[x][y] = step++;
            tmpX = x;
            tmpY = y;
            x += (x % 2 == 0 ? 1 : -1);
            y += 2;
        } while (withinRing(board, x, y, ringLevel));

        return new KnightPosition(tmpX, tmpY, step);
    }

    static KnightPosition goSouth(int[][] board, int step, int startX, int startY, int ringLevel) {
        return null;
    }

    static KnightPosition goWest(int[][] board, int step, int startX, int startY, int ringLevel) {
        return null;
    }

    static KnightPosition goNorth(int[][] board, int step, int startX, int startY, int ringLevel) {
        return null;
    }

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
}