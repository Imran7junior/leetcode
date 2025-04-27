from typing import List
class Solution:
	def countSubarrays(self, nums: List[int]) -> int:
		n = len(nums)
		ans = 0
		for i in range(1, n-1):
			if nums[i] == (nums[i-1] + nums[i+1]) * 2:
				ans += 1
		return ans
	
sol = Solution()
nums = [1, 2, 1, 4, 1]  # <-- you can change this list
result = sol.countSubarrays(nums)
print("Result:", result)
