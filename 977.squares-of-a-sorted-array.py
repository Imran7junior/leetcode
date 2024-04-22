#
# @lc app=leetcode id=977 lang=python3
#
# [977] Squares of a Sorted Array
#

# @lc code=start
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        squares = [x * x for x in nums]
        squares.sort()                  
        return squares
# @lc code=end

