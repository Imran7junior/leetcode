class Solution {

    int[] parent, rank;

    int find(int x){
        if(parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void unite(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return;

        if(rank[a] < rank[b]){
            int temp = a;
            a = b;
            b = temp;
        }

        parent[b] = a;
        if(rank[a] == rank[b]) rank[a]++;
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++) parent[i] = i;

        for(int[] e : allowedSwaps){
            unite(e[0], e[1]);
        }

        Map<Integer, List<Integer>> groups = new HashMap<>();

        for(int i=0;i<n;i++){
            int root = find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        int ans = 0;

        for(List<Integer> idxs : groups.values()){
            Map<Integer,Integer> freq = new HashMap<>();

            for(int i : idxs)
                freq.put(source[i], freq.getOrDefault(source[i],0)+1);

            for(int i : idxs){
                if(freq.getOrDefault(target[i],0) > 0){
                    freq.put(target[i], freq.get(target[i]) - 1);
                }else{
                    ans++;
                }
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] source1 = {1,2,3,4};
        int[] target1 = {2,1,4,5};
        int[][] allowedSwaps1 = {{0,1},{2,3}};
        int output1 = sol.minimumHammingDistance(source1, target1, allowedSwaps1);
        System.out.println("Example 1: source=[1,2,3,4], target=[2,1,4,5], allowedSwaps=[[0,1],[2,3]]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 2
        int[] source2 = {1,2,3,4};
        int[] target2 = {1,3,2,4};
        int[][] allowedSwaps2 = {};
        int output2 = sol.minimumHammingDistance(source2, target2, allowedSwaps2);
        System.out.println("Example 2: source=[1,2,3,4], target=[1,3,2,4], allowedSwaps=[]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 2");
        System.out.println();
        
        // Example 3
        int[] source3 = {5,1,2,4,3};
        int[] target3 = {1,5,4,2,3};
        int[][] allowedSwaps3 = {{0,4},{4,2},{1,3},{1,4}};
        int output3 = sol.minimumHammingDistance(source3, target3, allowedSwaps3);
        System.out.println("Example 3: source=[5,1,2,4,3], target=[1,5,4,2,3], allowedSwaps=[[0,4],[4,2],[1,3],[1,4]]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 0");
    }
}