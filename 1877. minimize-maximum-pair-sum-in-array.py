from typing import List


class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        min_val, max_val = float('inf'), float('-inf')
        freq = [0] * 100001
        for i in range (len(nums)):
            if nums[i] < min_val: min_val = nums[i]
            if nums[i] > max_val: max_val = nums[i]
            freq[nums[i]] += 1
        max_sum, l, r = 0, min_val, max_val
        while l <= r:
            if freq[l] == 0: l += 1
            elif freq[r] == 0: r -= 1
            else:
                max_sum = max(max_sum, l + r)
                freq[l] -= 1
                freq[r] -= 1
        return max_sum


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    nums1 = [3,5,2,3]
    output1 = solution.minPairSum(nums1)
    print(f"Test 1: nums = {nums1}")
    print(f"Output: {output1}, Expected: 7")
    
    # Test case 2
    nums2 = [3,5,4,2,4,6]
    output2 = solution.minPairSum(nums2)
    print(f"Test 2: nums = {nums2}")
    print(f"Output: {output2}, Expected: 8")
    
    print("\nTest cases executed!")
