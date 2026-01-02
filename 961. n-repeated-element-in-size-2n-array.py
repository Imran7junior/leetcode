from typing import List

class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        # Check consecutive and nearby elements
        for i in range(len(nums) - 1):
            # Check adjacent element
            if nums[i] == nums[i + 1]:
                return nums[i]
            # Check element 2 positions away
            if i < len(nums) - 2 and nums[i] == nums[i + 2]:
                return nums[i]
        
        # Edge case: pattern like [x, a, b, x]
        return nums[0]
    
    def repeatedNTimes_set(self, nums: List[int]) -> int:
        seen = set()
        for num in nums:
            if num in seen:
                return num
            seen.add(num)
    
    def repeatedNTimes_counter(self, nums: List[int]) -> int:
        from collections import Counter
        count = Counter(nums)
        for num, freq in count.items():
            if freq > 1:
                return num


# Test cases
solution = Solution()

# Test 1
nums1 = [1, 2, 3, 3]
result1 = solution.repeatedNTimes(nums1)
print(f"Test 1: nums={nums1}")
print(f"Output: {result1}, Expected: 3\n")

# Test 2
nums2 = [2, 1, 2, 5, 3, 2]
result2 = solution.repeatedNTimes(nums2)
print(f"Test 2: nums={nums2}")
print(f"Output: {result2}, Expected: 2\n")

# Test 3
nums3 = [5, 1, 5, 2, 5, 3, 5, 4]
result3 = solution.repeatedNTimes(nums3)
print(f"Test 3: nums={nums3}")
print(f"Output: {result3}, Expected: 5\n")
