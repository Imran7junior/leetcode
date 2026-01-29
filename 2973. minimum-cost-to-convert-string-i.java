class Solution {
    public long minimumCost(String source, String target, 
                           char[] original, char[] changed, int[] cost) {
        
        long INF = (long) 1e18;
        long[][] dist = new long[26][26];
        
        // Initialize distance matrix
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dist[i][j] = INF;
            }
            dist[i][i] = 0;
        }
        
        // Build initial edges
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        
        // Floyd-Warshall algorithm
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        // Calculate minimum cost
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            if (dist[u][v] == INF) {
                return -1;
            }
            ans += dist[u][v];
        }
        
        return ans;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        String source1 = "abcd";
        String target1 = "acbe";
        char[] original1 = {'a','b','c','c','e','d'};
        char[] changed1 = {'b','c','b','e','b','e'};
        int[] cost1 = {2,5,5,1,2,20};
        long output1 = solution.minimumCost(source1, target1, original1, changed1, cost1);
        System.out.println("Test 1: source = \"abcd\", target = \"acbe\"");
        System.out.println("Output: " + output1 + ", Expected: 28");
        
        // Test case 2
        String source2 = "aaaa";
        String target2 = "bbbb";
        char[] original2 = {'a','c'};
        char[] changed2 = {'c','b'};
        int[] cost2 = {1,2};
        long output2 = solution.minimumCost(source2, target2, original2, changed2, cost2);
        System.out.println("Test 2: source = \"aaaa\", target = \"bbbb\"");
        System.out.println("Output: " + output2 + ", Expected: 12");
        
        System.out.println("\nTest cases executed!");
    }
}
