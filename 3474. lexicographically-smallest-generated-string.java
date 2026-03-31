import java.util.*;

class Solution {
    public String generateString(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int sz = n + m - 1;

        char[] word = new char[sz];
        Arrays.fill(word, '$');

        // Step 1: Apply 'T' constraints
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '$') {
                        word[i + j] = s2.charAt(j);
                    } else if (word[i + j] != s2.charAt(j)) {
                        return "";
                    }
                }
            }
        }

        // Step 2: Copy original state
        char[] word2 = word.clone();

        // Step 3: Process 'F' constraints
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == 'F') {

                int cntBlank = 0, cntSame = 0;
                int lastBlank = -1;

                for (int j = 0; j < m; j++) {

                    if (word2[i + j] == '$') {
                        if (word[i + j] == '$') {
                            word[i + j] = 'a';
                        }
                        lastBlank = i + j;
                        cntBlank++;
                    }

                    if (word[i + j] == s2.charAt(j)) {
                        cntSame++;
                    }
                }

                if (cntSame == m && cntBlank == 0) return "";

                if (cntSame == m && cntBlank > 0) {
                    word[lastBlank] = 'b';
                }
            }
        }

        return new String(word);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String str1_1 = "TFTF";
        String str2_1 = "ab";
        String output1 = sol.generateString(str1_1, str2_1);
        System.out.println("Example 1: str1='TFTF', str2='ab'");
        System.out.println("Output: '" + output1 + "'");
        System.out.println("Expected: 'ababa'");
        System.out.println();
        
        // Example 2
        String str1_2 = "TFTF";
        String str2_2 = "abc";
        String output2 = sol.generateString(str1_2, str2_2);
        System.out.println("Example 2: str1='TFTF', str2='abc'");
        System.out.println("Output: '" + output2 + "'");
        System.out.println("Expected: ''");
        System.out.println();
        
        // Example 3
        String str1_3 = "F";
        String str2_3 = "d";
        String output3 = sol.generateString(str1_3, str2_3);
        System.out.println("Example 3: str1='F', str2='d'");
        System.out.println("Output: '" + output3 + "'");
        System.out.println("Expected: 'a'");
    }
}