import java.util.Arrays;

class Solution {
    public int minimumCost(int[] nums) {
        int ans = nums[0];
        
        // Sort elements from index 1 onwards
        int[] remaining = Arrays.copyOfRange(nums, 1, nums.length);
        Arrays.sort(remaining);
        
        ans += remaining[0];
        ans += remaining[1];
        
        return ans;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {1, 2, 3, 12};
        int output1 = solution.minimumCost(nums1);
        System.out.println("Test 1: nums = [1,2,3,12]");
        System.out.println("Output: " + output1 + ", Expected: 6");
        
        // Test case 2
        int[] nums2 = {5, 4, 3};
        int output2 = solution.minimumCost(nums2);
        System.out.println("Test 2: nums = [5,4,3]");
        System.out.println("Output: " + output2 + ", Expected: 12");
        
        // Test case 3
        int[] nums3 = {10, 3, 1, 1};
        int output3 = solution.minimumCost(nums3);
        System.out.println("Test 3: nums = [10,3,1,1]");
        System.out.println("Output: " + output3 + ", Expected: 12");
        
        System.out.println("\nTest cases executed!");
    }
}
