class Solution(object):
    def reverse(self, x):
        rev = 0
        while x > 0:
            rev = rev * 10 + x % 10
            x //= 10
        return rev

    def minMirrorPairDistance(self, nums):
        mpp = {}
        n = len(nums)
        ans = 10 ** 6

        for i in range(n):
            if nums[i] in mpp:
                ans = min(ans, i - mpp[nums[i]])
            mpp[self.reverse(nums[i])] = i

        return -1 if ans == 10 ** 6 else ans


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Example 1
    nums1 = [12, 21, 45, 33, 54]
    result1 = solution.minMirrorPairDistance(nums1)
    print(f"Example 1: Input: nums = {nums1}")
    print(f"Output: {result1}")
    print(f"Expected: 1\n")
    
    # Example 2
    nums2 = [120, 21]
    result2 = solution.minMirrorPairDistance(nums2)
    print(f"Example 2: Input: nums = {nums2}")
    print(f"Output: {result2}")
    print(f"Expected: 1")