import java.util.*;

class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] evenfreq1 = new int[26];
        int[] oddfreq1 = new int[26];
        int[] evenfreq2 = new int[26];
        int[] oddfreq2 = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                evenfreq1[s1.charAt(i) - 'a']++;
                evenfreq2[s2.charAt(i) - 'a']++;
            } else {
                oddfreq1[s1.charAt(i) - 'a']++;
                oddfreq2[s2.charAt(i) - 'a']++;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (evenfreq1[i] != evenfreq2[i] || 
                oddfreq1[i] != oddfreq2[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String s1_1 = "abcdba";
        String s2_1 = "cabdab";
        boolean output1 = sol.checkStrings(s1_1, s2_1);
        System.out.println("Example 1: s1='abcdba', s2='cabdab'");
        System.out.println("Output: " + output1);
        System.out.println("Expected: true");
        System.out.println();
        
        // Example 2
        String s1_2 = "abe";
        String s2_2 = "bea";
        boolean output2 = sol.checkStrings(s1_2, s2_2);
        System.out.println("Example 2: s1='abe', s2='bea'");
        System.out.println("Output: " + output2);
        System.out.println("Expected: false");
    }
}