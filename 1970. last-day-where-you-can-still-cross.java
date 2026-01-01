import java.util.Arrays;

class UnionFind {
    private int[] parent;
    private int[] rank;
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        // Find the root of x with path compression
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        // Union two sets by rank
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX == rootY) {
            return false;
        }
        
        // Union by rank
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        
        return true;
    }
    
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        /*
         * Optimized Union-Find approach (work backwards):
         * - Start from the last day (all flooded)
         * - Work backwards, "unflooding" cells one by one
         * - Use Union-Find to connect adjacent land cells
         * - Use virtual top and bottom nodes
         * - When top and bottom become connected, that's our answer
         * 
         * Time: O(R * C * α(R*C)) where α is inverse Ackermann (nearly O(R*C))
         * Space: O(R * C)
         */
        
        // Create Union-Find with row*col cells + 2 virtual nodes (top and bottom)
        UnionFind uf = new UnionFind(row * col + 2);
        int topNode = row * col;
        int bottomNode = row * col + 1;
        
        // Mark all cells as water initially
        int[][] grid = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(grid[i], 1);
        }
        
        // 4 directions
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // Work backwards from the last day
        for (int day = cells.length - 1; day >= 0; day--) {
            int r = cells[day][0] - 1;  // Convert to 0-indexed
            int c = cells[day][1] - 1;
            
            // Unflood this cell (make it land)
            grid[r][c] = 0;
            int cellId = r * col + c;
            
            // Connect to top virtual node if in first row
            if (r == 0) {
                uf.union(cellId, topNode);
            }
            
            // Connect to bottom virtual node if in last row
            if (r == row - 1) {
                uf.union(cellId, bottomNode);
            }
            
            // Connect to adjacent land cells
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 0) {
                    int neighborId = nr * col + nc;
                    uf.union(cellId, neighborId);
                }
            }
            
            // Check if top and bottom are connected
            if (uf.connected(topNode, bottomNode)) {
                return day;
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test 1
        int[][] cells1 = {{1,1},{2,1},{1,2},{2,2}};
        int result1 = solution.latestDayToCross(2, 2, cells1);
        System.out.println("Test 1: row=2, col=2, cells=" + Arrays.deepToString(cells1));
        System.out.println("Output: " + result1 + ", Expected: 2\n");
        
        // Test 2
        int[][] cells2 = {{1,1},{1,2},{2,1},{2,2}};
        int result2 = solution.latestDayToCross(2, 2, cells2);
        System.out.println("Test 2: row=2, col=2, cells=" + Arrays.deepToString(cells2));
        System.out.println("Output: " + result2 + ", Expected: 1\n");
        
        // Test 3
        int[][] cells3 = {{1,2},{2,1},{3,3},{2,2},{1,1},{1,3},{2,3},{3,1},{3,2}};
        int result3 = solution.latestDayToCross(3, 3, cells3);
        System.out.println("Test 3: row=3, col=3, cells=" + Arrays.deepToString(cells3));
        System.out.println("Output: " + result3 + ", Expected: 3\n");
    }
}
