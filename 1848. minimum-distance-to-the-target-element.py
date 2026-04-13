class Solution:
    def getMinDistance(self, nums: list[int], target: int, start: int) -> int:

        result = len(nums)

        for i in range(len(nums)):
            if nums[i] == target:
                result = min(result, abs(i - start))

        return result

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1 = [1,2,3,4,5]
    target1 = 5
    start1 = 3
    output1 = sol.getMinDistance(nums1, target1, start1)
    print(f"Example 1: nums={nums1}, target={target1}, start={start1}")
    print(f"Output: {output1}")
    print(f"Expected: 1")
    print()
    
    # Example 2
    nums2 = [1]
    target2 = 1
    start2 = 0
    output2 = sol.getMinDistance(nums2, target2, start2)
    print(f"Example 2: nums={nums2}, target={target2}, start={start2}")
    print(f"Output: {output2}")
    print(f"Expected: 0")
    print()
    
    # Example 3
    nums3 = [1,1,1,1,1,1,1,1,1,1]
    target3 = 1
    start3 = 0
    output3 = sol.getMinDistance(nums3, target3, start3)
    print(f"Example 3: nums={nums3}, target={target3}, start={start3}")
    print(f"Output: {output3}")
    print(f"Expected: 0")