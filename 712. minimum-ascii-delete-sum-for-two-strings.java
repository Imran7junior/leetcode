class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = s1.charAt(i) + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        int total = 0;
        for (char c : s1.toCharArray()) total += c;
        for (char c : s2.toCharArray()) total += c;

        return total - 2 * dp[0][0];
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test case 1: s1 = "sea", s2 = "eat"
        // Expected output: 231
        int result1 = sol.minimumDeleteSum("sea", "eat");
        System.out.println("Test 1: " + result1);
        assert result1 == 231 : "Expected 231, got " + result1;
        
        // Test case 2: s1 = "delete", s2 = "leet"
        // Expected output: 403
        int result2 = sol.minimumDeleteSum("delete", "leet");
        System.out.println("Test 2: " + result2);
        assert result2 == 403 : "Expected 403, got " + result2;
        
        System.out.println("All test cases passed!");
    }
}