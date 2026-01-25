import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int j = k - 1;
        
        for (int i = 0; i < nums.length - j; i++) {
            ans = Math.min(ans, nums[i + j] - nums[i]);
        }
        
        return ans;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {90};
        int k1 = 1;
        int output1 = solution.minimumDifference(nums1, k1);
        System.out.println("Test 1: nums = [90], k = 1");
        System.out.println("Output: " + output1 + ", Expected: 0");
        
        // Test case 2
        int[] nums2 = {9, 4, 1, 7};
        int k2 = 2;
        int output2 = solution.minimumDifference(nums2, k2);
        System.out.println("Test 2: nums = [9,4,1,7], k = 2");
        System.out.println("Output: " + output2 + ", Expected: 2");
        
        System.out.println("\nTest cases executed!");
    }
}
