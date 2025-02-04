class Solution:
    def maxAscendingSum(self, nums):
        max_sum = cur_sum = nums[0]  
        
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                cur_sum += nums[i]  
            else:
                max_sum = max(max_sum, cur_sum)
                cur_sum = nums[i]  
        
        return max(max_sum, cur_sum)  