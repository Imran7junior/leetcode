class Solution {
    public boolean checkOnesSegment(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            
            if (s.charAt(i) == '1') {
                while (i < n && s.charAt(i) == '1') {
                    i++;
                }
                if (count > 0)
                    return false;
                count++;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        String s1 = "1001";
        boolean output1 = sol.checkOnesSegment(s1);
        System.out.println("Example 1: Input: s = " + s1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: false");
        System.out.println();
        
        // Example 2:
        String s2 = "110";
        boolean output2 = sol.checkOnesSegment(s2);
        System.out.println("Example 2: Input: s = " + s2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: true");
    }
}