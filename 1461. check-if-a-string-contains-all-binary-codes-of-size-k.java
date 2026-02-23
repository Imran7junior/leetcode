import java.util.*;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> st = new HashSet<>();

        for (int i = 0; i + k <= s.length(); i++) {
            st.add(s.substring(i, i + k));
        }

        return st.size() == (int)Math.pow(2, k);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        String s1 = "00110110";
        int k1 = 2;
        boolean output1 = sol.hasAllCodes(s1, k1);
        System.out.println("Example 1: Input: s = " + s1 + ", k = " + k1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: true");
        System.out.println();
        
        // Example 2:
        String s2 = "0110";
        int k2 = 1;
        boolean output2 = sol.hasAllCodes(s2, k2);
        System.out.println("Example 2: Input: s = " + s2 + ", k = " + k2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: true");
        System.out.println();
        
        // Example 3:
        String s3 = "0110";
        int k3 = 2;
        boolean output3 = sol.hasAllCodes(s3, k3);
        System.out.println("Example 3: Input: s = " + s3 + ", k = " + k3);
        System.out.println("Output: " + output3);
        System.out.println("Expected: false");
    }
}