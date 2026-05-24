class Solution {
    int[] dp;

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        dp = new int[n];

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, arr, d));
        }

        return ans;
    }

    private int dfs(int i, int[] arr, int d) {
        if (dp[i] != 0)
            return dp[i];

        int best = 1;

        for (int nxt = i + 1; nxt <= Math.min(arr.length - 1, i + d); nxt++) {
            if (arr[nxt] >= arr[i])
                break;

            best = Math.max(best, 1 + dfs(nxt, arr, d));
        }

        for (int nxt = i - 1; nxt >= Math.max(0, i - d); nxt--) {
            if (arr[nxt] >= arr[i])
                break;

            best = Math.max(best, 1 + dfs(nxt, arr, d));
        }

        return dp[i] = best;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] arr1 = {6,4,14,6,8,13,9,7,10,6,12};
        int d1 = 2;
        int output1 = sol.maxJumps(arr1, d1);
        System.out.println("Example 1: arr=[6,4,14,6,8,13,9,7,10,6,12], d=2");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 4");
        System.out.println();
        
        // Example 2
        int[] arr2 = {3,3,3,3,3};
        int d2 = 3;
        int output2 = sol.maxJumps(arr2, d2);
        System.out.println("Example 2: arr=[3,3,3,3,3], d=3");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 3
        int[] arr3 = {7,6,5,4,3,2,1};
        int d3 = 1;
        int output3 = sol.maxJumps(arr3, d3);
        System.out.println("Example 3: arr=[7,6,5,4,3,2,1], d=1");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 7");
    }
}