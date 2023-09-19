package chessknight.calculators;

import chessknight.Board;

import static chessknight.calculators.PathCalculatorUtils.*;

class SquarePathCalculator1X1 implements SquarePathCalculator {
    @Override
    public Board calculatePath(int size) {
        var position = new KnightPosition(0, 0, 1, new int[size][size]);

        for (int ringLevel = 0; ringLevel < size / 4; ringLevel++) {
            for (int i = 0; i < 4; i++) {
                position = position.circleStartingEast(ringLevel);
            }
        }

        position.goEast(size / 4);

        return new Board(position.getBoard());
    }


}
