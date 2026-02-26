class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;

            if (bit == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps += 1;
            }
        }

        return steps + carry;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        String s1 = "1101";
        int output1 = sol.numSteps(s1);
        System.out.println("Example 1: Input: s = " + s1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 6");
        System.out.println();
        
        // Example 2:
        String s2 = "10";
        int output2 = sol.numSteps(s2);
        System.out.println("Example 2: Input: s = " + s2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 3:
        String s3 = "1";
        int output3 = sol.numSteps(s3);
        System.out.println("Example 3: Input: s = " + s3);
        System.out.println("Output: " + output3);
        System.out.println("Expected: 0");
    }
}