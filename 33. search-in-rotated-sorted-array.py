class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                return mid

            # left half is sorted
            if nums[low] <= nums[mid]:

                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1

            # right half is sorted
            else:

                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1 = [4,5,6,7,0,1,2]
    target1 = 0
    output1 = sol.search(nums1, target1)
    print(f"Example 1: nums={nums1}, target={target1}")
    print(f"Output: {output1}")
    print(f"Expected: 4")
    print()
    
    # Example 2
    nums2 = [4,5,6,7,0,1,2]
    target2 = 3
    output2 = sol.search(nums2, target2)
    print(f"Example 2: nums={nums2}, target={target2}")
    print(f"Output: {output2}")
    print(f"Expected: -1")
    print()
    
    # Example 3
    nums3 = [1]
    target3 = 0
    output3 = sol.search(nums3, target3)
    print(f"Example 3: nums={nums3}, target={target3}")
    print(f"Output: {output3}")
    print(f"Expected: -1")