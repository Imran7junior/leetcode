from typing import List
class Solution:
    def minRemoval(self, nums: List[int], k: int) -> int:
        nums.sort()

        removals = 0
        for num in nums:
            removals += num > nums[removals] * k

        return removals


if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1 = [2, 1, 5]
    k1 = 2
    print(sol.minRemoval(nums1, k1))  # Expected: 1
    
    # Example 2
    nums2 = [1, 6, 2, 9]
    k2 = 3
    print(sol.minRemoval(nums2, k2))  # Expected: 2
    
    # Example 3
    nums3 = [4, 6]
    k3 = 2
    print(sol.minRemoval(nums3, k3))  # Expected: 0