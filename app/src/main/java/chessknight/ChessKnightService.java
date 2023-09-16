package chessknight;

import chessknight.calculators.PathCalculatorFacade;

import java.util.Optional;

import static java.util.Optional.of;

public class ChessKnightService {

    public Optional<Board> calculatePath(int x, int y) {
        if (x != y || x == 4) {
            return Optional.empty();
        } else return of(PathCalculatorFacade.calculatePath(x, y));
    }
}
