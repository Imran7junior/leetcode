class Solution {
    public int numOfWays(int n) {
        int MOD = 1000000007;
        long A = 6;
        long B = 6;

        for (int i = 2; i <= n; i++) {
            long newA = (2 * A + 2 * B) % MOD;
            long newB = (2 * A + 3 * B) % MOD;
            A = newA;
            B = newB;
        }

        return (int)((A + B) % MOD);
    }
    public static void main(String[] args) {
    Solution solution = new Solution();
    
    // Test cases
    System.out.println("n = 1: " + solution.numOfWays(1)); // Expected: 12
    System.out.println("n = 2: " + solution.numOfWays(2)); // Expected: 54
    System.out.println("n = 3: " + solution.numOfWays(5000)); // Expected: 30228214
}
}