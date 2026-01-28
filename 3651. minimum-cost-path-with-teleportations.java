import java.util.*;

class Solution {
    public int minCost(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Find max value in grid
        int maxval = 0;
        for (int[] row : grid) {
            for (int val : row) {
                maxval = Math.max(maxval, val);
            }
        }
        
        int[] bestTeleport = new int[maxval + 1];
        Arrays.fill(bestTeleport, Integer.MAX_VALUE);
        
        int[][] dp = new int[rows][cols];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[rows - 1][cols - 1] = 0;  // zero cost to reach (m - 1, n - 1) from (m - 1, n - 1)
        
        for (int t = 0; t <= k; t++) {  // t teleports allowed
            dp = dpIteration(dp, bestTeleport, grid, rows, cols);
            bestTeleport = buildTeleport(dp, grid, rows, cols, maxval);
        }
        
        return dp[0][0];
    }
    
    private int[][] dpIteration(int[][] dp, int[] bestTeleport, int[][] grid, int rows, int cols) {
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                int walk = (r == rows - 1 && c == cols - 1) ? 0 : Integer.MAX_VALUE;
                
                // down
                if (r + 1 < rows && dp[r + 1][c] != Integer.MAX_VALUE) {
                    walk = Math.min(walk, dp[r + 1][c] + grid[r + 1][c]);
                }
                
                // right
                if (c + 1 < cols && dp[r][c + 1] != Integer.MAX_VALUE) {
                    walk = Math.min(walk, dp[r][c + 1] + grid[r][c + 1]);
                }
                
                // walk or teleport
                dp[r][c] = Math.min(walk, bestTeleport[grid[r][c]]);
            }
        }
        return dp;
    }
    
    private int[] buildTeleport(int[][] dp, int[][] grid, int rows, int cols, int maxval) {
        int[] teleport = new int[maxval + 1];
        Arrays.fill(teleport, Integer.MAX_VALUE);
        
        // First build mincost for each v = value
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                teleport[grid[r][c]] = Math.min(teleport[grid[r][c]], dp[r][c]);
            }
        }
        
        // Then build prefix mincost for v <= value
        for (int v = 0; v <= maxval; v++) {
            if (v > 0) {
                teleport[v] = Math.min(teleport[v], teleport[v - 1]);
            }
        }
        
        return teleport;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[][] grid1 = {{1,3,3},{2,5,4},{4,3,5}};
        int k1 = 2;
        int output1 = solution.minCost(grid1, k1);
        System.out.println("Test 1: grid = [[1,3,3],[2,5,4],[4,3,5]], k = 2");
        System.out.println("Output: " + output1 + ", Expected: 7");
        
        // Test case 2
        int[][] grid2 = {{1,2},{2,3},{3,4}};
        int k2 = 1;
        int output2 = solution.minCost(grid2, k2);
        System.out.println("Test 2: grid = [[1,2],[2,3],[3,4]], k = 1");
        System.out.println("Output: " + output2 + ", Expected: 9");
        
        System.out.println("\nTest cases executed!");
    }
}
