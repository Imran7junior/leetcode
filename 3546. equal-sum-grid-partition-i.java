import java.util.*;

class Solution {
    int n, m;

    boolean checkHz(int[][] grid){
        HashSet<Long> st = new HashSet<>();

        long pref = 0;

        for(int i = 0; i < n; i++){
            long rowSum = 0;
            for(int j = 0; j < m; j++){
                rowSum += grid[i][j];
            }
            pref += rowSum;
            st.add(pref);
        }

        if(pref % 2 != 0) return false;

        return st.contains(pref / 2);
    }

    boolean checkVz(int[][] grid){
        HashSet<Long> st = new HashSet<>();

        long pref = 0;

        for(int j = 0; j < m; j++){
            long colSum = 0;
            for(int i = 0; i < n; i++){
                colSum += grid[i][j];
            }
            pref += colSum;
            st.add(pref);
        }

        if(pref % 2 != 0) return false;

        return st.contains(pref / 2);
    }

    public boolean canPartitionGrid(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        return checkHz(grid) || checkVz(grid);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[][] grid1 = {{1,4},{2,3}};
        boolean output1 = sol.canPartitionGrid(grid1);
        System.out.println("Example 1: grid=[[1,4],[2,3]]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: true");
        System.out.println();
        
        // Example 2
        int[][] grid2 = {{1,3},{2,4}};
        boolean output2 = sol.canPartitionGrid(grid2);
        System.out.println("Example 2: grid=[[1,3],[2,4]]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: false");
    }
}