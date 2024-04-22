#
# @lc app=leetcode id=950 lang=python3
#
# [950] Reveal Cards In Increasing Order
#

# @lc code=start
class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        deck.sort()
        res = [9] * len(deck)
        q = deque(range(len(deck)))
        
        for n in deck:
            i = q.popleft()
            res[i] = n
            if q:
                q.append(q.popleft())
        
        return res
        
# @lc code=end

