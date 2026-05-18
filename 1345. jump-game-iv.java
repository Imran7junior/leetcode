import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        // Map each value to list of indices where it appears
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int idx = queue.poll();

            if (idx == n - 1) return dist[idx];

            // Jump to idx+1
            if (idx + 1 < n && dist[idx + 1] == -1) {
                dist[idx + 1] = dist[idx] + 1;
                queue.offer(idx + 1);
            }
            // Jump to idx-1 (only if >0 because 0 is already visited)
            if (idx - 1 > 0 && dist[idx - 1] == -1) {
                dist[idx - 1] = dist[idx] + 1;
                queue.offer(idx - 1);
            }

            // Jump to any index with same value
            if (map.containsKey(arr[idx])) {
                for (int j : map.get(arr[idx])) {
                    if (dist[j] == -1) {
                        dist[j] = dist[idx] + 1;
                        queue.offer(j);
                    }
                }
                map.get(arr[idx]).clear(); // Avoid reprocessing same value
            }
        }
        return -1; 
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] arr1 = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        int result1 = solution.minJumps(arr1);
        System.out.println("Example 1: Input: arr = [100, -23, -23, 404, 100, 23, 23, 23, 3, 404]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 3\n");
        
        // Example 2
        int[] arr2 = {7};
        int result2 = solution.minJumps(arr2);
        System.out.println("Example 2: Input: arr = [7]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 0\n");
        
        // Example 3
        int[] arr3 = {7, 6, 9, 6, 9, 6, 9, 7};
        int result3 = solution.minJumps(arr3);
        System.out.println("Example 3: Input: arr = [7, 6, 9, 6, 9, 6, 9, 7]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: 1");
    }
}