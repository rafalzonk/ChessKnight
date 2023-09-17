package chessknight;

import chessknight.calculators.PathCalculators;

import java.util.Optional;

import static java.util.Optional.of;

public class ChessKnightService {

    public Optional<Board> calculatePath(int xSize, int ySize) {
        if (xSize != ySize || xSize == 4) {
            return Optional.empty();
        } else return of(PathCalculators.calculatePath(xSize, ySize));
    }
}
