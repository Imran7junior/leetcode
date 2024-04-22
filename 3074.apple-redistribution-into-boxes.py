#
# @lc app=leetcode id=3074 lang=python3
#
# [3074] Apple Redistribution into Boxes
#

# @lc code=start
class Solution:
    def minimumBoxes(self, apple: List[int], capacity: List[int]) -> int:
        s = 0
        count = 0
        for v in apple:
            s = s + v
        capacity.sort()
        i = len(capacity) - 1
        while(i >= 0):
            s =  s - capacity[i]
            count += 1
            if s<= 0:
                break
            i -= 1
        return count
# @lc code=end

