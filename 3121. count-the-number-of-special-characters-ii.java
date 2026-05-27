import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];

        Arrays.fill(lastLower, -1);
        Arrays.fill(firstUpper, -1);

        Set<Integer> invalid = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                int idx = ch - 'a';

                lastLower[idx] = i;

                if (firstUpper[idx] != -1) {
                    invalid.add(idx);
                }

            } else {
                int idx = ch - 'A';

                if (firstUpper[idx] == -1) {
                    firstUpper[idx] = i;
                }
            }
        }

        int specialCount = 0;

        for (int i = 0; i < 26; i++) {
            if (lastLower[i] != -1 &&
                firstUpper[i] != -1 &&
                !invalid.contains(i)) {

                specialCount++;
            }
        }

        return specialCount;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String word1 = "aaAbcBC";
        int output1 = sol.numberOfSpecialChars(word1);
        System.out.println("Example 1: word=\"aaAbcBC\"");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 3");
        System.out.println();
        
        // Example 2
        String word2 = "abc";
        int output2 = sol.numberOfSpecialChars(word2);
        System.out.println("Example 2: word=\"abc\"");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 0");
        System.out.println();
        
        // Example 3
        String word3 = "AbBCab";
        int output3 = sol.numberOfSpecialChars(word3);
        System.out.println("Example 3: word=\"AbBCab\"");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 0");
    }
}