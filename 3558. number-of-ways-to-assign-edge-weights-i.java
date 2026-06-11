class Solution {
    private static final int mod = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());
        
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        return (int) pow(2, dfs(1, 0, graph) - 1);
    }

    private int dfs(int node, int prev, List<Integer>[] graph) {
        int dist = 0;
        for (int g : graph[node])
            if (g != prev)
                dist = Math.max(dist, dfs(g, node, graph) + 1);
        return dist;
    }

    private long pow(long base, int exp) {
        long res = 1;
        while (exp > 0) {
            if (exp % 2 > 0)
                res = res * base % mod;
            base = base * base % mod;
            exp /= 2;
        }
        return res;
    }
}

class TestAssignEdgeWeights {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[][] edges1 = {{1,2}};
        int output1 = sol.assignEdgeWeights(edges1);
        System.out.println("Example 1: edges=[[1,2]]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 2
        int[][] edges2 = {{1,2},{1,3},{3,4},{3,5}};
        int output2 = sol.assignEdgeWeights(edges2);
        System.out.println("Example 2: edges=[[1,2],[1,3],[3,4],[3,5]]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 2");
    }
}