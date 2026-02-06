import java.util.Arrays;

class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int removals = 0;
        for (long num: nums)
            removals += (num > (long) nums[removals] * k) ? 1 : 0;

        return removals;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {2, 1, 5};
        int k1 = 2;
        System.out.println(sol.minRemoval(nums1, k1));  // Expected: 1
        
        // Example 2
        int[] nums2 = {1, 6, 2, 9};
        int k2 = 3;
        System.out.println(sol.minRemoval(nums2, k2));  // Expected: 2
        
        // Example 3
        int[] nums3 = {4, 6};
        int k3 = 2;
        System.out.println(sol.minRemoval(nums3, k3));  // Expected: 0
    }
}