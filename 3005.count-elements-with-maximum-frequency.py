#
# @lc app=leetcode id=3005 lang=python3
#
# [3005] Count Elements With Maximum Frequency
#

# @lc code=start
class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        f_counter = Counter(nums)

        max_f = max(f_counter.values())
        max_f_elements = [nums for num, freq in f_counter.items() if freq == max_f]
        total_frequency = max_f * len(max_f_elements)

        return total_frequency
        
# @lc code=end

