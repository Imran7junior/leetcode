from typing import List
from collections import defaultdict

class Solution:
    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        mp = defaultdict(list)
        for a in allowed:
            mp[a[:2]].append(a[2])

        memo = {}

        def dfs(row: str) -> bool:
            if len(row) == 1:
                return True
            if row in memo:
                return memo[row]

            def build(i: int, path: str) -> bool:
                if i == len(row) - 1:
                    return dfs(path)
                pair = row[i:i+2]
                if pair not in mp:
                    return False
                for ch in mp[pair]:
                    if build(i + 1, path + ch):
                        return True
                return False

            memo[row] = build(0, "")
            return memo[row]

        return dfs(bottom)


# Test case
solution = Solution()

bottom1 = "BCD"
allowed1 = ["BCC", "CDE", "CEA", "FFF"]
result1 = solution.pyramidTransition(bottom1, allowed1)
print(f"Test 1: bottom='{bottom1}', allowed={allowed1}")
print(f"Output: {result1}, Expected: True\n")
