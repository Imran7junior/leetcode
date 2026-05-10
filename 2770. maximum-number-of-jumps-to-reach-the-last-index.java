class Solution {
    public int maximumJumps(int[] nums, int target) {

        int n = nums.length;

        // dp[i] stores maximum jumps to reach index i
        int[] dp = new int[n];

        // Mark all indices unreachable
        Arrays.fill(dp, -1);

        // Starting index needs 0 jumps
        dp[0] = 0;

        for(int i = 1; i < n; i++) {

            // Check all previous indices
            for(int j = 0; j < i; j++) {

                // Valid jump and previous index reachable
                if(Math.abs(nums[i] - nums[j]) <= target && dp[j] != -1) {

                    // Update maximum jumps
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] nums1 = {1, 3, 6, 4, 1, 2};
        int target1 = 2;
        int result1 = solution.maximumJumps(nums1, target1);
        System.out.println("Example 1: Input: nums = [1, 3, 6, 4, 1, 2], target = 2");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 3\n");
        
        // Example 2
        int[] nums2 = {1, 3, 6, 4, 1, 2};
        int target2 = 3;
        int result2 = solution.maximumJumps(nums2, target2);
        System.out.println("Example 2: Input: nums = [1, 3, 6, 4, 1, 2], target = 3");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 5\n");
        
        // Example 3
        int[] nums3 = {1, 3, 6, 4, 1, 2};
        int target3 = 0;
        int result3 = solution.maximumJumps(nums3, target3);
        System.out.println("Example 3: Input: nums = [1, 3, 6, 4, 1, 2], target = 0");
        System.out.println("Output: " + result3);
        System.out.println("Expected: -1");
    }
}