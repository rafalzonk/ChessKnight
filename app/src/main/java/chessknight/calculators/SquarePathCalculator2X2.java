package chessknight.calculators;

import chessknight.Board;

import static chessknight.calculators.PathCalculatorUtils.*;

class SquarePathCalculator2X2 implements SquarePathCalculator {
    @Override
    public Board calculatePath(int size) {
        var position = new KnightPosition(0, 0, 1, new int[size][size]);

        //TODO try to rewrite it recursively
        for (int ringLevel = 0; ringLevel < (size / 4) - 1; ringLevel++) {
            position = position.circleStartingEast(ringLevel)
                    .circleStartingEast(ringLevel)
                    .stepES();
        }

        int ringLevel = (size / 4) - 1; //the most internal 6x6 subring
        position = position.goEast(ringLevel)
                .goSouth(ringLevel)
                .goWest(ringLevel)
                .stepNE().stepES().stepSE()
                .circleStartingWest(ringLevel)
                .stepWN().stepEN()
                .circleStartingSouth(ringLevel)
                .stepSW().stepSW()
                .goEast(ringLevel)
                .stepNW().stepWS().stepWN()
                .goNorth(ringLevel)
                .goEast(ringLevel);


        for (ringLevel = (size / 4) - 2; ringLevel >= 0; ringLevel--) {
            position = position.stepEN()
                    .circleStartingSouth(ringLevel)
                    .circleStartingSouth(ringLevel);
        }

        return new Board(position.getBoard());
    }

}
