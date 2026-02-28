class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        long res = 0;
        int bits = 0;

        for(int i=1; i<=n; i++){
            if((i & (i-1)) == 0) bits++;
            res = ((res<<bits) | i) % MOD;
        }
        return (int)res;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int n1 = 1;
        int output1 = sol.concatenatedBinary(n1);
        System.out.println("Example 1: Input: n = " + n1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 2:
        int n2 = 3;
        int output2 = sol.concatenatedBinary(n2);
        System.out.println("Example 2: Input: n = " + n2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 27");
        System.out.println();
        
        // Example 3:
        int n3 = 12;
        int output3 = sol.concatenatedBinary(n3);
        System.out.println("Example 3: Input: n = " + n3);
        System.out.println("Output: " + output3);
        System.out.println("Expected: 505379714");
    }
}