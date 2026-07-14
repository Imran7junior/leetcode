import java.util.Arrays;

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];

        int val = 0;
        component[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                val++;
            }
            component[i] = val;
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            ans[i] = component[u] == component[v];
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int n1 = 2;
        int[] nums1 = {1, 3};
        int maxDiff1 = 1;
        int[][] queries1 = {{0, 0}, {0, 1}};
        System.out.println(Arrays.toString(sol.pathExistenceQueries(n1, nums1, maxDiff1, queries1)));
        // [true, false]

        // Example 2
        int n2 = 4;
        int[] nums2 = {2, 5, 6, 8};
        int maxDiff2 = 2;
        int[][] queries2 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        System.out.println(Arrays.toString(sol.pathExistenceQueries(n2, nums2, maxDiff2, queries2)));
        // [false, false, true, true]
    }
}