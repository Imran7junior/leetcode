class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int curr = 0;
        int ans  = 0;
        for (int[] task : tasks) {
            int actual  = task[0];
            int minimum = task[1];
            if (curr < minimum) {
                ans  += (minimum - curr);
                curr  = minimum;
            }
            curr -= actual;
        }
        return ans;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[][] tasks1 = {{1,2},{2,4},{4,8}};
        int result1 = solution.minimumEffort(tasks1);
        System.out.println("Example 1: Input: tasks = [[1,2],[2,4],[4,8]]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 8\n");
        
        // Example 2
        int[][] tasks2 = {{1,3},{2,4},{10,11},{10,12},{8,9}};
        int result2 = solution.minimumEffort(tasks2);
        System.out.println("Example 2: Input: tasks = [[1,3],[2,4],[10,11],[10,12],[8,9]]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 32\n");
        
        // Example 3
        int[][] tasks3 = {{1,7},{2,8},{3,9},{4,10},{5,11},{6,12}};
        int result3 = solution.minimumEffort(tasks3);
        System.out.println("Example 3: Input: tasks = [[1,7],[2,8],[3,9],[4,10],[5,11],[6,12]]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: 27");
    }
}