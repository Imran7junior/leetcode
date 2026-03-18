class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        int[][] px = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                px[i+1][j+1] = grid[i][j] + px[i][j+1] + px[i+1][j] - px[i][j];
                if (px[i+1][j+1] <= k) ans++;
            }
        }
        return ans;
    }
}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		// Example 1:
		int[][] grid1 = {{1,2,3},{4,5,6},{7,8,9}};
		int k1 = 4;
		int output1 = sol.countSubmatrices(grid1, k1);
		System.out.println("Example 1: Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = " + k1);
		System.out.println("Output: " + output1);
		System.out.println("Expected: 4");
		System.out.println();
		
		// Example 2:
		int[][] grid2 = {{2}};
		int k2 = 3;
		int output2 = sol.countSubmatrices(grid2, k2);
		System.out.println("Example 2: Input: grid = [[2]], k = " + k2);
		System.out.println("Output: " + output2);
		System.out.println("Expected: 1");
	}
}