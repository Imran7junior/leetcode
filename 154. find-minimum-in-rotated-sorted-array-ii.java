class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < nums[r]) {
                r = mid;
            }
            else if (nums[mid] > nums[r]) {
                l = mid + 1;
            }
            // duplicates
            else {
                r--;
            }
        }

        return nums[l];
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] nums1 = {1, 3, 5};
        int result1 = solution.findMin(nums1);
        System.out.println("Example 1: Input: nums = [1, 3, 5]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 1\n");
        
        // Example 2
        int[] nums2 = {2, 2, 2, 0, 1};
        int result2 = solution.findMin(nums2);
        System.out.println("Example 2: Input: nums = [2, 2, 2, 0, 1]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 0");
    }
}