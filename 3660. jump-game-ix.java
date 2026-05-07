class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] suffixMin = new int[n + 1];
        suffixMin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int[] ans = new int[n];
        int l = 0;

        while (l < n) {
            int r = l;
            int componentMax = nums[l];

            while (r + 1 < n && componentMax > suffixMin[r + 1]) {
                r++;
                componentMax = Math.max(componentMax, nums[r]);
            }

            for (int i = l; i <= r; i++) {
                ans[i] = componentMax;
            }

            l = r + 1;
        }

        return ans;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] nums1 = {2, 1, 3};
        int[] result1 = solution.maxValue(nums1);
        System.out.println("Example 1: Input: nums = [2, 1, 3]");
        System.out.print("Output: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [2, 2, 3]\n");
        
        // Example 2
        int[] nums2 = {2, 3, 1};
        int[] result2 = solution.maxValue(nums2);
        System.out.println("Example 2: Input: nums = [2, 3, 1]");
        System.out.print("Output: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [3, 3, 3]");
    }
}