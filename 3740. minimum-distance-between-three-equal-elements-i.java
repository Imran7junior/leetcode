import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int ans = Integer.MAX_VALUE;
        
        for (List<Integer> indices : map.values()) {
            if (indices.size() < 3) continue;
            
            for (int i = 0; i + 2 < indices.size(); i++) {
                int distance = 2 * (indices.get(i + 2) - indices.get(i));
                ans = Math.min(ans, distance);
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {1,2,1,1,3};
        int output1 = sol.minimumDistance(nums1);
        System.out.println("Example 1: nums=[1,2,1,1,3]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 6");
        System.out.println();
        
        // Example 2
        int[] nums2 = {1,1,2,3,2,1,2};
        int output2 = sol.minimumDistance(nums2);
        System.out.println("Example 2: nums=[1,1,2,3,2,1,2]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 8");
        System.out.println();
        
        // Example 3
        int[] nums3 = {1};
        int output3 = sol.minimumDistance(nums3);
        System.out.println("Example 3: nums=[1]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: -1");
    }
}