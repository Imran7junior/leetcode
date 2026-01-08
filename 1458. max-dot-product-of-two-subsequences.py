from typing import List

class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        n, m = len(nums1), len(nums2)
        
        if m > n:
            return self.maxDotProduct(nums2, nums1)
            
        dp = [float('-inf')] * (m + 1)
        
        for i in range(1, n + 1):
            prev_diag = float('-inf')
            
            for j in range(1, m + 1):
                curr_product = nums1[i-1] * nums2[j-1]
                
                temp = dp[j]
                
                dp[j] = max(
                    curr_product,               
                    curr_product + prev_diag,   
                    dp[j],                       
                    dp[j-1]                      
                )
                
                prev_diag = temp

        return dp[m]


# Test cases
if __name__ == "__main__":
    sol = Solution()
    
    # Example 1: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
    # Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
    # Their dot product is (2*3 + (-2)*(-6)) = 18.
    # Expected output: 18
    result1 = sol.maxDotProduct([2, 1, -2, 5], [3, 0, -6])
    print(f"Example 1: {result1}")
    assert result1 == 18, f"Expected 18, got {result1}"
    
    # Example 2: nums1 = [3,-2], nums2 = [2,-6,7]
    # Take subsequence [3] from nums1 and subsequence [7] from nums2.
    # Their dot product is (3*7) = 21.
    # Expected output: 21
    result2 = sol.maxDotProduct([3, -2], [2, -6, 7])
    print(f"Example 2: {result2}")
    assert result2 == 21, f"Expected 21, got {result2}"
    
    # Example 3: nums1 = [-1,-1], nums2 = [1,1]
    # Take subsequence [-1] from nums1 and subsequence [1] from nums2.
    # Their dot product is -1.
    # Expected output: -1
    result3 = sol.maxDotProduct([-1, -1], [1, 1])
    print(f"Example 3: {result3}")
    assert result3 == -1, f"Expected -1, got {result3}"
    
    print("All test cases passed!")
