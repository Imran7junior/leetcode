#
# @lc app=leetcode id=2864 lang=python3
#
# [2864] Maximum Odd Binary Number
#

# @lc code=start
class Solution:
	def maximumOddBinaryNumber(self, s: str) -> str:
		#count = 0 #count num of ones
		#for c in s:
		#    if c == "1":
		#        count += 1
		#return (count - 1) * "1" + (len(s) - count) * "0" + "1"
		s = [c for c in s]
		left = 0
		
		for i in range(len(s)):
			if s[i] == "1":
				s[i], s[left] = s[left], s[i]
				left += 1
		s[left - 1], s[len(s) - 1] = s[len(s) - 1], s[left - 1]
		return "".join(s)
		 
# @lc code=end

