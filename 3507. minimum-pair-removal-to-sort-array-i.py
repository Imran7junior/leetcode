from typing import List


class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        def isSorted(nums, n) -> bool:
            for i in range(1,n):
                if nums[i] < nums[i - 1]: return False
            return True
        ans, n = 0, len(nums)
        while not isSorted(nums, n):
            ans += 1
            min_sum, pos = float('inf'), -1
            for i in range(1,n):
                sum = nums[i - 1] + nums[i]
                if sum < min_sum:
                    min_sum = sum
                    pos = i
            nums[pos - 1] = min_sum
            for i in range(pos, n-1): nums[i] = nums[i + 1]
            n -= 1
        return ans


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    nums1 = [5,2,3,1]
    output1 = solution.minimumPairRemoval(nums1)
    print(f"Test 1: nums = [5,2,3,1]")
    print(f"Output: {output1}, Expected: 2")
    
    # Test case 2
    nums2 = [1,2,2]
    output2 = solution.minimumPairRemoval(nums2)
    print(f"Test 2: nums = [1,2,2]")
    print(f"Output: {output2}, Expected: 0")
    
    print("\nTest cases executed!")
 