class Solution {
    private int find(int v, int[] parent) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = find(parent[v], parent);
    }

    private boolean unionSets(int a, int b, int[] parent, int[] size) {
        a = find(a, parent);
        b = find(b, parent);
        if (a != b) {
            if (size[a] < size[b]) {
                int temp = a; a = b; b = temp;
            }
            parent[b] = a;
            size[a] += size[b];
            return true;
        }
        return false;
    }

    public int maxStability(int n, int[][] edges, int k) {
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int comp = n;
        int res = Integer.MAX_VALUE;
        List<int[]> opt = new ArrayList<>();

        for (int[] edge : edges) {
            if (edge[3] == 1) {
                if (unionSets(edge[0], edge[1], parent, size)) {
                    comp--;
                    res = Math.min(res, edge[2]);
                } else {
                    return -1;
                }
            }
        }

        if (comp == 1) {
            return res;
        }

        for (int[] edge : edges) {
            if (edge[3] == 0) {
                opt.add(edge);
            }
        }

        opt.sort((a, b) -> b[2] - a[2]);

        List<Integer> stab = new ArrayList<>();
        for (int[] edge : opt) {
            if (unionSets(edge[0], edge[1], parent, size)) {
                comp--;
                stab.add(edge[2]);
                if (comp == 1) break;
            }
        }

        if (comp > 1) {
            return -1;
        }
        for (int i = 1; i <= k && i <= stab.size(); i++) {
            int idx = stab.size() - i;
            stab.set(idx, stab.get(idx) * 2);
        }

        int minStab = Integer.MAX_VALUE;
        for (int val : stab) {
            minStab = Math.min(minStab, val);
        }

        return Math.min(res, minStab);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int n1 = 3;
        int[][] edges1 = {{0,1,2,1},{1,2,3,0}};
        int k1 = 1;
        int output1 = sol.maxStability(n1, edges1, k1);
        System.out.println("Example 1: Input: n = " + n1 + ", edges = [[0,1,2,1],[1,2,3,0]], k = " + k1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 2");
        System.out.println();
        
        // Example 2:
        int n2 = 3;
        int[][] edges2 = {{0,1,4,0},{1,2,3,0},{0,2,1,0}};
        int k2 = 2;
        int output2 = sol.maxStability(n2, edges2, k2);
        System.out.println("Example 2: Input: n = " + n2 + ", edges = [[0,1,4,0],[1,2,3,0],[0,2,1,0]], k = " + k2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 6");
        System.out.println();
        
        // Example 3:
        int n3 = 3;
        int[][] edges3 = {{0,1,1,1},{1,2,1,1},{2,0,1,1}};
        int k3 = 0;
        int output3 = sol.maxStability(n3, edges3, k3);
        System.out.println("Example 3: Input: n = " + n3 + ", edges = [[0,1,1,1],[1,2,1,1],[2,0,1,1]], k = " + k3);
        System.out.println("Output: " + output3);
        System.out.println("Expected: -1");
    }
}