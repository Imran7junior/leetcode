import java.util.*;

class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int sc = y, ec = y + k - 1, sr = x;
        for (int j = sc; j <= ec; j++) {
            for (int i = 0; i < k / 2; i++) {
                int tmp = grid[sr+i][j];
                grid[sr+i][j] = grid[sr+k-i-1][j];
                grid[sr+k-i-1][j] = tmp;
            }
        }
        return grid;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[][] grid1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int x1 = 1, y1 = 0, k1 = 3;
        int[][] output1 = sol.reverseSubmatrix(grid1, x1, y1, k1);
        System.out.println("Example 1: grid (4x4), x=1, y=0, k=3");
        System.out.println("Output: " + Arrays.deepToString(output1));
        System.out.println("Expected: [[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]");
        System.out.println();
        
        // Example 2
        int[][] grid2 = {{3,4,2,3},{2,3,4,2}};
        int x2 = 0, y2 = 2, k2 = 2;
        int[][] output2 = sol.reverseSubmatrix(grid2, x2, y2, k2);
        System.out.println("Example 2: grid (2x4), x=0, y=2, k=2");
        System.out.println("Output: " + Arrays.deepToString(output2));
        System.out.println("Expected: [[3,4,4,2],[2,3,2,3]]");
    }
}