class Solution {
    public int[] leftRightDifference(int[] nums) {
        int rightSum = 0;

        for (int num : nums) {
            rightSum += num;
        }

        int leftSum = 0;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            result[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }

        return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {10,4,8,3};
        int[] output1 = sol.leftRightDifference(nums1);
        System.out.println("Example 1: nums=[10,4,8,3]");
        System.out.print("Output: [");
        for(int i = 0; i < output1.length; i++) {
            if(i > 0) System.out.print(",");
            System.out.print(output1[i]);
        }
        System.out.println("]");
        System.out.println("Expected: [15,1,11,22]");
        System.out.println();
        
        // Example 2
        int[] nums2 = {1};
        int[] output2 = sol.leftRightDifference(nums2);
        System.out.println("Example 2: nums=[1]");
        System.out.print("Output: [");
        for(int i = 0; i < output2.length; i++) {
            if(i > 0) System.out.print(",");
            System.out.print(output2[i]);
        }
        System.out.println("]");
        System.out.println("Expected: [0]");
    }
}