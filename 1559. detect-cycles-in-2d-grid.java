class Solution {
    int[] dir = {0, 1, 0, -1, 0};
    boolean[][] vis;
    private boolean dfs(char[][] grid, int row, int col, int prow, int pcol) {
        vis[row][col] = true;
        int M = grid.length;
        int N = grid[0].length;

        for(int i=0;i<4;i++) {
            int nrow = dir[i] + row;
            int ncol = dir[i+1] + col;

            if(nrow < M && nrow >= 0 && ncol < N && ncol >= 0 && grid[nrow][ncol] == grid[row][col] && (prow != nrow || ncol != pcol)) {
                if(vis[nrow][ncol]) {
                    return true;
                } else if(!vis[nrow][ncol] && dfs(grid, nrow, ncol, row, col)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        vis = new boolean[M][N];

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(!vis[i][j] && dfs(grid, i, j, -1, -1)) {
                    return true;
                }
            }
        }
        return false;

    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        char[][] grid1 = {{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
        boolean result1 = solution.containsCycle(grid1);
        System.out.println("Example 1: Input: grid = [[\"a\",\"a\",\"a\",\"a\"],[\"a\",\"b\",\"b\",\"a\"],[\"a\",\"b\",\"b\",\"a\"],[\"a\",\"a\",\"a\",\"a\"]]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: true\n");
        
        // Example 2
        char[][] grid2 = {{'c','c','c','a'},{'c','d','c','c'},{'c','c','e','c'},{'f','c','c','c'}};
        boolean result2 = solution.containsCycle(grid2);
        System.out.println("Example 2: Input: grid = [[\"c\",\"c\",\"c\",\"a\"],[\"c\",\"d\",\"c\",\"c\"],[\"c\",\"c\",\"e\",\"c\"],[\"f\",\"c\",\"c\",\"c\"]]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: true\n");
        
        // Example 3
        char[][] grid3 = {{'a','b','b'},{'b','z','b'},{'b','b','a'}};
        boolean result3 = solution.containsCycle(grid3);
        System.out.println("Example 3: Input: grid = [[\"a\",\"b\",\"b\"],[\"b\",\"z\",\"b\"],[\"b\",\"b\",\"a\"]]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: false");
    }
}