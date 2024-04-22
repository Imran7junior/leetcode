#
# @lc app=leetcode id=268 lang=python3
#
# [268] Missing Number
#

# @lc code=start
class Solution:
	def missingNumber(self, nums: List[int]) -> int:
		"""res = len(nums) 
		#using sum and subracting each num from the range of natural sequence 
		for i in range(len(nums)):
			res += (i - nums[i])
		return res		"""
		#xor method different binary gives 1 and same 0. n^n = 0
		n = len(nums)
		ans = 0
		for i in range(1, n + 1):
			ans ^= i
		for num in nums:
			ans ^= num
		return ans
# @lc code=end

