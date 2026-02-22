class Solution {
    public int binaryGap(int n) {
        int lastPosition = -1;
        int maxGap = 0;
        int position = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (lastPosition != -1) {
                    maxGap = Math.max(maxGap, position - lastPosition);
                }
                lastPosition = position;
            }

            n = n >> 1;
            position++;
        }

        return maxGap;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int n1 = 22;
        int output1 = sol.binaryGap(n1);
        System.out.println("Example 1: Input: n = " + n1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 2");
        System.out.println();
        
        // Example 2:
        int n2 = 8;
        int output2 = sol.binaryGap(n2);
        System.out.println("Example 2: Input: n = " + n2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 0");
        System.out.println();
        
        // Example 3:
        int n3 = 5;
        int output3 = sol.binaryGap(n3);
        System.out.println("Example 3: Input: n = " + n3);
        System.out.println("Output: " + output3);
        System.out.println("Expected: 2");
    }
}