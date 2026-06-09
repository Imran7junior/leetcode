class Solution {
    public long maxTotalValue(int[] A, int k) {
        int min = A[0], max = A[0];

        for (int n : A) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        return (long) (max - min) * k;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] A1 = {1,3,2};
        int k1 = 2;
        long output1 = sol.maxTotalValue(A1, k1);
        System.out.println("Example 1: A=[1,3,2], k=2");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 4");
        System.out.println();
        
        // Example 2
        int[] A2 = {4,2,5,1};
        int k2 = 3;
        long output2 = sol.maxTotalValue(A2, k2);
        System.out.println("Example 2: A=[4,2,5,1], k=3");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 12");
    }
}