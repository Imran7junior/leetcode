class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int mask = (1 << (32 - Integer.numberOfLeadingZeros(n))) - 1;
        return n ^ mask;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int n1 = 5;
        int output1 = sol.bitwiseComplement(n1);
        System.out.println("Example 1: Input: n = " + n1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 2");
        System.out.println();
        
        // Example 2:
        int n2 = 7;
        int output2 = sol.bitwiseComplement(n2);
        System.out.println("Example 2: Input: n = " + n2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 0");
        System.out.println();
        
        // Example 3:
        int n3 = 10;
        int output3 = sol.bitwiseComplement(n3);
        System.out.println("Example 3: Input: n = " + n3);
        System.out.println("Output: " + output3);
        System.out.println("Expected: 5");
    }
}