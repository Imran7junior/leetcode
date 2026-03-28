import java.util.*;

class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];
        char current = 'a';

        for (int i = 0; i < n; i++) {
            if (word[i] == 0) {
                if (current > 'z') {
                    return "";
                }
                word[i] = current;
                for (int j = i + 1; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        word[j] = word[i];
                    }
                }
                current++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] != word[j]) {
                    if (lcp[i][j] != 0) {
                        return "";
                    }
                } else {
                    if (i == n - 1 || j == n - 1) {
                        if (lcp[i][j] != 1) {
                            return "";
                        }
                    } else {
                        if (lcp[i][j] != lcp[i + 1][j + 1] + 1) {
                            return "";
                        }
                    }
                }
            }
        }

        return new String(word);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[][] lcp1 = {{4,0,2,0},{0,3,0,1},{2,0,2,0},{0,1,0,1}};
        String output1 = sol.findTheString(lcp1);
        System.out.println("Example 1: lcp (4x4 matrix)");
        System.out.println("Output: " + output1);
        System.out.println("Expected: abab");
        System.out.println();
        
        // Example 2
        int[][] lcp2 = {{4,3,2,1},{3,3,2,1},{2,2,2,1},{1,1,1,1}};
        String output2 = sol.findTheString(lcp2);
        System.out.println("Example 2: lcp (4x4 matrix)");
        System.out.println("Output: " + output2);
        System.out.println("Expected: aaaa");
        System.out.println();
        
        // Example 3
        int[][] lcp3 = {{4,3,2,1},{3,3,2,1},{2,2,2,1},{1,1,1,3}};
        String output3 = sol.findTheString(lcp3);
        System.out.println("Example 3: lcp (4x4 matrix)");
        System.out.println("Output: " + output3);
        System.out.println("Expected: (empty string)");
    }
}