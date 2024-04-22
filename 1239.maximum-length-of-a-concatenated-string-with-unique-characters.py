#
# @lc app=leetcode id=1239 lang=python3
#
# [1239] Maximum Length of a Concatenated String with Unique Characters
#

# @lc code=start


class Solution:
    def maxLength(self, arr: List[str]) -> int:
        charSet = set()
        def overlap(charSet, s):
            c = Counter(charSet) + Counter(s)
            return max(c.values()) > 1
        #   prev = set()
        #   for c in s:
        #   if c in charSet or c in prev:
        #       return True
        #       prev.add(c)
        #   return False     
        def backtrack(i):
            if i == len(arr):
                return len(charSet)
            res = 0
            if not overlap(charSet, arr[i]):
                for c in arr[i]:
                    charSet.add(c)
                res = backtrack(i +1)
                for c in arr[i]:
                    charSet.remove(c)
            return max(res, backtrack(i + 1))

        return backtrack(0)
					
		
# @lc code=end

