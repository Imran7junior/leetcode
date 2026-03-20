import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] res = new int[rows - k + 1][cols - k + 1];

        for (int r = 0; r <= rows - k; r++) {
            for (int c = 0; c <= cols - k; c++) {

                ArrayList<Integer> window = new ArrayList<>();

                for (int i = 0; i < k; i++)
                    for (int j = 0; j < k; j++)
                        window.add(grid[r+i][c+j]);

                Collections.sort(window);

                int minDiff = Integer.MAX_VALUE;
                for (int i = 0; i < window.size() - 1; i++) {
                    int d = window.get(i+1) - window.get(i);
                    if (d > 0)
                        minDiff = Math.min(minDiff, d);
                }

                res[r][c] = minDiff == Integer.MAX_VALUE ? 0 : minDiff;
            }
        }

        return res;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[][] grid1 = {{1,8},{3,-2}};
        int k1 = 2;
        int[][] output1 = sol.minAbsDiff(grid1, k1);
        System.out.println("Example 1: grid={{1,8},{3,-2}}, k=2");
        System.out.println("Output: " + Arrays.deepToString(output1));
        System.out.println("Expected: [[2]]");
        System.out.println();
        
        // Example 2
        int[][] grid2 = {{3,-1}};
        int k2 = 1;
        int[][] output2 = sol.minAbsDiff(grid2, k2);
        System.out.println("Example 2: grid={{3,-1}}, k=1");
        System.out.println("Output: " + Arrays.deepToString(output2));
        System.out.println("Expected: [[0,0]]");
        System.out.println();
        
        // Example 3
        int[][] grid3 = {{1,-2,3},{2,3,5}};
        int k3 = 2;
        int[][] output3 = sol.minAbsDiff(grid3, k3);
        System.out.println("Example 3: grid={{1,-2,3},{2,3,5}}, k=2");
        System.out.println("Output: " + Arrays.deepToString(output3));
        System.out.println("Expected: [[1,2]]");
    }
}