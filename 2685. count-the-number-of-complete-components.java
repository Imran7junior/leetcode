import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static int V, D;

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] A = new ArrayList[n];
        Arrays.setAll(A, _ -> new ArrayList<>());

        for (int[] e : edges) {
            A[e[0]].add(e[1]);
            A[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            boolean state = vis[i];

            if (!state) {
                V = 0;
                D = 0;

                dfs(i, A, vis);

                if (D == V * (V - 1))
                    res++;
            }
        }

        return res;
    }

    private void dfs(int x, List<Integer>[] A, boolean[] vis) {
        V++;
        D += A[x].size();
        vis[x] = true;

        for (int state : A[x])
            if (!vis[state])
                dfs(state, A, vis);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int n1 = 6;
        int[][] edges1 = {
            {0, 1}, {0, 2}, {1, 2}, {3, 4}
        };
        System.out.println(sol.countCompleteComponents(n1, edges1)); // 3

        // Example 2
        int n2 = 6;
        int[][] edges2 = {
            {0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}
        };
        System.out.println(sol.countCompleteComponents(n2, edges2)); // 1
    }
}