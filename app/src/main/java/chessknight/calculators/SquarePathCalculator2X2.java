package chessknight.calculators;

import chessknight.Board;

import static chessknight.calculators.PathCalculatorUtils.*;

class SquarePathCalculator2X2 implements SquarePathCalculator {
    @Override
    public Board calculatePath(int size) {
        int[][] board = new int[size][size];
        var position = new KnightPosition(0, 0, 1);

        //TODO try to rewrite it recursively
        for (int ringLevel = 0; ringLevel < (size / 4) - 1; ringLevel++) {
            position = circleStartingEast(position, board, ringLevel);
            position = circleStartingEast(position, board, ringLevel);

            stepSE(board, position);
        }

        int ringLevel = (size / 4) - 1; //6x6 ring
        position = goEast(board, position.step(), position.x(), position.y(), ringLevel);
        position = goSouth(board, position.step(), position.x(), position.y(), ringLevel);
        position = goWest(board, position.step(), position.x(), position.y(), ringLevel);

        position = stepNE(board, position);
        position = stepES(board, position);
        position = stepSE(board, position);

        position = circleStartingWest(position, board, ringLevel);

        position = stepWN(board, position);
        position = stepEN(board, position);

        position = circleStartingSouth(position, board, ringLevel);

        position = stepSW(board, position);
        position = stepSW(board, position);
        position = goEast(board, position.step(), position.x(), position.y(), ringLevel);
        position = stepNW(board, position);
        position = stepWS(board, position);
        position = stepWN(board, position);

        position = goNorth(board, position.step(), position.x(), position.y(), ringLevel);
        position = goEast(board, position.step(), position.x(), position.y(), ringLevel);

        for (ringLevel = (size / 4) - 2; ringLevel >= 0; ringLevel--) {
            position = stepEN(board, position);

            position = circleStartingSouth(position, board, ringLevel);
            position = circleStartingSouth(position, board, ringLevel);
        }

        return new Board(board);
    }

}
