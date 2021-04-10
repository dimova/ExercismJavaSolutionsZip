public class PascalsTriangleGenerator {
    public int[][] generateTriangle(int rows) {
        if (rows < 0) throw new IllegalArgumentException();
        int[][] result = new int[rows][];
        int r, num;
        for (int i = 0; i < rows; i++) {
            num = 1;
            r = i + 1;
            int[] row = new int[i + 1];
            for (int col = 0; col <= i; col++) {
                if (col > 0) {
                    num = num * (r - col) / col;
                }
                row[col] = num;
            }
            result[i] = row;
        }
        return result;
    }
}
