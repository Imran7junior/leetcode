class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        long sum = 0;
        long F = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            F += (long) i * nums[i];
        }

        long ans = F;

        for (int k = 1; k < n; k++) {
            F = F + sum - (long) n * nums[n - k];
            ans = Math.max(ans, F);
        }

        return (int) ans;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] nums1 = {4, 3, 2, 6};
        int result1 = solution.maxRotateFunction(nums1);
        System.out.println("Example 1: Input: nums = [4, 3, 2, 6]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 26\n");
        
        // Example 2
        int[] nums2 = {100};
        int result2 = solution.maxRotateFunction(nums2);
        System.out.println("Example 2: Input: nums = [100]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 0");
    }
}