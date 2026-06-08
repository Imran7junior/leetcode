class Solution:
    def pivotArray(self, nums, pivot):
        lCount, pCount = 0, 0
        for num in nums:
            if num < pivot:
                lCount += 1
            elif num == pivot:
                pCount += 1

        res = [0] * len(nums)
        left, mid, right = 0, lCount, lCount + pCount

        for num in nums:
            if num < pivot:
                res[left] = num
                left += 1
            elif num > pivot:
                res[right] = num
                right += 1
            else:
                res[mid] = num
                mid += 1

        return res

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1 = [9,12,5,10,14,3,10]
    pivot1 = 10
    output1 = sol.pivotArray(nums1, pivot1)
    print(f"Example 1: nums={nums1}, pivot={pivot1}")
    print(f"Output: {output1}")
    print(f"Expected: [9,5,3,10,10,12,14]")
    print()
    
    # Example 2
    nums2 = [-3,4,3,2]
    pivot2 = 2
    output2 = sol.pivotArray(nums2, pivot2)
    print(f"Example 2: nums={nums2}, pivot={pivot2}")
    print(f"Output: {output2}")
    print(f"Expected: [-3,2,4,3]")