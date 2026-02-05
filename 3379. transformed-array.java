class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[(i + nums[i] % n + n) % n];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {3, -2, 1, 1};
        int[] result1 = sol.constructTransformedArray(nums1);
        System.out.print("[");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) System.out.print(", ");
        }
        System.out.println("]");  // Expected: [1, 1, 1, 3]
        
        // Example 2
        int[] nums2 = {-1, 4, -1};
        int[] result2 = sol.constructTransformedArray(nums2);
        System.out.print("[");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) System.out.print(", ");
        }
        System.out.println("]");  // Expected: [-1, -1, 4]
    }
}
