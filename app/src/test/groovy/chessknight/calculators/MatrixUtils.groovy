package chessknight.calculators

class MatrixUtils {
    static boolean equals(int[][] a, int[][] b) {
        if (a == null && b == null) return true
        if (a == null || b == null || a.length != b.length) return false

        int i = 0
        for (; i < a.length && Arrays.equals(a[i], b[i]); i++);
        return i == a.length
    }
}
