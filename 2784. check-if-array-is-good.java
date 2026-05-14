class Solution {
    public boolean isGood(int[] nums) {
        int mx = 0;

        for (int x : nums) {
            mx = Math.max(mx, x);
        }

        // size must be mx + 1
        if (nums.length != mx + 1)
            return false;

        int[] freq = new int[mx + 1];

        for (int x : nums) {
            // invalid number
            if (x < 1 || x > mx)
                return false;

            freq[x]++;
        }

        // 1 to mx-1 should appear once
        for (int i = 1; i < mx; i++) {

            if (freq[i] != 1)
                return false;
        }

        // mx should appear twice
        return freq[mx] == 2;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] nums1 = {2, 1, 3};
        boolean result1 = solution.isGood(nums1);
        System.out.println("Example 1: Input: nums = [2, 1, 3]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: false\n");
        
        // Example 2
        int[] nums2 = {1, 3, 3, 2};
        boolean result2 = solution.isGood(nums2);
        System.out.println("Example 2: Input: nums = [1, 3, 3, 2]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: true\n");
        
        // Example 3
        int[] nums3 = {1, 1};
        boolean result3 = solution.isGood(nums3);
        System.out.println("Example 3: Input: nums = [1, 1]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: true\n");
        
        // Example 4
        int[] nums4 = {3, 4, 4, 1, 2, 1};
        boolean result4 = solution.isGood(nums4);
        System.out.println("Example 4: Input: nums = [3, 4, 4, 1, 2, 1]");
        System.out.println("Output: " + result4);
        System.out.println("Expected: false");
    }
}