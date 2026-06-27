from collections import Counter
from math import isqrt

class Solution:
    def maximumLength(self, nums: list[int]) -> int:
        freq = Counter(nums)
        res = (freq.pop(1, 0) - 1) | 1

        for f in freq:
            x = f
            sq = isqrt(x)
            if sq * sq == x and freq.get(sq, 0) > 1:
                continue

            n = 0
            while x < 31623 and freq.get(x, 0) > 1:
                n += 2
                x *= x

            res = max(res, n + ((x in freq) << 1) - 1)

        return res


if __name__ == "__main__":
    sol = Solution()

    print(sol.maximumLength([5, 4, 1, 2, 2]))  # Expected: 3
    print(sol.maximumLength([1, 3, 2, 4]))     # Expected: 1