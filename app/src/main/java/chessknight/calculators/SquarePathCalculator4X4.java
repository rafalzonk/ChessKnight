package chessknight.calculators;

import chessknight.Board;

class SquarePathCalculator4X4 implements SquarePathCalculator {
    @Override
    public Board calculatePath(int size) {
        var position = new KnightPosition(0, 0, 1, new int[size][size]);

        position = calculatePathInternal(position, 0);

        return new Board(position.getBoard());
    }

    private KnightPosition calculatePathInternal(KnightPosition position, int ringLevel) {
        if (ringLevel == (position.getBoard().length / 4) - 2) {
            // the most internal 8x8 subring
            position = position.circleStartingEast(ringLevel)
                    .stepSE().stepSW().stepES().stepNE()
                    .stepNW()
                    .circleStartingEast(ringLevel)
                    .stepES();
            position = fillIn4x4Core(position, ringLevel + 1);

        } else {
            position = position.circleStartingEast(ringLevel)
                    .circleStartingEast(ringLevel)
                    .stepES();
            position = calculatePathInternal(position, ringLevel + 1);
        }
        position = position.stepEN()
                .circleStartingSouth(ringLevel)
                .circleStartingSouth(ringLevel);

        return position;
    }

    private KnightPosition fillIn4x4Core(KnightPosition position, int ringLevel) {
        return position.circleStartingEast(ringLevel)
                .circleStartingEast(ringLevel)
                .stepES()
                .stepWS()
                .stepNE()
                .stepEN();
    }
}
