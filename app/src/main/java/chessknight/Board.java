package chessknight;

import static java.lang.String.valueOf;

public record Board(int[][] chessBoard) {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("╔");
        String separator;
        var x = chessBoard.length;
        int y = chessBoard[0].length;
        int digitSpace;

        if (x * y < 100) {
            var ceiling = "══╤".repeat(y - 1);
            sb.append(ceiling);
            sb.append("══╗\n");
            separator = "╟" + "──┼".repeat(y - 1) + "──╢\n";
            digitSpace = 2;
        } else if (x * y < 1000) {
            var ceiling = "═══╤".repeat(y - 1);
            sb.append(ceiling);
            sb.append("═══╗\n");
            separator = "╟" + "───┼".repeat(y - 1) + "───╢\n";
            digitSpace = 3;
        } else if (x * y < 10000) {
            var ceiling = "════╤".repeat(y - 1);
            sb.append(ceiling);
            sb.append("════╗\n");
            separator = "╟" + "────┼".repeat(y - 1) + "────╢\n";
            digitSpace = 4;
        } else {
            var ceiling = "═════╤".repeat(y - 1);
            sb.append(ceiling);
            sb.append("═════╗\n");
            separator = "╟" + "─────┼".repeat(y - 1) + "─────╢\n";
            digitSpace = 5;
        }


        for (int i = 0; i < x - 1; i++) {
            sb.append("║");
            for (int j = 0; j < y - 1; j++) {
                sb.append(formatNumber(chessBoard[i][j], digitSpace))
                        .append("│");
            }
            sb.append(formatNumber(chessBoard[i][y - 1], digitSpace))
                    .append("║\n")
                    .append(separator);
        }

        sb.append("║");
        for (int j = 0; j < y - 1; j++) {
            sb.append(formatNumber(chessBoard[x - 1][j], digitSpace))
                    .append("│");
        }
        sb.append(formatNumber(chessBoard[x - 1][y - 1], digitSpace))
                .append("║\n");

        sb.append("╚")
                .append(("═".repeat(digitSpace) + "╧").repeat(y - 1))
                .append("═".repeat(digitSpace))
                .append("╝\n");
        return sb.toString();
    }

    private String formatNumber(int n, int digitSpace) {
        if (n == 0)
            return " ".repeat(digitSpace);
        if (n < 10)
            return " ".repeat(digitSpace - 1) + n;
        if (n < 100)
            return " ".repeat(digitSpace - 2) + n;
        if (n < 1000)
            return " ".repeat(digitSpace - 3) + n;
        if (n < 10000)
            return " ".repeat(digitSpace - 4) + n;
        return valueOf(n);
    }
}
