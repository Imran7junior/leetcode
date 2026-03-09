class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1_000_000_007;
        long[][][] dp = new long[zero+1][one+1][2];

        for(int i=1;i<=Math.min(zero,limit);i++) dp[i][0][0]=1;
        for(int j=1;j<=Math.min(one,limit);j++) dp[0][j][1]=1;

        for(int i=1;i<=zero;i++){
            for(int j=1;j<=one;j++){
                long over0 = (i-limit>=1)? dp[i-limit-1][j][1]:0;
                long over1 = (j-limit>=1)? dp[i][j-limit-1][0]:0;

                dp[i][j][0]=(dp[i-1][j][0]+dp[i-1][j][1]-over0+MOD)%MOD;
                dp[i][j][1]=(dp[i][j-1][0]+dp[i][j-1][1]-over1+MOD)%MOD;
            }
        }

        return (int)((dp[zero][one][0]+dp[zero][one][1])%MOD);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int zero1 = 1;
        int one1 = 1;
        int limit1 = 2;
        int output1 = sol.numberOfStableArrays(zero1, one1, limit1);
        System.out.println("Example 1: Input: zero = " + zero1 + ", one = " + one1 + ", limit = " + limit1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 2");
        System.out.println();
        
        // Example 2:
        int zero2 = 1;
        int one2 = 2;
        int limit2 = 1;
        int output2 = sol.numberOfStableArrays(zero2, one2, limit2);
        System.out.println("Example 2: Input: zero = " + zero2 + ", one = " + one2 + ", limit = " + limit2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 3:
        int zero3 = 3;
        int one3 = 3;
        int limit3 = 2;
        int output3 = sol.numberOfStableArrays(zero3, one3, limit3);
        System.out.println("Example 3: Input: zero = " + zero3 + ", one = " + one3 + ", limit = " + limit3);
        System.out.println("Output: " + output3);
        System.out.println("Expected: 14");
    }
}