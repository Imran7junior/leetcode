class Solution {
    public static int minFlips(String s) {
        final int n = s.length();
        int p = 0, k = 0;
        for (int i = 0; i < n; i++) {
            final char c = s.charAt(i);
            k += p ^ c & 1;
            p ^= 1;
        }
        int r = Math.min(k, n - k);
        if ((n & 1) != 0) {
            p = 0;
            for (int i = 0; i + 1 < n; i++) {
                final char c = s.charAt(i);
                k += (p ^ c & 1 ^ 1) - (p ^ c & 1);
                p ^= 1;
                r = Math.min(r, Math.min(k, n - k));
            }
        }
        return r;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        String s1 = "111000";
        int output1 = minFlips(s1);
        System.out.println("Example 1: Input: s = " + s1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 2");
        System.out.println();
        
        // Example 2:
        String s2 = "010";
        int output2 = minFlips(s2);
        System.out.println("Example 2: Input: s = " + s2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 0");
        System.out.println();
        
        // Example 3:
        String s3 = "1110";
        int output3 = minFlips(s3);
        System.out.println("Example 3: Input: s = " + s3);
        System.out.println("Output: " + output3);
        System.out.println("Expected: 1");
    }
}