class Solution(object):
    def minSum(self, nums1, nums2):
        z1 = sum(1 for x in nums1 if x == 0)
        z2 = sum(1 for x in nums2 if x == 0)
        s1 = z1 + sum(nums1)
        s2 = z2 + sum(nums2)
        if (s1 < s2 and z1 == 0) or (s2 < s1 and z2 == 0):
            return -1
        return max(s1, s2)