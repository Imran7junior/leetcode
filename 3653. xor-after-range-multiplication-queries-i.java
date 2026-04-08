class Solution {
    int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            for (int i = l; i <= r; i += k) {
                nums[i] = (int)((1L * nums[i] * v) % MOD);
            }
        }

        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {1,1,1};
        int[][] queries1 = {{0,2,1,4}};
        int output1 = sol.xorAfterQueries(nums1, queries1);
        System.out.println("Example 1: nums=[1,1,1], queries=[[0,2,1,4]]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 4");
        System.out.println();
        
        // Example 2
        int[] nums2 = {2,3,1,5,4};
        int[][] queries2 = {{1,4,2,3},{0,2,1,2}};
        int output2 = sol.xorAfterQueries(nums2, queries2);
        System.out.println("Example 2: nums=[2,3,1,5,4], queries=[[1,4,2,3],[0,2,1,2]]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 31");
    }
}