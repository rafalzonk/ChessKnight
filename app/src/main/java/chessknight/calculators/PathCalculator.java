package chessknight.calculators;

import chessknight.Board;

interface PathCalculator {
    default Board calculatePath(int x, int y) {
        return null;
    }
}
