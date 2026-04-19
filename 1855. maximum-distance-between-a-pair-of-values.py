from typing import List

class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        i, j = 0, 0
        ans = 0

        while i < len(nums1) and j < len(nums2):
            if nums1[i] <= nums2[j]:
                ans = max(ans, j - i)
                j += 1
            else:
                i += 1
                if i > j:
                    j = i

        return ans

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1_1 = [55,30,5,4,2]
    nums2_1 = [100,20,10,10,5]
    output1 = sol.maxDistance(nums1_1, nums2_1)
    print(f"Example 1: nums1={nums1_1}, nums2={nums2_1}")
    print(f"Output: {output1}")
    print(f"Expected: 2")
    print()
    
    # Example 2
    nums1_2 = [2,2,2]
    nums2_2 = [10,10,1]
    output2 = sol.maxDistance(nums1_2, nums2_2)
    print(f"Example 2: nums1={nums1_2}, nums2={nums2_2}")
    print(f"Output: {output2}")
    print(f"Expected: 1")
    print()
    
    # Example 3
    nums1_3 = [30,29,19,5]
    nums2_3 = [25,25,25,25,25]
    output3 = sol.maxDistance(nums1_3, nums2_3)
    print(f"Example 3: nums1={nums1_3}, nums2={nums2_3}")
    print(f"Output: {output3}")
    print(f"Expected: 2")