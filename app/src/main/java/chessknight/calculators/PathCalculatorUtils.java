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
            if (!isFree(board, x, y)) {
                x += (x % 2 == 0 ? 2 : -2);
            }
        } while (canMove(board, ringLevel, x, y));

        return new KnightPosition(tmpX, tmpY, board[tmpX][tmpY]);
    }

    static KnightPosition goSouth(int[][] board, int step, int startX, int startY, int ringLevel) {
        var x = startX;
        var y = startY;

        var tmpX = x;
        var tmpY = y;

        var easternBorder = board[0].length - (ringLevel * 2) - 1;

        do {
            board[x][y] = step++;
            tmpX = x;
            tmpY = y;
            x += 2;
            y += (easternBorder == y ? -1 : 1);
            if (!isFree(board, x, y)) {
                y += (easternBorder == y ? -2 : 2);
            }
        } while (canMove(board, ringLevel, x, y));

        return new KnightPosition(tmpX, tmpY, board[tmpX][tmpY]);
    }

    static KnightPosition goWest(int[][] board, int step, int startX, int startY, int ringLevel) {
        var x = startX;
        var y = startY;

        var tmpX = x;
        var tmpY = y;

        var southernBorder = board.length - (ringLevel * 2) - 1;

        do {
            board[x][y] = step++;
            tmpX = x;
            tmpY = y;
            x += (southernBorder == x ? -1 : 1);
            y -= 2;
            if (!isFree(board, x, y)) {
                x += (southernBorder == x ? -2 : 2);
            }
        } while (canMove(board, ringLevel, x, y));

        return new KnightPosition(tmpX, tmpY, board[tmpX][tmpY]);
    }

    static KnightPosition goNorth(int[][] board, int step, int startX, int startY, int ringLevel) {
        var x = startX;
        var y = startY;

        var tmpX = x;
        var tmpY = y;

        do {
            board[x][y] = step++;
            tmpX = x;
            tmpY = y;
            x -= 2;
            y += (y % 2 == 0 ? 1 : -1);
            if (!isFree(board, x, y)) {
                y += (y % 2 == 0 ? 2 : -2);
            }
        } while (canMove(board, ringLevel, x, y));

        return new KnightPosition(tmpX, tmpY, board[tmpX][tmpY]);
    }

    static KnightPosition stepNW(int[][] board, KnightPosition knightPosition) {
        var newPosition = new KnightPosition(knightPosition.x() - 2, knightPosition.y() - 1, knightPosition.step() + 1);
        board[newPosition.x()][newPosition.y()] = newPosition.step();
        return newPosition;
    }

    static KnightPosition stepNE(int[][] board, KnightPosition knightPosition) {
        var newPosition = new KnightPosition(knightPosition.x() - 2, knightPosition.y() + 1, knightPosition.step() + 1);
        board[newPosition.x()][newPosition.y()] = newPosition.step();
        return newPosition;
    }

    static KnightPosition stepEN(int[][] board, KnightPosition knightPosition) {
        var newPosition = new KnightPosition(knightPosition.x() - 1, knightPosition.y() + 2, knightPosition.step() + 1);
        board[newPosition.x()][newPosition.y()] = newPosition.step();
        return newPosition;
    }

    static KnightPosition stepES(int[][] board, KnightPosition knightPosition) {
        var newPosition = new KnightPosition(knightPosition.x() + 1, knightPosition.y() + 2, knightPosition.step() + 1);
        board[newPosition.x()][newPosition.y()] = newPosition.step();
        return newPosition;
    }

    static KnightPosition stepSE(int[][] board, KnightPosition knightPosition) {
        var newPosition = new KnightPosition(knightPosition.x() + 2, knightPosition.y() + 1, knightPosition.step() + 1);
        board[newPosition.x()][newPosition.y()] = newPosition.step();
        return newPosition;
    }

    static KnightPosition stepSW(int[][] board, KnightPosition knightPosition) {
        var newPosition = new KnightPosition(knightPosition.x() + 2, knightPosition.y() - 1, knightPosition.step() + 1);
        board[newPosition.x()][newPosition.y()] = newPosition.step();
        return newPosition;
    }

    static KnightPosition stepWS(int[][] board, KnightPosition knightPosition) {
        var newPosition = new KnightPosition(knightPosition.x() + 1, knightPosition.y() - 2, knightPosition.step() + 1);
        board[newPosition.x()][newPosition.y()] = newPosition.step();
        return newPosition;
    }

    static KnightPosition stepWN(int[][] board, KnightPosition knightPosition) {
        var newPosition = new KnightPosition(knightPosition.x() - 1, knightPosition.y() - 2, knightPosition.step() + 1);
        board[newPosition.x()][newPosition.y()] = newPosition.step();
        return newPosition;
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

    private static boolean isFree(int[][] board, int x, int y) {
        return x >= 0 && x < board.length &&
                y >= 0 && y < board[0].length &&
                board[x][y] == 0;
    }

    private static boolean canMove(int[][] board, int ringLevel, int x, int y) {
        return isFree(board, x, y) && withinRing(board, x, y, ringLevel);
    }

    static KnightPosition circleStartingEast(KnightPosition position, int[][] board, int ringLevel) {
        position = goEast(board, position.step(), position.x(), position.y(), ringLevel);
        position = goSouth(board, position.step(), position.x(), position.y(), ringLevel);
        position = goWest(board, position.step(), position.x(), position.y(), ringLevel);
        position = goNorth(board, position.step(), position.x(), position.y(), ringLevel);
        return position;
    }

    static KnightPosition circleStartingWest(KnightPosition position, int[][] board, int ringLevel) {
        position = goWest(board, position.step(), position.x(), position.y(), ringLevel);
        position = goNorth(board, position.step(), position.x(), position.y(), ringLevel);
        position = goEast(board, position.step(), position.x(), position.y(), ringLevel);
        position = goSouth(board, position.step(), position.x(), position.y(), ringLevel);
        return position;
    }

    static KnightPosition circleStartingSouth(KnightPosition position, int[][] board, int ringLevel) {
        position = goSouth(board, position.step(), position.x(), position.y(), ringLevel);
        position = goWest(board, position.step(), position.x(), position.y(), ringLevel);
        position = goNorth(board, position.step(), position.x(), position.y(), ringLevel);
        position = goEast(board, position.step(), position.x(), position.y(), ringLevel);
        return position;
    }
}
