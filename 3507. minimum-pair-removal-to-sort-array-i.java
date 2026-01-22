import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int minimumPairRemoval(List<Integer> nums) {
        // Create a mutable copy as ArrayList
        ArrayList<Integer> arr = new ArrayList<>(nums);
        
        int ans = 0;
        int n = arr.size();
        
        while (!isSorted(arr, n)) {
            ans++;
            int minSum = Integer.MAX_VALUE;
            int pos = -1;
            
            for (int i = 1; i < n; i++) {
                int sum = arr.get(i - 1) + arr.get(i);
                if (sum < minSum) {
                    minSum = sum;
                    pos = i;
                }
            }
            
            arr.set(pos - 1, minSum);
            arr.remove(pos);
            n--;
        }
        
        return ans;
    }
    
    private boolean isSorted(ArrayList<Integer> nums, int n) {
        for (int i = 1; i < n; i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        List<Integer> nums1 = Arrays.asList(5, 2, 3, 1);
        int output1 = solution.minimumPairRemoval(nums1);
        System.out.println("Test 1: nums = [5,2,3,1]");
        System.out.println("Output: " + output1 + ", Expected: 2");
        
        // Test case 2
        List<Integer> nums2 = Arrays.asList(1, 2, 2);
        int output2 = solution.minimumPairRemoval(nums2);
        System.out.println("Test 2: nums = [1,2,2]");
        System.out.println("Output: " + output2 + ", Expected: 0");
        
        System.out.println("\nTest cases executed!");
    }
}
