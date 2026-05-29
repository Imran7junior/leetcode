class Solution {
    public int minElement(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        
        for (int num : nums) {
            int currentSum = 0;
            
            while (num > 0) {
                currentSum += num % 10;
                num /= 10;
            }
            
            minVal = Math.min(minVal, currentSum);
        }
        
        return minVal;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {10,12,13,14};
        int output1 = sol.minElement(nums1);
        System.out.println("Example 1: nums=[10,12,13,14]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 2
        int[] nums2 = {1,2,3,4};
        int output2 = sol.minElement(nums2);
        System.out.println("Example 2: nums=[1,2,3,4]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 3
        int[] nums3 = {999,19,199};
        int output3 = sol.minElement(nums3);
        System.out.println("Example 3: nums=[999,19,199]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 10");
    }
}