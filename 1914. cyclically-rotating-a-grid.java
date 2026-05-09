class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            ArrayList<Integer> nums = new ArrayList<>();

            int top = layer;
            int bottom = m - layer - 1;
            int left = layer;
            int right = n - layer - 1;

            for (int j = left; j <= right; j++) {
                nums.add(grid[top][j]);
            }

            for (int i = top + 1; i <= bottom - 1; i++) {
                nums.add(grid[i][right]);
            }

            for (int j = right; j >= left; j--) {
                nums.add(grid[bottom][j]);
            }

            for (int i = bottom - 1; i >= top + 1; i--) {
                nums.add(grid[i][left]);
            }

            int len = nums.size();

            int rotate = k % len;

            int[] rotated = new int[len];

            for (int i = 0; i < len; i++) {
                rotated[i] = nums.get((i + rotate) % len);
            }

            int idx = 0;

            for (int j = left; j <= right; j++) {
                grid[top][j] = rotated[idx++];
            }

            for (int i = top + 1; i <= bottom - 1; i++) {
                grid[i][right] = rotated[idx++];
            }

            for (int j = right; j >= left; j--) {
                grid[bottom][j] = rotated[idx++];
            }

            for (int i = bottom - 1; i >= top + 1; i--) {
                grid[i][left] = rotated[idx++];
            }
        }

        return grid;
    }
    
    // Helper function to print 2D array
    private static void print2DArray(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr[i].length - 1) System.out.print(",");
            }
            System.out.print("]");
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[][] grid1 = {{40, 10}, {30, 20}};
        int[][] result1 = solution.rotateGrid(grid1, 1);
        System.out.println("Example 1: Input: grid = [[40,10],[30,20]], k = 1");
        System.out.print("Output: ");
        print2DArray(result1);
        System.out.println("Expected: [[10,20],[40,30]]\n");
        
        // Example 2
        int[][] grid2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] result2 = solution.rotateGrid(grid2, 2);
        System.out.println("Example 2: Input: grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2");
        System.out.print("Output: ");
        print2DArray(result2);
        System.out.println("Expected: [[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]");
    }
}