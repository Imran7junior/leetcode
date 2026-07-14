from functools import lru_cache
from math import gcd
from typing import List

class Solution:
    def subsequencePairCount(self, nums: List[int]) -> int:
        MOD = 10 ** 9 + 7
        n = len(nums)

        @lru_cache(None)
        def solve(idx, g1, g2):
            if idx == n:
                return 1 if g1 != 0 and g1 == g2 else 0

            # Ignore current element
            ans = solve(idx + 1, g1, g2)

            # Put in seq1
            ng1 = nums[idx] if g1 == 0 else gcd(g1, nums[idx])
            ans = (ans + solve(idx + 1, ng1, g2)) % MOD

            # Put in seq2
            ng2 = nums[idx] if g2 == 0 else gcd(g2, nums[idx])
            ans = (ans + solve(idx + 1, g1, ng2)) % MOD

            return ans

        return solve(0, 0, 0)


if __name__ == "__main__":
    sol = Solution()

    print(sol.subsequencePairCount([1, 2, 3, 4]))    # Expected: 10
    print(sol.subsequencePairCount([10, 20, 30]))    # Expected: 2
    print(sol.subsequencePairCount([1, 1, 1, 1]))    # Expected: 50