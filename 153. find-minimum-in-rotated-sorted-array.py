class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1

        while l < r:

            mid = (l + r) // 2

            if nums[mid] < nums[r]:
                r = mid
            else:
                l = mid + 1

        return nums[l]


# Test cases
if __name__ == "__main__":
    from typing import List
    
    solution = Solution()
    
    # Example 1
    nums1 = [3, 4, 5, 1, 2]
    result1 = solution.findMin(nums1)
    print(f"Example 1: Input: nums = {nums1}")
    print(f"Output: {result1}")
    print(f"Expected: 1\n")
    
    # Example 2
    nums2 = [4, 5, 6, 7, 0, 1, 2]
    result2 = solution.findMin(nums2)
    print(f"Example 2: Input: nums = {nums2}")
    print(f"Output: {result2}")
    print(f"Expected: 0\n")
    
    # Example 3
    nums3 = [11, 13, 15, 17]
    result3 = solution.findMin(nums3)
    print(f"Example 3: Input: nums = {nums3}")
    print(f"Output: {result3}")
    print(f"Expected: 11")