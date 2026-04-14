import java.util.*;

class Solution {
    long[][] dp;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int n = robot.size();
        int m = factory.length;

        dp = new long[n][m];
        for (long[] row : dp) Arrays.fill(row, -1);

        return solve(0, 0, robot, factory);
    }

    private long solve(int i, int j, List<Integer> robot, int[][] factory) {
        int n = robot.size();
        int m = factory.length;

        // all robots assigned
        if (i == n) return 0;

        // no factory left
        if (j == m) return (long)1e15;

        if (dp[i][j] != -1) return dp[i][j];

        long res = solve(i, j + 1, robot, factory); // skip factory

        long cost = 0;
        int pos = factory[j][0];
        int limit = factory[j][1];

        // assign k robots to this factory
        for (int k = 0; k < limit && i + k < n; k++) {
            cost += Math.abs(robot.get(i + k) - pos);
            res = Math.min(res, cost + solve(i + k + 1, j + 1, robot, factory));
        }

        return dp[i][j] = res;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        List<Integer> robot1 = Arrays.asList(0, 4, 6);
        int[][] factory1 = {{2, 2}, {6, 2}};
        long output1 = sol.minimumTotalDistance(robot1, factory1);
        System.out.println("Example 1: robot=[0,4,6], factory=[[2,2],[6,2]]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 4");
        System.out.println();
        
        // Example 2
        List<Integer> robot2 = Arrays.asList(1, -1);
        int[][] factory2 = {{-2, 1}, {2, 1}};
        long output2 = sol.minimumTotalDistance(robot2, factory2);
        System.out.println("Example 2: robot=[1,-1], factory=[[-2,1],[2,1]]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 2");
    }
}