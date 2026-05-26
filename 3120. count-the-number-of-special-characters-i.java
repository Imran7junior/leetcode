class Solution {
    public int numberOfSpecialChars(String word) {
        int lower = 0;
        int upper = 0;

        for(char ch : word.toCharArray()) {
            if(Character.isLowerCase(ch)) {
                lower |= (1 << (ch - 'a'));
            }
            else {
                upper |= (1 << (ch - 'A'));
            }
        }

        int common = lower & upper;

        // counting number of set bits
        return Integer.bitCount(common);
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
        String word3 = "abBCab";
        int output3 = sol.numberOfSpecialChars(word3);
        System.out.println("Example 3: word=\"abBCab\"");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 1");
    }
}