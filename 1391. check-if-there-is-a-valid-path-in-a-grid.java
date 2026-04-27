class Solution {
    public boolean hasValidPath(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Set<Integer>[] dirs = new HashSet[7];
        dirs[1] = new HashSet<>(Arrays.asList(0, 1));
        dirs[2] = new HashSet<>(Arrays.asList(2, 3));
        dirs[3] = new HashSet<>(Arrays.asList(0, 3));
        dirs[4] = new HashSet<>(Arrays.asList(1, 3));
        dirs[5] = new HashSet<>(Arrays.asList(0, 2));
        dirs[6] = new HashSet<>(Arrays.asList(1, 2));

        int[][] moves = {{0, -1, 0, 1}, 
                        {0, 1, 1, 0}, 
                        {-1, 0, 2, 3}, 
                        {1, 0, 3, 2}};
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            if (r == rows - 1 && c == cols - 1) 
                return true;

            for (int[] m : moves) {
                int nr = r + m[0], nc = c + m[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                    if (dirs[grid[r][c]].contains(m[2]) && dirs[grid[nr][nc]].contains(m[3])) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return false;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[][] grid1 = {{2,4,3},{6,5,2}};
        boolean result1 = solution.hasValidPath(grid1);
        System.out.println("Example 1: Input: grid = [[2,4,3],[6,5,2]]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: true\n");
        
        // Example 2
        int[][] grid2 = {{1,2,1},{1,2,1}};
        boolean result2 = solution.hasValidPath(grid2);
        System.out.println("Example 2: Input: grid = [[1,2,1],[1,2,1]]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: false\n");
        
        // Example 3
        int[][] grid3 = {{1,1,2}};
        boolean result3 = solution.hasValidPath(grid3);
        System.out.println("Example 3: Input: grid = [[1,1,2]]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: false");
    }
}