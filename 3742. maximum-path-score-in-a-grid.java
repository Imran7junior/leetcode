import java.util.Arrays;

class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        final int NEG = -1_000_000_000;

        int[][] prev = new int[n][k + 1];
        for (int j = 0; j < n; j++) {
            Arrays.fill(prev[j], NEG);
        }

        for (int i = 0; i < m; i++) {
            int[][] curr = new int[n][k + 1];
            for (int j = 0; j < n; j++) {
                Arrays.fill(curr[j], NEG);
            }

            for (int j = 0; j < n; j++) {
                int gain = grid[i][j];
                int need = gain > 0 ? 1 : 0;

                int limit = Math.min(k, i + j);

                if (i == 0 && j == 0) {
                    curr[0][0] = 0;
                    continue;
                }

                for (int c = need; c <= limit; c++) {
                    int best = NEG;

                    if (i > 0 && prev[j][c - need] != NEG) {
                        best = Math.max(best, prev[j][c - need] + gain);
                    }

                    if (j > 0 && curr[j - 1][c - need] != NEG) {
                        best = Math.max(best, curr[j - 1][c - need] + gain);
                    }

                    curr[j][c] = best;
                }
            }

            prev = curr;
        }

        int ans = NEG;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, prev[n - 1][c]);
        }

        return ans < 0 ? -1 : ans;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[][] grid1 = {{0, 1},{2, 0}};
        int k1 = 1;
        int result1 = solution.maxPathScore(grid1, k1);
        System.out.println("Example 1: Input: grid = [[0, 1],[2, 0]], k = 1");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 2\n");
        
        // Example 2
        int[][] grid2 = {{0, 1},{1, 2}};
        int k2 = 1;
        int result2 = solution.maxPathScore(grid2, k2);
        System.out.println("Example 2: Input: grid = [[0, 1],[1, 2]], k = 1");
        System.out.println("Output: " + result2);
        System.out.println("Expected: -1");
    }
}