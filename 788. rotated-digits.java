class Solution {
    public int rotatedDigits(int n) {
        int[] dp = new int[n + 1];
        int count = 0;

        for (int i = 0; i <= n; i++) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) {
                    dp[i] = 1;
                } else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    count++;
                } else {
                    dp[i] = 0;
                }
            } else {
                int a = dp[i / 10];
                int b = dp[i % 10];

                if (a == 1 && b == 1) {
                    dp[i] = 1;
                } else if (a >= 1 && b >= 1) {
                    dp[i] = 2;
                    count++;
                } else {
                    dp[i] = 0;
                }
            }
        }

        return count;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int n1 = 10;
        int result1 = solution.rotatedDigits(n1);
        System.out.println("Example 1: Input: n = " + n1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: 4\n");
        
        // Example 2
        int n2 = 1;
        int result2 = solution.rotatedDigits(n2);
        System.out.println("Example 2: Input: n = " + n2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: 0\n");
        
        // Example 3
        int n3 = 2;
        int result3 = solution.rotatedDigits(n3);
        System.out.println("Example 3: Input: n = " + n3);
        System.out.println("Output: " + result3);
        System.out.println("Expected: 1");
    }
}