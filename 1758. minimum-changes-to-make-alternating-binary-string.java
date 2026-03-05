class Solution {
    public int minOperations(String s) {
        int count = 0, n = s.length();
        for (int i = 0; i < n; i++)
            count += (s.charAt(i) ^ i) & 1;
          
        return Math.min(count, n - count);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        String s1 = "0100";
        int output1 = sol.minOperations(s1);
        System.out.println("Example 1: Input: s = " + s1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 2:
        String s2 = "10";
        int output2 = sol.minOperations(s2);
        System.out.println("Example 2: Input: s = " + s2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 0");
        System.out.println();
        
        // Example 3:
        String s3 = "1111";
        int output3 = sol.minOperations(s3);
        System.out.println("Example 3: Input: s = " + s3);
        System.out.println("Output: " + output3);
        System.out.println("Expected: 2");
    }
}