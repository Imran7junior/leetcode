class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        String doubled = s + s;

        return doubled.contains(goal);
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        String s1 = "abcde";
        String goal1 = "cdeab";
        boolean result1 = solution.rotateString(s1, goal1);
        System.out.println("Example 1: Input: s = \"" + s1 + "\", goal = \"" + goal1 + "\"");
        System.out.println("Output: " + result1);
        System.out.println("Expected: true\n");
        
        // Example 2
        String s2 = "abcde";
        String goal2 = "abced";
        boolean result2 = solution.rotateString(s2, goal2);
        System.out.println("Example 2: Input: s = \"" + s2 + "\", goal = \"" + goal2 + "\"");
        System.out.println("Output: " + result2);
        System.out.println("Expected: false");
    }
}