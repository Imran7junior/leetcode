from typing import List


class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        res = []
        for n in nums:
            if n & 1:
                res.append(n & ~(((n + 1) & ~n) >> 1))
            else:
                res.append(-1)
        return res


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    nums1 = [2,3,5,7]
    output1 = solution.minBitwiseArray(nums1)
    print(f"Test 1: nums = {nums1}")
    print(f"Output: {output1}, Expected: [-1,1,4,3]")
    
    # Test case 2
    nums2 = [11,13,31]
    output2 = solution.minBitwiseArray(nums2)
    print(f"Test 2: nums = {nums2}")
    print(f"Output: {output2}, Expected: [9,12,15]")
    
    print("\nTest cases executed!")
