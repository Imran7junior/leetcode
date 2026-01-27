import java.util.*;

class Solution {
    public int minCost(int n, int[][] edges) {
        // Building augmented graph
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, 2 * w});  // Reverse edge
        }
        
        // Initialize distance array from node 0
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        // Dijkstra using min heap: (distance, node)
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        heap.offer(new int[]{0, 0});
        
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int d = curr[0];
            int u = curr[1];
            
            if (u == n - 1) {  // Early exit
                return d;
            }
            
            if (d != dist[u]) {  // Stale edge
                continue;
            }
            
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];
                
                if (dist[u] + w < dist[v]) {  // Edge relaxation
                    dist[v] = dist[u] + w;
                    heap.offer(new int[]{dist[v], v});
                }
            }
        }
        
        // No path found
        return -1;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int n1 = 4;
        int[][] edges1 = {{0,1,3},{3,1,1},{2,3,4},{0,2,2}};
        int output1 = solution.minCost(n1, edges1);
        System.out.println("Test 1: n = 4, edges = [[0,1,3],[3,1,1],[2,3,4],[0,2,2]]");
        System.out.println("Output: " + output1 + ", Expected: 5");
        
        // Test case 2
        int n2 = 4;
        int[][] edges2 = {{0,2,1},{2,1,1},{1,3,1},{2,3,3}};
        int output2 = solution.minCost(n2, edges2);
        System.out.println("Test 2: n = 4, edges = [[0,2,1],[2,1,1],[1,3,1],[2,3,3]]");
        System.out.println("Output: " + output2 + ", Expected: 3");
        
        System.out.println("\nTest cases executed!");
    }
}
