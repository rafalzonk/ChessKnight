package chessknight.calculators;

import chessknight.Board;

class SquarePathCalculator3X3 implements SquarePathCalculator {
    @Override
    public Board calculatePath(int size) {
        var position = new KnightPosition(0, 0, 1, new int[size][size]);

        position = calculatePathInEvenRing(position, 0);

        return new Board(position.getBoard());
    }

    private KnightPosition calculatePathInEvenRing(KnightPosition position, int ringLevel) {
        if (ringLevel == (position.getBoard().length / 4) - 1) {
            // the most internal 7x7 subring
            return calculateInnerRingEven(position, ringLevel);
        }

        position = position.circleStartingEast(ringLevel)
                .circleStartingEast(ringLevel)
                .circleStartingEast(ringLevel)
                .stepES();

        position = calculatePathInOddRing(position, ringLevel + 1)
                .stepWS()
                .circleStartingSouthCounterclockwise(ringLevel);

        return position;
    }

    private KnightPosition calculatePathInOddRing(KnightPosition position, int ringLevel) {
        if (ringLevel == (position.getBoard().length / 4) - 1) {
            // the most internal 7x7 subring
            return calculateInnerRingOdd(position, ringLevel);
        }

        position = position.circleStartingEast(ringLevel);
        position = calculatePathInEvenRing(position, ringLevel + 1)
                .stepWN()
                .circleStartingSouthCounterclockwise(ringLevel)
                .circleStartingSouthCounterclockwise(ringLevel)
                .circleStartingSouthCounterclockwise(ringLevel);

        return position;
    }

    private KnightPosition calculateInnerRingEven(KnightPosition position, int ringLevel) {
        return position.circleStartingEast(ringLevel)
                .circleStartingEast(ringLevel)
                .goEast(ringLevel)
                .stepSW().stepWS().stepWN()
                .goSouth(ringLevel)
                .goEast(ringLevel)
                .stepNE()
                .stepWN()
                .stepWN()
                .stepSE()
                .stepNE()
                .stepWS()
                .stepES()
                .stepNW()
                .stepSW()
                .stepWN()
                .circleStartingSouthCounterclockwise(ringLevel);
    }

    private KnightPosition calculateInnerRingOdd(KnightPosition position, int ringLevel) {
        return position.circleStartingEast(ringLevel)
                .stepES()
                .stepNE()
                .stepSE()
                .stepWN()
                .stepEN()
                .stepSW()
                .stepNW()
                .stepES()
                .stepES()
                .goSouth(ringLevel)
                .goWest(ringLevel)
                .stepNW().stepNE()
                .stepES().stepEN()
                .goNorth(ringLevel)
                .goWest(ringLevel)
                .circleStartingSouthCounterclockwise(ringLevel)
                .circleStartingSouthCounterclockwise(ringLevel);
    }
}
