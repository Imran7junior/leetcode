public import java.util.Arrays;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] newNums = new int[n][2];
        for (int i = 0; i < n; i++)
            newNums[i] = new int[]{nums[i], i};

        Arrays.sort(newNums, (a, b) -> a[0] - b[0]);

        int[] getI = new int[n];
        for (int i = 0; i < n; i++)
            getI[newNums[i][1]] = i;

        int[][] st = new int[n][18];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (r < i)
                r = i;
            while (r + 1 < n &&
                   newNums[r + 1][0] - newNums[r][0] <= maxDiff &&
                   newNums[r + 1][0] - newNums[i][0] <= maxDiff)
                r++;
            st[i][0] = r;
        }

        for (int j = 1; j < 18; j++)
            for (int i = 0; i < n; i++)
                st[i][j] = st[st[i][j - 1]][j - 1];

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = getI[queries[i][0]], b = getI[queries[i][1]];
            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }
            if (a == b) {
                ans[i] = 0;
                continue;
            }

            int curr = a, steps = 0;
            for (int j = 17; j >= 0; j--)
                if (st[curr][j] < b) {
                    curr = st[curr][j];
                    steps += (1 << j);
                }

            ans[i] = (st[curr][0] >= b) ? steps + 1 : -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int n1 = 5;
        int[] nums1 = {1, 8, 3, 4, 2};
        int maxDiff1 = 3;
        int[][] queries1 = {{0, 3}, {2, 4}};
        System.out.println(Arrays.toString(sol.pathExistenceQueries(n1, nums1, maxDiff1, queries1))); // [1, 1]

        // Example 2
        int n2 = 5;
        int[] nums2 = {5, 3, 1, 9, 10};
        int maxDiff2 = 2;
        int[][] queries2 = {{0, 1}, {0, 2}, {2, 3}, {4, 3}};
        System.out.println(Arrays.toString(sol.pathExistenceQueries(n2, nums2, maxDiff2, queries2))); // [1, 2, -1, 1]

        // Example 3
        int n3 = 3;
        int[] nums3 = {3, 6, 1};
        int maxDiff3 = 1;
        int[][] queries3 = {{0, 0}, {0, 1}, {1, 2}};
        System.out.println(Arrays.toString(sol.pathExistenceQueries(n3, nums3, maxDiff3, queries3))); // [0, -1, -1]
    }
} {
	
}
