class Solution {
    public char findKthBit(int n, int k) {
        // Base case: When n = 1, the binary string is "0"
        if (n == 1) return '0';
        
        // Find the length of the current string Sn, which is 2^n - 1
        int length = (1 << n) - 1;
        
        // Find the middle position
        int mid = length / 2 + 1;
        
        // If k is the middle position, return '1'
        if (k == mid) return '1';
        
        // If k is in the first half, find the bit in Sn-1
        if (k < mid) return findKthBit(n - 1, k);
        
        // If k is in the second half, find the bit in Sn-1 and invert it
        return findKthBit(n - 1, length - k + 1) == '0' ? '1' : '0';
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int n1 = 3;
        int k1 = 1;
        char output1 = sol.findKthBit(n1, k1);
        System.out.println("Example 1: Input: n = " + n1 + ", k = " + k1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 0");
        System.out.println();
        
        // Example 2:
        int n2 = 4;
        int k2 = 11;
        char output2 = sol.findKthBit(n2, k2);
        System.out.println("Example 2: Input: n = " + n2 + ", k = " + k2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 1");
    }
}