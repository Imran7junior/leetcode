class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0;

        for (int i = cost.length - 1; i >= 0; i -= 3) {
            total += cost[i];
            if (i - 1 >= 0)
                total += cost[i - 1];
        }

        return total;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] cost1 = {1,2,3};
        int output1 = sol.minimumCost(cost1);
        System.out.println("Example 1: cost=[1,2,3]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 5");
        System.out.println();
        
        // Example 2
        int[] cost2 = {6,5,7,9,2,2};
        int output2 = sol.minimumCost(cost2);
        System.out.println("Example 2: cost=[6,5,7,9,2,2]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 23");
        System.out.println();
        
        // Example 3
        int[] cost3 = {5,5};
        int output3 = sol.minimumCost(cost3);
        System.out.println("Example 3: cost=[5,5]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 10");
    }
}