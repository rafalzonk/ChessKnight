package chessknight;

import static java.lang.String.valueOf;

public record Board(int[][] chessBoard) {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("╔");
        String separator;
        var x = chessBoard.length;
        int y = chessBoard[0].length;
        int numberSpace = calculateNumberSpace(x, y);

        String thickLine = "═".repeat(numberSpace);
        String thinLine = "─".repeat(numberSpace);
        var ceiling = (thickLine + "╤").repeat(y - 1);
        sb.append(ceiling);
        sb.append(thickLine).append("╗\n");
        separator = "╟" + (thinLine + "┼").repeat(y - 1) + thinLine + "╢\n";

        for (int i = 0; i < x - 1; i++) {
            sb.append("║");
            for (int j = 0; j < y - 1; j++) {
                sb.append(formatNumber(chessBoard[i][j], numberSpace))
                        .append("│");
            }
            sb.append(formatNumber(chessBoard[i][y - 1], numberSpace))
                    .append("║\n")
                    .append(separator);
        }

        sb.append("║");
        for (int j = 0; j < y - 1; j++) {
            sb.append(formatNumber(chessBoard[x - 1][j], numberSpace))
                    .append("│");
        }
        sb.append(formatNumber(chessBoard[x - 1][y - 1], numberSpace))
                .append("║\n");

        sb.append("╚")
                .append((thickLine + "╧").repeat(y - 1))
                .append(thickLine)
                .append("╝\n");
        return sb.toString();
    }

    private int calculateNumberSpace(int x, int y) {
        var multi = x * y;
        var numberSpace = 1;

        while ((multi /= 10) != 0) numberSpace++;

        return numberSpace;
    }

    private String formatNumber(int n, int numberSpace) {
        if (n == 0)
            return " ".repeat(numberSpace);

        var digits = 1;
        var div = n;

        while ((div /= 10) != 0) digits++;

        return " ".repeat(numberSpace - digits) + n;
    }
}
