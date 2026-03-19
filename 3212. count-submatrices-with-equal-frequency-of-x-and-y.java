class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;

        int[][] px = new int[m][n];
        int[][] py = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                px[i][j] = (grid[i][j] == 'X') ? 1 : 0;
                py[i][j] = (grid[i][j] == 'Y') ? 1 : 0;

                if (i > 0) {
                    px[i][j] += px[i - 1][j];
                    py[i][j] += py[i - 1][j];
                }
                if (j > 0) {
                    px[i][j] += px[i][j - 1];
                    py[i][j] += py[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    px[i][j] -= px[i - 1][j - 1];
                    py[i][j] -= py[i - 1][j - 1];
                }

                if (px[i][j] == py[i][j] && px[i][j] > 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        char[][] grid1 = {{"X".charAt(0), "Y".charAt(0), ".".charAt(0)}, {"Y".charAt(0), ".".charAt(0), ".".charAt(0)}};
        int output1 = sol.numberOfSubmatrices(grid1);
        System.out.println("Example 1: Input: grid = [[X,Y,.],[Y,.,.]]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 3");
        System.out.println();
        
        // Example 2:
        char[][] grid2 = {{"X".charAt(0), "X".charAt(0)}, {"X".charAt(0), "Y".charAt(0)}};
        int output2 = sol.numberOfSubmatrices(grid2);
        System.out.println("Example 2: Input: grid = [[X,X],[X,Y]]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 0");
        System.out.println();
        
        // Example 3:
        char[][] grid3 = {{".".charAt(0), ".".charAt(0)}, {".".charAt(0), ".".charAt(0)}};
        int output3 = sol.numberOfSubmatrices(grid3);
        System.out.println("Example 3: Input: grid = [[.,.,],[.,.]]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 0");
    }
}