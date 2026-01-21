import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        
        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            if (n != 2) {
                ans[i] = n - ((n + 1) & (-n - 1)) / 2;
            } else {
                ans[i] = -1;
            }
        }
        
        return ans;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        List<Integer> nums1 = Arrays.asList(2, 3, 5, 7);
        int[] output1 = solution.minBitwiseArray(nums1);
        System.out.println("Test 1: nums = [2,3,5,7]");
        System.out.println("Output: " + Arrays.toString(output1) + ", Expected: [-1,1,4,3]");
        
        // Test case 2
        List<Integer> nums2 = Arrays.asList(11, 13, 31);
        int[] output2 = solution.minBitwiseArray(nums2);
        System.out.println("Test 2: nums = [11,13,31]");
        System.out.println("Output: " + Arrays.toString(output2) + ", Expected: [9,12,15]");
        
        System.out.println("\nTest cases executed!");
    }
}
