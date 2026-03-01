class Solution {
    public int minPartitions(String n) {
        int ans = 0;
        for (int i = 0; i < n.length(); ++i) {
            ans = Math.max(ans, n.charAt(i) - '0');
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        String n1 = "32";
        int output1 = sol.minPartitions(n1);
        System.out.println("Example 1: Input: n = " + n1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 3");
        System.out.println();
        
        // Example 2:
        String n2 = "82734";
        int output2 = sol.minPartitions(n2);
        System.out.println("Example 2: Input: n = " + n2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 8");
        System.out.println();
        
        // Example 3:
        String n3 = "27346209830709182346";
        int output3 = sol.minPartitions(n3);
        System.out.println("Example 3: Input: n = " + n3);
        System.out.println("Output: " + output3);
        System.out.println("Expected: 9");
    }
}