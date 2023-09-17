package chessknight.calculators;

import chessknight.Board;

public class PathCalculators {

    private static final SquarePathCalculator[] SQUARE_PATH_CALCULATORS = {
            new SquarePathCalculator4X4(), new SquarePathCalculator1X1(), new SquarePathCalculator2X2(), new SquarePathCalculator3X3()
    };

    public static Board calculatePath(int xSize, int ySize) {
        return selectCalculator(xSize, ySize).calculatePath(xSize);
    }

    private static SquarePathCalculator selectCalculator(int x, int y) {
        return SQUARE_PATH_CALCULATORS[x % 4];
    }
}
