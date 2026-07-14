import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->
            a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]
        );

        int count = 0;
        int maxEnd = 0;

        for (int[] interval : intervals) {
            if (interval[1] > maxEnd) {
                count++;
                maxEnd = interval[1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[][] intervals1 = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println(sol.removeCoveredIntervals(intervals1)); // 2

        // Example 2
        int[][] intervals2 = {{1, 4}, {2, 3}};
        System.out.println(sol.removeCoveredIntervals(intervals2)); // 1
    }
}