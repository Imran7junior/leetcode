class Solution {
    public boolean check(int[] nums) {
        int breaks = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                breaks++;
            }
        }

        return breaks <= 1;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {3,4,5,1,2};
        boolean output1 = sol.check(nums1);
        System.out.println("Example 1: nums=[3,4,5,1,2]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: true");
        System.out.println();
        
        // Example 2
        int[] nums2 = {2,1,3,4};
        boolean output2 = sol.check(nums2);
        System.out.println("Example 2: nums=[2,1,3,4]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: false");
        System.out.println();
        
        // Example 3
        int[] nums3 = {1,2,3};
        boolean output3 = sol.check(nums3);
        System.out.println("Example 3: nums=[1,2,3]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: true");
    }
}