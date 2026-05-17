class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);

        while (!q.isEmpty()) {
            int i = q.poll();

            if (i < 0 || i >= n || visited[i])
                continue;

            if (arr[i] == 0)
                return true;

            visited[i] = true;

            q.offer(i + arr[i]);
            q.offer(i - arr[i]);
        }

        return false;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] arr1 = {4, 2, 3, 0, 3, 1, 2};
        int start1 = 5;
        boolean result1 = solution.canReach(arr1, start1);
        System.out.println("Example 1: Input: arr = [4, 2, 3, 0, 3, 1, 2], start = 5");
        System.out.println("Output: " + result1);
        System.out.println("Expected: true\n");
        
        // Example 2
        int[] arr2 = {4, 2, 3, 0, 3, 1, 2};
        int start2 = 0;
        boolean result2 = solution.canReach(arr2, start2);
        System.out.println("Example 2: Input: arr = [4, 2, 3, 0, 3, 1, 2], start = 0");
        System.out.println("Output: " + result2);
        System.out.println("Expected: true\n");
        
        // Example 3
        int[] arr3 = {3, 0, 2, 1, 2};
        int start3 = 2;
        boolean result3 = solution.canReach(arr3, start3);
        System.out.println("Example 3: Input: arr = [3, 0, 2, 1, 2], start = 2");
        System.out.println("Output: " + result3);
        System.out.println("Expected: false");
    }
}