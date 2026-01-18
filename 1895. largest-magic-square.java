class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        if (n < 2 || m < 2) {
            return 1;
        }
        
        // Prefix sums for rows
        int[][] rowPrefix = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowPrefix[i][j + 1] = rowPrefix[i][j] + grid[i][j];
            }
        }
        
        // Prefix sums for columns
        int[][] colPrefix = new int[n + 1][m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                colPrefix[i + 1][j] = colPrefix[i][j] + grid[i][j];
            }
        }
        
        // Try different sizes from largest to smallest
        for (int k = Math.min(n, m); k > 1; k--) {
            for (int r = 0; r <= n - k; r++) {
                for (int c = 0; c <= m - k; c++) {
                    int target = rowPrefix[r][c + k] - rowPrefix[r][c];
                    boolean magic = true;
                    
                    // Check all rows
                    for (int i = 0; i < k; i++) {
                        int rowSum = rowPrefix[r + i][c + k] - rowPrefix[r + i][c];
                        if (rowSum != target) {
                            magic = false;
                            break;
                        }
                    }
                    if (!magic) continue;
                    
                    // Check all columns
                    for (int j = 0; j < k; j++) {
                        int colSum = colPrefix[r + k][c + j] - colPrefix[r][c + j];
                        if (colSum != target) {
                            magic = false;
                            break;
                        }
                    }
                    if (!magic) continue;
                    
                    // Check diagonals
                    int d1 = 0, d2 = 0;
                    for (int i = 0; i < k; i++) {
                        d1 += grid[r + i][c + i];
                        d2 += grid[r + i][c + k - 1 - i];
                    }
                    
                    if (d1 == target && d2 == target) {
                        return k;
                    }
                }
            }
        }
        
        return 1;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[][] grid1 = {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
        int output1 = solution.largestMagicSquare(grid1);
        System.out.println("Test 1: grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]");
        System.out.println("Output: " + output1 + ", Expected: 3");
        
        // Test case 2
        int[][] grid2 = {{5,1,3,1},{9,3,3,1},{1,3,3,8}};
        int output2 = solution.largestMagicSquare(grid2);
        System.out.println("Test 2: grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]]");
        System.out.println("Output: " + output2 + ", Expected: 2");
        
        System.out.println("\nTest cases executed!");
    }
}
