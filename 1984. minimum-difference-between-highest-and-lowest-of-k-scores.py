from typing import List


class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        nums.sort()
        ans , j = float('inf'), k - 1
        for i in range(len(nums) - j):
            ans = min(ans, nums[i + j] - nums[i])
        return ans


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    nums1 = [90]
    k1 = 1
    output1 = solution.minimumDifference(nums1, k1)
    print(f"Test 1: nums = {nums1}, k = {k1}")
    print(f"Output: {output1}, Expected: 0")
    
    # Test case 2
    nums2 = [9,4,1,7]
    k2 = 2
    output2 = solution.minimumDifference(nums2, k2)
    print(f"Test 2: nums = {nums2}, k = {k2}")
    print(f"Output: {output2}, Expected: 2")
    
    print("\nTest cases executed!")
