import java.util.*;

class Solution {
    public long maximumScore(int[][] A) {
        int n = A.length;

        long[][] B = new long[n][n + 1];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                B[j][i + 1] = B[j][i] + A[i][j];
            } 
        }

        long[] pdp = new long[n + 1];
        long[] pep = new long[n + 1];

        for (int j = 1; j < n; j++) {
            long[] dp = new long[n + 1];
            long[] ep = new long[n + 1];

            for (int pb = 0; pb <= n; pb++) {
                for (int cb = 0; cb <= n; cb++) {

                    long pv = 0;
                    if (cb > pb) {
                        pv = B[j - 1][cb] - B[j - 1][pb];
                    }

                    long cv = 0;
                    if (cb < pb) {
                        cv = B[j][pb] - B[j][cb];
                    }

                    dp[cb] = Math.max(dp[cb],
                            Math.max(pv + pdp[pb], pep[pb])
                    );

                    ep[cb] = Math.max(ep[cb],
                            Math.max(cv + pep[pb],
                                     cv + pv + pdp[pb])
                    );
                }
            }

            pdp = dp;
            pep = ep;
        }

        long ans = 0;
        for (long v : pep) {
            ans = Math.max(ans, v);
        }

        return ans;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[][] grid1 = {{0,0,0,0,0},{0,0,3,0,0},{0,1,0,0,0},{5,0,0,3,0},{0,0,0,0,2}};
        long result1 = solution.maximumScore(grid1);
        System.out.println("Example 1: Input: grid = [[0,0,0,0,0],[0,0,3,0,0],[0,1,0,0,0],[5,0,0,3,0],[0,0,0,0,2]]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 11\n");
        
        // Example 2
        int[][] grid2 = {{10,9,0,0,15},{7,1,0,8,0},{5,20,0,11,0},{0,0,0,1,2},{8,12,1,10,3}};
        long result2 = solution.maximumScore(grid2);
        System.out.println("Example 2: Input: grid = [[10,9,0,0,15],[7,1,0,8,0],[5,20,0,11,0],[0,0,0,1,2],[8,12,1,10,3]]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 94");
    }
}