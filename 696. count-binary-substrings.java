class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0, prev = 0, strk = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) strk++;
            else {
                prev = strk;
                strk = 1;
            }
            if (strk <= prev) res++;
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        String s1 = "00110011";
        int output1 = sol.countBinarySubstrings(s1);
        System.out.println("Example 1: Input: s = " + s1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 6");
        System.out.println();
        
        // Example 2:
        String s2 = "10101";
        int output2 = sol.countBinarySubstrings(s2);
        System.out.println("Example 2: Input: s = " + s2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 4");
    }
}
