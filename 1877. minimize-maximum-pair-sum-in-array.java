import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        int[] freq = new int[100001];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minVal) minVal = nums[i];
            if (nums[i] > maxVal) maxVal = nums[i];
            freq[nums[i]]++;
        }
        
        int maxSum = 0;
        int l = minVal;
        int r = maxVal;
        
        while (l <= r) {
            if (freq[l] == 0) {
                l++;
            } else if (freq[r] == 0) {
                r--;
            } else {
                maxSum = Math.max(maxSum, l + r);
                freq[l]--;
                freq[r]--;
            }
        }
        
        return maxSum;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {3, 5, 2, 3};
        int output1 = solution.minPairSum(nums1);
        System.out.println("Test 1: nums = [3,5,2,3]");
        System.out.println("Output: " + output1 + ", Expected: 7");
        
        // Test case 2
        int[] nums2 = {3, 5, 4, 2, 4, 6};
        int output2 = solution.minPairSum(nums2);
        System.out.println("Test 2: nums = [3,5,4,2,4,6]");
        System.out.println("Output: " + output2 + ", Expected: 8");
        
        System.out.println("\nTest cases executed!");
    }
}
