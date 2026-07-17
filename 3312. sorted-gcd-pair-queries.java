import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int x : nums) maxVal = Math.max(maxVal, x);

        // frequency of each number
        long[] freq = new long[maxVal + 1];
        for (int x : nums) freq[x]++;

        // divCnt[g] = how many numbers are divisible by g
        long[] divCnt = new long[maxVal + 1];

        for (int g = 1; g <= maxVal; g++) {
            for (int x = g; x <= maxVal; x += g) {
                divCnt[g] += freq[x];
            }
        }

        // exact[g] = number of pairs whose gcd is exactly g
        long[] exact = new long[maxVal + 1];

        for (int g = maxVal; g >= 1; g--) {

            // choose any two numbers divisible by g
            exact[g] = divCnt[g] * (divCnt[g] - 1) / 2;

            // remove pairs whose gcd is a larger multiple of g
            for (int m = 2 * g; m <= maxVal; m += g) {
                exact[g] -= exact[m];
            }
        }

        // prefix[g] = number of pairs with gcd <= g
        long[] prefix = new long[maxVal + 1];

        for (int g = 1; g <= maxVal; g++) {
            prefix[g] = prefix[g - 1] + exact[g];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1;

            int left = 1, right = maxVal;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] >= target)
                    right = mid;
                else
                    left = mid + 1;
            }

            ans[i] = left;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] nums1 = {2, 3, 4};
        long[] queries1 = {0, 2, 2};
        System.out.println(Arrays.toString(sol.gcdValues(nums1, queries1)));
        // [1, 2, 2]

        // Example 2
        int[] nums2 = {4, 4, 2, 1};
        long[] queries2 = {5, 3, 1, 0};
        System.out.println(Arrays.toString(sol.gcdValues(nums2, queries2)));
        // [4, 2, 1, 1]

        // Example 3
        int[] nums3 = {2, 2};
        long[] queries3 = {0, 0};
        System.out.println(Arrays.toString(sol.gcdValues(nums3, queries3)));
        // [2, 2]
    }
}