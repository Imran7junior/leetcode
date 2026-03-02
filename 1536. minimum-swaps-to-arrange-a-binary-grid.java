class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zeros = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) {
                count++;
            }
            zeros[i] = count;
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            int needed = n - i - 1;
            int j = i;
            while (j < n && zeros[j] < needed) j++;

            if (j == n) return -1;
            while (j > i) {
                int temp = zeros[j];
                zeros[j] = zeros[j - 1];
                zeros[j - 1] = temp;
                j--;
                swaps++;
            }
        }

        return swaps;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int[][] grid1 = {{0,0,1},{1,1,0},{1,0,0}};
        int output1 = sol.minSwaps(grid1);
        System.out.println("Example 1: Input: grid = [[0,0,1],[1,1,0],[1,0,0]]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 3");
        System.out.println();
        
        // Example 2:
        int[][] grid2 = {{0,1,1,0},{0,1,1,0},{0,1,1,0},{0,1,1,0}};
        int output2 = sol.minSwaps(grid2);
        System.out.println("Example 2: Input: grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: -1");
        System.out.println();
        
        // Example 3:
        int[][] grid3 = {{1,0,0},{1,1,0},{1,1,1}};
        int output3 = sol.minSwaps(grid3);
        System.out.println("Example 3: Input: grid = [[1,0,0],[1,1,0],[1,1,1]]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 0");
    }
}