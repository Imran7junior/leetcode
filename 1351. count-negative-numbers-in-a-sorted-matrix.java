class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i = 0, j = n - 1; // Start Top-Right
        int count = 0;
        
        while (i < m && j >= 0) {
            if (grid[i][j] < 0) {
                // If current is neg, all below in this col are neg
                count += (m - i);
                j--; // Move Left
            } else {
                // If current is pos, this row is safe, move down
                i++; // Move Down
            }
        }
        return count;
    }
	// Testing
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] grid = {
			{4, 3, 2, -1},
			{3, 2, 1, -1},
			{1, 1, -1, -2},
			{-1, -1, -2, -3}
		};
		System.out.println(sol.countNegatives(grid)); // Output: 8
	}
}