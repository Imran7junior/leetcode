from typing import List


class Solution:
    def isTrionic(self, nums: List[int]) -> bool:
        n=len(nums)
        if nums[0]>=nums[1] or n<4: return False
        q, t, i=0, 0, 2
        while i<n:
            while i<n and nums[i-1]<nums[i]: i+=1
            if i<n and nums[i-1]==nums[i]: return False

            while i<n and nums[i-1]>nums[i]: i+=1
            if i<n and nums[i-1]==nums[i]: return False

            q=i
            if not(1<q<n): return False
            while i<n and nums[i-1]<nums[i]: i+=1
            t=i
            if t<n: return False
            i+=1
        return True


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    nums1 = [1,3,5,4,2,6]
    output1 = solution.isTrionic(nums1)
    print(f"Test 1: nums = {nums1}")
    print(f"Output: {output1}, Expected: true")
    
    # Test case 2
    nums2 = [2,1,3]
    output2 = solution.isTrionic(nums2)
    print(f"Test 2: nums = {nums2}")
    print(f"Output: {output2}, Expected: false")
    
    print("\nTest cases executed!")
