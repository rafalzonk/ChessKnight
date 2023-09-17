package chessknight.calculators;

import chessknight.Board;

public class PathCalculators {

    private static final PathCalculator[] pathCalculators = {
            new PathCalculator4x4(), new PathCalculator1x1(), new PathCalculator2x2(), new PathCalculator3x3()
    };

    public static Board calculatePath(int x, int y) {
        return selectCalculator(x, y).calculatePath(x, y);
    }

    private static PathCalculator selectCalculator(int x, int y) {
        return pathCalculators[x % 4];
    }
}
