from typing import List

class Solution:
    def maxValue(self, nums: List[int]) -> List[int]:
        n = len(nums)

        suffixMin = [0] * (n + 1)
        suffixMin[n] = float("inf")
        for i in range(n - 1, -1, -1):
            suffixMin[i] = min(nums[i], suffixMin[i + 1])

        ans = [0] * n
        l = 0

        while l < n:
            r = l
            component_max = nums[l]

            while r + 1 < n and component_max > suffixMin[r + 1]:
                r += 1
                component_max = max(component_max, nums[r])

            for i in range(l, r + 1):
                ans[i] = component_max

            l = r + 1

        return ans


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Example 1
    nums1 = [2, 1, 3]
    result1 = solution.maxValue(nums1)
    print(f"Example 1: Input: nums = {nums1}")
    print(f"Output: {result1}")
    print(f"Expected: [2, 2, 3]\n")
    
    # Example 2
    nums2 = [2, 3, 1]
    result2 = solution.maxValue(nums2)
    print(f"Example 2: Input: nums = {nums2}")
    print(f"Output: {result2}")
    print(f"Expected: [3, 3, 3]")