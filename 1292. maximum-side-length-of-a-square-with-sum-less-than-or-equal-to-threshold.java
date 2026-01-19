class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] pref = new int[m + 1][n + 1];
        
        // Build prefix sum array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = mat[i-1][j-1]
                           + pref[i-1][j]
                           + pref[i][j-1]
                           - pref[i-1][j-1];
            }
        }
        
        int maxSide = Math.min(m, n);
        
        while (maxSide > 0) {
            for (int i = 0; i <= m - maxSide; i++) {
                for (int j = 0; j <= n - maxSide; j++) {
                    int s = pref[i+maxSide][j+maxSide]
                          - pref[i][j+maxSide]
                          - pref[i+maxSide][j]
                          + pref[i][j];
                    
                    if (s <= threshold) {
                        return maxSide;
                    }
                }
            }
            maxSide--;
        }
        
        return 0;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[][] mat1 = {{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
        int threshold1 = 4;
        int output1 = solution.maxSideLength(mat1, threshold1);
        System.out.println("Test 1: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4");
        System.out.println("Output: " + output1 + ", Expected: 2");
        
        // Test case 2
        int[][] mat2 = {{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2}};
        int threshold2 = 1;
        int output2 = solution.maxSideLength(mat2, threshold2);
        System.out.println("Test 2: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1");
        System.out.println("Output: " + output2 + ", Expected: 0");
        
        System.out.println("\nTest cases executed!");
    }
}
