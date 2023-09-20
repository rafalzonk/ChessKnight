package chessknight.calculators;

import java.util.Arrays;
import java.util.Objects;

import static chessknight.calculators.PathCalculatorUtils.canMove;
import static chessknight.calculators.PathCalculatorUtils.isFree;

class KnightPosition {

    private final int x;
    private final int y;
    private final int n;
    private final int[][] board;

    public int[][] getBoard() {
        return board;
    }

    public KnightPosition(int x, int y, int n, int[][] board) {
        this.x = x;
        this.y = y;
        this.n = n;
        this.board = board;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KnightPosition that = (KnightPosition) o;
        return x == that.x && y == that.y && n == that.n && Arrays.deepEquals(board, that.board);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(x, y, n);
        result = 31 * result + Arrays.deepHashCode(board);
        return result;
    }

    KnightPosition step() {
        board[x][y] = n;
        return this;
    }

    KnightPosition stepNW() {
        return new KnightPosition(x - 2, y - 1, n + 1, board).step();
    }

    KnightPosition stepNE() {
        return new KnightPosition(x - 2, y + 1, n + 1, board).step();
    }

    KnightPosition stepEN() {
        return new KnightPosition(x - 1, y + 2, n + 1, board).step();
    }

    KnightPosition stepES() {
        return new KnightPosition(x + 1, y + 2, n + 1, board).step();
    }

    KnightPosition stepSE() {
        return new KnightPosition(x + 2, y + 1, n + 1, board).step();
    }

    KnightPosition stepSW() {
        return new KnightPosition(x + 2, y - 1, n + 1, board).step();
    }

    KnightPosition stepWS() {
        return new KnightPosition(x + 1, y - 2, n + 1, board).step();
    }

    KnightPosition stepWN() {
        return new KnightPosition(x - 1, y - 2, n + 1, board).step();
    }

    int calculateNewCoordinate(int current, int size) {
        if (current < size / 2) {
            return current % 2 == 0 ?
                    1 :
                    -1;
        } else return (size - current + 1) % 2 == 0 ?
                -1 :
                1;
    }

    KnightPosition goEast(int ringLevel) {
        var currentX = x;
        var currentY = y;
        var step = n;

        var tmpX = currentX;
        var tmpY = currentY;

        do {
            board[currentX][currentY] = step++;
            tmpX = currentX;
            tmpY = currentY;
            var currentXDiff = calculateNewCoordinate(currentX, board.length);
            currentX += currentXDiff;
            currentY += 2;
            if (!isFree(board, currentX, currentY)) {
                currentX -= currentXDiff * 2;
            }
        } while (canMove(board, ringLevel, currentX, currentY));

        return new KnightPosition(tmpX, tmpY, board[tmpX][tmpY], board);
    }

    KnightPosition goSouth(int ringLevel) {
        var currentX = x;
        var currentY = y;
        var step = n;

        var tmpX = currentX;
        var tmpY = currentY;

        do {
            board[currentX][currentY] = step++;
            tmpX = currentX;
            tmpY = currentY;
            currentX += 2;
            var currentYDiff = calculateNewCoordinate(currentY, board[0].length);
            currentY += currentYDiff;
            if (!isFree(board, currentX, currentY)) {
                currentY -= currentYDiff * 2;
            }
        } while (canMove(board, ringLevel, currentX, currentY));

        return new KnightPosition(tmpX, tmpY, board[tmpX][tmpY], board);
    }

    KnightPosition goWest(int ringLevel) {
        var currentX = x;
        var currentY = y;
        var step = n;

        var tmpX = currentX;
        var tmpY = currentY;

        do {
            board[currentX][currentY] = step++;
            tmpX = currentX;
            tmpY = currentY;
            var currentXDiff = calculateNewCoordinate(currentX, board.length);
            currentX += currentXDiff;
            currentY -= 2;
            if (!isFree(board, currentX, currentY)) {
                currentX -= currentXDiff * 2;
            }
        } while (canMove(board, ringLevel, currentX, currentY));

        return new KnightPosition(tmpX, tmpY, board[tmpX][tmpY], board);
    }

    KnightPosition goNorth(int ringLevel) {
        var currentX = x;
        var currentY = y;
        var step = n;

        var tmpX = currentX;
        var tmpY = currentY;

        do {
            board[currentX][currentY] = step++;
            tmpX = currentX;
            tmpY = currentY;
            currentX -= 2;
            var currentYDiff = calculateNewCoordinate(currentY, board[0].length);
            currentY += currentYDiff;
            if (!isFree(board, currentX, currentY)) {
                currentY -= currentYDiff * 2;
            }
        } while (canMove(board, ringLevel, currentX, currentY));

        return new KnightPosition(tmpX, tmpY, board[tmpX][tmpY], board);
    }

    KnightPosition circleStartingEast(int ringLevel) {
        return goEast(ringLevel).goSouth(ringLevel).goWest(ringLevel).goNorth(ringLevel);
    }

    KnightPosition circleStartingWest(int ringLevel) {
        return goWest(ringLevel).goNorth(ringLevel).goEast(ringLevel).goSouth(ringLevel);
    }

    KnightPosition circleStartingSouth(int ringLevel) {
        return goSouth(ringLevel).goWest(ringLevel).goNorth(ringLevel).goEast(ringLevel);
    }
}
