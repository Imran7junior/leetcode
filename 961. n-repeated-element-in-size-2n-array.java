import java.util.*;

class Solution {
    public int repeatedNTimes(int[] nums) {
        // Check consecutive and nearby elements
        for (int i = 0; i < nums.length - 1; i++) {
            // Check adjacent element
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
            // Check element 2 positions away
            if (i < nums.length - 2 && nums[i] == nums[i + 2]) {
                return nums[i];
            }
        }
        
        // Edge case: pattern like [x, a, b, x]
        return nums[0];
    }
    
    public int repeatedNTimes_set(int[] nums) {
        // Using HashSet approach - O(n) time, O(n) space
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1; // Should never reach here
    }
    
    public int repeatedNTimes_map(int[] nums) {
        // Using HashMap to count - O(n) time, O(n) space
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) > 1) {
                return num;
            }
        }
        return -1; // Should never reach here
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test 1
        int[] nums1 = {1, 2, 3, 3};
        int result1 = solution.repeatedNTimes(nums1);
        System.out.println("Test 1: nums=" + Arrays.toString(nums1));
        System.out.println("Output: " + result1 + ", Expected: 3\n");
        
        // Test 2
        int[] nums2 = {2, 1, 2, 5, 3, 2};
        int result2 = solution.repeatedNTimes(nums2);
        System.out.println("Test 2: nums=" + Arrays.toString(nums2));
        System.out.println("Output: " + result2 + ", Expected: 2\n");
        
        // Test 3
        int[] nums3 = {5, 1, 5, 2, 5, 3, 5, 4};
        int result3 = solution.repeatedNTimes(nums3);
        System.out.println("Test 3: nums=" + Arrays.toString(nums3));
        System.out.println("Output: " + result3 + ", Expected: 5\n");
        
    }
}
