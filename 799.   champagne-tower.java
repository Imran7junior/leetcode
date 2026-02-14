class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[102][102];
        tower[0][0] = (double) poured;

        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= r; c++) {
                if (tower[r][c] > 1.0) {
                    double excess = (tower[r][c] - 1.0) / 2.0;
                    tower[r][c] = 1.0;
                    tower[r + 1][c] += excess;
                    tower[r + 1][c + 1] += excess;
                }
            }
        }
        return tower[query_row][query_glass];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int poured1 = 1, query_row1 = 1, query_glass1 = 1;
        double result1 = sol.champagneTower(poured1, query_row1, query_glass1);
        System.out.println("Example 1: poured = " + poured1 + ", query_row = " + query_row1 + ", query_glass = " + query_glass1);
        System.out.printf("Output: %.5f (Expected: 0.00000)\n\n", result1);
        
        // Example 2
        int poured2 = 2, query_row2 = 1, query_glass2 = 1;
        double result2 = sol.champagneTower(poured2, query_row2, query_glass2);
        System.out.println("Example 2: poured = " + poured2 + ", query_row = " + query_row2 + ", query_glass = " + query_glass2);
        System.out.printf("Output: %.5f (Expected: 0.50000)\n\n", result2);
        
        // Example 3
        int poured3 = 100000009, query_row3 = 33, query_glass3 = 17;
        double result3 = sol.champagneTower(poured3, query_row3, query_glass3);
        System.out.println("Example 3: poured = " + poured3 + ", query_row = " + query_row3 + ", query_glass = " + query_glass3);
        System.out.printf("Output: %.5f (Expected: 1.00000)\n\n", result3);
    }
}