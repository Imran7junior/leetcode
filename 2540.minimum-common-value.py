#
# @lc app=leetcode id=2540 lang=python3
#
# [2540] Minimum Common Value
#

# @lc code=start
class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        i = 0
        j = 0
        common = float('inf')

        while i < len(nums1) and j < len(nums2):
            if nums1[i] == nums2[j]:
        
# @lc code=end

