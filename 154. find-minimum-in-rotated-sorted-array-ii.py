class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1

        while l < r:
            mid = (l + r) // 2

            if nums[mid] < nums[r]:
                r = mid
            elif nums[mid] > nums[r]:
                l = mid + 1
            # duplicates
            else:
                r -= 1

        return nums[l]


# Test cases
if __name__ == "__main__":
    from typing import List
    
    solution = Solution()
    
    # Example 1
    nums1 = [1, 3, 5]
    result1 = solution.findMin(nums1)
    print(f"Example 1: Input: nums = {nums1}")
    print(f"Output: {result1}")
    print(f"Expected: 1\n")
    
    # Example 2
    nums2 = [2, 2, 2, 0, 1]
    result2 = solution.findMin(nums2)
    print(f"Example 2: Input: nums = {nums2}")
    print(f"Output: {result2}")
    print(f"Expected: 0")