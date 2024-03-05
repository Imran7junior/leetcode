#
# @lc app=leetcode id=1750 lang=python3
#
# [1750] Minimum Length of String After Deleting Similar Ends
#

# @lc code=start
class Solution:
	def minimumLength(self, s: str) -> int:
		l ,r = 0, len(s) - 1
		
		while l < r and s[l] == s[r]:
			tmp = s[l]
			while l <= r and s[l]	 == tmp:
				l += 1
			while l <= r and s[r]	 == tmp:
				r -= 1
		return (r - l + 1)
				 

# @lc code=end
