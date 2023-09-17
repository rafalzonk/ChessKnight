package chessknight.calculators;

import chessknight.Board;

import static chessknight.calculators.PathCalculatorUtils.*;

class SquarePathCalculator1X1 implements SquarePathCalculator {
    @Override
    public Board calculatePath(int size) {
        int[][] board = new int[size][size];
        var position = new KnightPosition(0, 0, 1);

        for (int ringLevel = 0; ringLevel < size / 4; ringLevel++) {
            for (int i = 0; i < 4; i++) {
                position = circleOnce(position, board, ringLevel);
            }
        }

        goEast(board, position.step(), position.x(), position.y(), size/4);

        return new Board(board);
    }

    private KnightPosition circleOnce(KnightPosition position, int[][] board, int ringLevel) {
        position = goEast(board, position.step(), position.x(), position.y(), ringLevel);
        position = goSouth(board, position.step(), position.x(), position.y(), ringLevel);
        position = goWest(board, position.step(), position.x(), position.y(), ringLevel);
        position = goNorth(board, position.step(), position.x(), position.y(), ringLevel);
        return position;
    }
}
