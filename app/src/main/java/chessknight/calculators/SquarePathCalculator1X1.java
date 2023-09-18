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
                position = circleStartingEast(position, board, ringLevel);
            }
        }

        goEast(board, position.step(), position.x(), position.y(), size/4);

        return new Board(board);
    }


}
