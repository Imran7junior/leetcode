class Solution:
    def isGood(self, nums: List[int]) -> bool:
        mx = max(nums)

        # size must be mx + 1
        if len(nums) != mx + 1:
            return False

        freq = [0] * (mx + 1)

        for x in nums:
            # invalid number
            if x < 1 or x > mx:
                return False

            freq[x] += 1

        # 1 to mx-1 should appear once
        for i in range(1, mx):
            if freq[i] != 1:
                return False

        # mx should appear twice
        return freq[mx] == 2


# Test cases
if __name__ == "__main__":
    from typing import List
    
    solution = Solution()
    
    # Example 1
    nums1 = [2, 1, 3]
    result1 = solution.isGood(nums1)
    print(f"Example 1: Input: nums = {nums1}")
    print(f"Output: {result1}")
    print(f"Expected: False\n")
    
    # Example 2
    nums2 = [1, 3, 3, 2]
    result2 = solution.isGood(nums2)
    print(f"Example 2: Input: nums = {nums2}")
    print(f"Output: {result2}")
    print(f"Expected: True\n")
    
    # Example 3
    nums3 = [1, 1]
    result3 = solution.isGood(nums3)
    print(f"Example 3: Input: nums = {nums3}")
    print(f"Output: {result3}")
    print(f"Expected: True\n")
    
    # Example 4
    nums4 = [3, 4, 4, 1, 2, 1]
    result4 = solution.isGood(nums4)
    print(f"Example 4: Input: nums = {nums4}")
    print(f"Output: {result4}")
    print(f"Expected: False")