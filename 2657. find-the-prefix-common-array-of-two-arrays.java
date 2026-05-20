class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] ans = new int[n];

        long maskA = 0;
        long maskB = 0;

        for(int i = 0; i < n; i++) {

            // set bit for A[i]
            maskA |= (1L << A[i]);

            // set bit for B[i]
            maskB |= (1L << B[i]);

            // common elements
            long commonMask = maskA & maskB;

            // count set bits
            ans[i] = Long.bitCount(commonMask);
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] A1 = {1,3,2,4};
        int[] B1 = {3,1,2,4};
        int[] output1 = sol.findThePrefixCommonArray(A1, B1);
        System.out.println("Example 1: A=[1,3,2,4], B=[3,1,2,4]");
        System.out.print("Output: [");
        for(int i = 0; i < output1.length; i++) {
            if(i > 0) System.out.print(",");
            System.out.print(output1[i]);
        }
        System.out.println("]");
        System.out.println("Expected: [0,2,3,4]");
        System.out.println();
        
        // Example 2
        int[] A2 = {2,3,1};
        int[] B2 = {3,1,2};
        int[] output2 = sol.findThePrefixCommonArray(A2, B2);
        System.out.println("Example 2: A=[2,3,1], B=[3,1,2]");
        System.out.print("Output: [");
        for(int i = 0; i < output2.length; i++) {
            if(i > 0) System.out.print(",");
            System.out.print(output2[i]);
        }
        System.out.println("]");
        System.out.println("Expected: [0,1,3]");
    }
}