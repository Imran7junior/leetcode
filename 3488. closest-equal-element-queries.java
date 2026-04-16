import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> positions = new HashMap<>();

        for (int i = 0; i < n; i++) {
            positions.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        for (List<Integer> pos : positions.values()) {
            int m = pos.size();

            if (m == 1) continue;

            for (int i = 0; i < m; i++) {
                int curr = pos.get(i);

                int prev = pos.get((i - 1 + m) % m);
                int next = pos.get((i + 1) % m);

                int distPrev = Math.abs(curr - prev);
                distPrev = Math.min(distPrev, n - distPrev);

                int distNext = Math.abs(curr - next);
                distNext = Math.min(distNext, n - distNext);

                answer[curr] = Math.min(distPrev, distNext);
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int idx : queries) {
            result.add(answer[idx]);
        }

        return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {1,3,1,4,1,3,2};
        int[] queries1 = {0,3,5};
        List<Integer> output1 = sol.solveQueries(nums1, queries1);
        System.out.println("Example 1: nums=[1,3,1,4,1,3,2], queries=[0,3,5]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: [2,-1,3]");
        System.out.println();
        
        // Example 2
        int[] nums2 = {1,2,3,4};
        int[] queries2 = {0,1,2,3};
        List<Integer> output2 = sol.solveQueries(nums2, queries2);
        System.out.println("Example 2: nums=[1,2,3,4], queries=[0,1,2,3]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: [-1,-1,-1,-1]");
    }
}