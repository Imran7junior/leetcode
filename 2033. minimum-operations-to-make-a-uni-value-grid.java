class Solution {
    public int minOperations(int[][] grid, int x) {
        /**
        List<Integer> count = new ArrayList<>();
        for (int[] row : grid){
            for (int num : row){
                count.add(num);
            }
        }
        Collections.sort(count);
        for (int c : count){
            if (Math.abs(c - count.get(0)) % x != 0){
                return -1;
            }
        }
        int cost = count.get(count.size() / 2);
        int op = 0;
        for (int c : count){
            op += Math.abs(c - cost) / x;
        }
        return op;
        */
        List<Integer> res = new ArrayList<>();
        for (int[] row : grid) {
            for (int v : row) 
                res.add(v);
        }

        int mod = res.get(0) % x;
        for (int v : res) {
            if (v % x != mod) 
                return -1;
        }

        Collections.sort(res);
        int m = res.get(res.size() / 2);
        int cnt = 0;
        for (int v : res) {
            cnt += Math.abs(v - m) / x;
        }
        return cnt;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[][] grid1 = {{2,4},{6,8}};
        int x1 = 2;
        int result1 = solution.minOperations(grid1, x1);
        System.out.println("Example 1: Input: grid = [[2,4],[6,8]], x = 2");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 4\n");
        
        // Example 2
        int[][] grid2 = {{1,5},{2,3}};
        int x2 = 1;
        int result2 = solution.minOperations(grid2, x2);
        System.out.println("Example 2: Input: grid = [[1,5],[2,3]], x = 1");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 5\n");
        
        // Example 3
        int[][] grid3 = {{1,2},{3,4}};
        int x3 = 2;
        int result3 = solution.minOperations(grid3, x3);
        System.out.println("Example 3: Input: grid = [[1,2],[3,4]], x = 2");
        System.out.println("Output: " + result3);
        System.out.println("Expected: -1");
    }
}