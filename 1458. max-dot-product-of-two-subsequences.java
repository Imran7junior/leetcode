import java.util.*;

class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        if (m > n) {
            return maxDotProduct(nums2, nums1);
        }
        
        int[] dp = new int[m + 1];
        Arrays.fill(dp, -1000000000); 
        
        for (int i = 1; i <= n; i++) {
            int prev_diag = -1000000000;
            
            for (int j = 1; j <= m; j++) {
                int curr_product = nums1[i-1] * nums2[j-1];
                int temp = dp[j];
                
                int option1 = curr_product;
                int option2 = curr_product + prev_diag;
                int option3 = dp[j];
                int option4 = dp[j-1];
                
                dp[j] = Math.max(Math.max(option1, option2), Math.max(option3, option4));
                
                prev_diag = temp;
            }
        }
        
        return dp[m];
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
        // Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
        // Their dot product is (2*3 + (-2)*(-6)) = 18.
        // Expected output: 18
        int result1 = sol.maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6});
        System.out.println("Example 1: " + result1);
        assert result1 == 18 : "Expected 18, got " + result1;
        
        // Example 2: nums1 = [3,-2], nums2 = [2,-6,7]
        // Take subsequence [3] from nums1 and subsequence [7] from nums2.
        // Their dot product is (3*7) = 21.
        // Expected output: 21
        int result2 = sol.maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7});
        System.out.println("Example 2: " + result2);
        assert result2 == 21 : "Expected 21, got " + result2;
        
        // Example 3: nums1 = [-1,-1], nums2 = [1,1]
        // Take subsequence [-1] from nums1 and subsequence [1] from nums2.
        // Their dot product is -1.
        // Expected output: -1
        int result3 = sol.maxDotProduct(new int[]{-1, -1}, new int[]{1, 1});
        System.out.println("Example 3: " + result3);
        assert result3 == -1 : "Expected -1, got " + result3;
        
        System.out.println("All test cases passed!");
    }
}