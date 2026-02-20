class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int n1 = 5;
        boolean output1 = sol.hasAlternatingBits(n1);
        System.out.println("Example 1: Input: n = " + n1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: true");
        System.out.println();
        
        // Example 2:
        int n2 = 7;
        boolean output2 = sol.hasAlternatingBits(n2);
        System.out.println("Example 2: Input: n = " + n2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: false");
        System.out.println();
        
        // Example 3:
        int n3 = 11;
        boolean output3 = sol.hasAlternatingBits(n3);
        System.out.println("Example 3: Input: n = " + n3);
        System.out.println("Output: " + output3);
        System.out.println("Expected: false");
    }
}