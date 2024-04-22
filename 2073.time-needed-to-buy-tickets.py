#
# @lc app=leetcode id=2073 lang=python3
#
# [2073] Time Needed to Buy Tickets
#

# @lc code=start
class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        total = 0 
        for i, x in enumerate(tickets):
            if i <= k:
                total += min(tickets[i], tickets[k])
            else:
                total += min(tickets[i], tickets[k] - 1)
        return total
# @lc code=end
