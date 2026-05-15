class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] < nums[r]) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }

        return nums[l];
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] nums1 = {3, 4, 5, 1, 2};
        int result1 = solution.findMin(nums1);
        System.out.println("Example 1: Input: nums = [3, 4, 5, 1, 2]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 1\n");
        
        // Example 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int result2 = solution.findMin(nums2);
        System.out.println("Example 2: Input: nums = [4, 5, 6, 7, 0, 1, 2]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 0\n");
        
        // Example 3
        int[] nums3 = {11, 13, 15, 17};
        int result3 = solution.findMin(nums3);
        System.out.println("Example 3: Input: nums = [11, 13, 15, 17]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: 11");
    }
}