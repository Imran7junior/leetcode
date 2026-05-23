class Solution:
    def check(self, nums: List[int]) -> bool:
        count, n = 0, len(nums)
        for i in range(n):
            if nums[i] > nums[(i+1) % n]:
                count += 1
                if count > 1: return False
        return True

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1 = [3,4,5,1,2]
    output1 = sol.check(nums1)
    print(f"Example 1: nums={nums1}")
    print(f"Output: {output1}")
    print(f"Expected: True")
    print()
    
    # Example 2
    nums2 = [2,1,3,4]
    output2 = sol.check(nums2)
    print(f"Example 2: nums={nums2}")
    print(f"Output: {output2}")
    print(f"Expected: False")
    print()
    
    # Example 3
    nums3 = [1,2,3]
    output3 = sol.check(nums3)
    print(f"Example 3: nums={nums3}")
    print(f"Output: {output3}")
    print(f"Expected: True")