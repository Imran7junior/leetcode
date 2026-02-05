from typing import List
class Solution:
    def constructTransformedArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        return [nums[(i + x) % n] for i, x in enumerate(nums)]


if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1 = [3, -2, 1, 1]
    print(sol.constructTransformedArray(nums1))  # Expected: [1, 1, 1, 3]
    
    # Example 2
    nums2 = [-1, 4, -1]
    print(sol.constructTransformedArray(nums2))  # Expected: [-1, -1, 4]