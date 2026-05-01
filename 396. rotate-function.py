class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        n = len(nums)

        total_sum = sum(nums)
        F = sum(i * nums[i] for i in range(n))

        ans = F

        for k in range(1, n):
            F = F + total_sum - n * nums[n - k]
            ans = max(ans, F)

        return ans


# Test cases
if __name__ == "__main__":
    from typing import List
    
    solution = Solution()
    
    # Example 1
    nums1 = [4, 3, 2, 6]
    result1 = solution.maxRotateFunction(nums1)
    print(f"Example 1: Input: nums = {nums1}")
    print(f"Output: {result1}")
    print(f"Expected: 26\n")
    
    # Example 2
    nums2 = [100]
    result2 = solution.maxRotateFunction(nums2)
    print(f"Example 2: Input: nums = {nums2}")
    print(f"Output: {result2}")
    print(f"Expected: 0")