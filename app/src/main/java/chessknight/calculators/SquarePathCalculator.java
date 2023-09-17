package chessknight.calculators;

import chessknight.Board;

interface SquarePathCalculator {
    default Board calculatePath(int size) {
        return null;
    }
}
