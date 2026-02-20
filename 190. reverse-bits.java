public class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>>= 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int n1 = 43261596;
        int output1 = sol.reverseBits(n1);
        System.out.println("Example 1: Input: n = " + n1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 964176192");
        System.out.println();
        
        // Example 2:
        int n2 = 2147483644;
        int output2 = sol.reverseBits(n2);
        System.out.println("Example 2: Input: n = " + n2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 1073741822");
    }
}