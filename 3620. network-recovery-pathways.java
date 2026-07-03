import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        ArrayList<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        int[] indegree = new int[n];

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.offer(i);

        ArrayList<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);

            for (int[] edge : graph[u]) {
                if (--indegree[edge[0]] == 0)
                    q.offer(edge[0]);
            }
        }

        int left = 0, right = 1_000_000_000;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long INF = Long.MAX_VALUE / 4;
            long[] dp = new long[n];
            Arrays.fill(dp, INF);
            dp[0] = 0;

            for (int u : topo) {

                if (dp[u] == INF)
                    continue;

                if (u != 0 && u != n - 1 && !online[u])
                    continue;

                for (int[] edge : graph[u]) {
                    int v = edge[0];
                    int w = edge[1];

                    if (w < mid)
                        continue;

                    if (v != n - 1 && !online[v])
                        continue;

                    dp[v] = Math.min(dp[v], dp[u] + w);
                }
            }

            if (dp[n - 1] <= k) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.findMaxPathScore(
            new int[][]{
                {0, 1, 5},
                {1, 3, 10},
                {0, 2, 3},
                {2, 3, 4}
            },
            new boolean[]{true, true, true, true},
            10
        )); // Expected: 3

        System.out.println(sol.findMaxPathScore(
            new int[][]{
                {0, 1, 7},
                {1, 4, 5},
                {0, 2, 6},
                {2, 3, 6},
                {3, 4, 2},
                {2, 4, 6}
            },
            new boolean[]{true, true, true, false, true},
            12
        )); // Expected: 6
    }
}