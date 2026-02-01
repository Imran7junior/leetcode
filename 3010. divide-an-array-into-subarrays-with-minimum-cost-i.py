from typing import List


# Added using AI
class Solution:
    def minimumCost(self, nums: List[int]) -> int:
        ans = nums[0]
        nums[1:] = sorted(nums[1:])
        ans += nums[1]
        ans += nums[2]
        return ans


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    nums1 = [1,2,3,12]
    output1 = solution.minimumCost(nums1)
    print(f"Test 1: nums = [1,2,3,12]")
    print(f"Output: {output1}, Expected: 6")
    
    # Test case 2
    nums2 = [5,4,3]
    output2 = solution.minimumCost(nums2)
    print(f"Test 2: nums = [5,4,3]")
    print(f"Output: {output2}, Expected: 12")
    
    # Test case 3
    nums3 = [10,3,1,1]
    output3 = solution.minimumCost(nums3)
    print(f"Test 3: nums = [10,3,1,1]")
    print(f"Output: {output3}, Expected: 12")
    
    print("\nTest cases executed!")
