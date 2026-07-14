public import java.util.Arrays;

class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int m = queries.length;
        long MOD = 1000000007L;

        long[] prefSum = new long[n + 1];
        long[] prefVal = new long[n + 1];
        int[] prefCnt = new int[n + 1];
        long[] power = new long[n + 1];

        power[0] = 1;

        for (int i = 1; i <= n; i++) {
            power[i] = (power[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            prefSum[i + 1] = prefSum[i] + d;
            prefCnt[i + 1] = prefCnt[i] + (d != 0 ? 1 : 0);

            if (d == 0) {
                prefVal[i + 1] = prefVal[i];
            } else {
                prefVal[i + 1] = (prefVal[i] * 10 + d) % MOD;
            }
        }

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int len = prefCnt[r + 1] - prefCnt[l];

            long start = prefVal[l];
            long end = prefVal[r + 1];

            long x = (end - (start * power[len]) % MOD + MOD) % MOD;
            long sum = prefSum[r + 1] - prefSum[l];

            result[i] = (int) ((x * sum) % MOD);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        String s1 = "10203004";
        int[][] queries1 = {{0, 7}, {1, 3}, {4, 6}};
        System.out.println(Arrays.toString(sol.sumAndMultiply(s1, queries1)));
        // [12340, 4, 9]

        // Example 2
        String s2 = "1000";
        int[][] queries2 = {{0, 3}, {1, 1}};
        System.out.println(Arrays.toString(sol.sumAndMultiply(s2, queries2)));
        // [1, 0]

        // Example 3
        String s3 = "9876543210";
        int[][] queries3 = {{0, 9}};
        System.out.println(Arrays.toString(sol.sumAndMultiply(s3, queries3)));
        // [444444137]
    }
} {
	
}
