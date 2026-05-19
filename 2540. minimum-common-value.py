class Solution:
    def getCommon(self, nums1, nums2):
        i, j = 0, 0
        while i < len(nums1) and j < len(nums2):
            if nums1[i] == nums2[j]:
                return nums1[i]

            if nums1[i] < nums2[j]:
                i += 1
            else:
                j += 1
        return -1

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1_1 = [1,2,3]
    nums2_1 = [2,4]
    output1 = sol.getCommon(nums1_1, nums2_1)
    print(f"Example 1: nums1={nums1_1}, nums2={nums2_1}")
    print(f"Output: {output1}")
    print(f"Expected: 2")
    print()
    
    # Example 2
    nums1_2 = [1,2,3,6]
    nums2_2 = [2,3,4,5]
    output2 = sol.getCommon(nums1_2, nums2_2)
    print(f"Example 2: nums1={nums1_2}, nums2={nums2_2}")
    print(f"Output: {output2}")
    print(f"Expected: 2")