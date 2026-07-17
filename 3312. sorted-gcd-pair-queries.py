from bisect import bisect_left
from typing import List


class Solution:
    def gcdValues(self, nums: List[int], queries: List[int]) -> List[int]:
        maxVal = max(nums)

        # frequency of each number
        freq = [0] * (maxVal + 1)
        for x in nums:
            freq[x] += 1

        # divCnt[g] = how many numbers are divisible by g
        divCnt = [0] * (maxVal + 1)

        for g in range(1, maxVal + 1):
            for x in range(g, maxVal + 1, g):
                divCnt[g] += freq[x]

        # exact[g] = number of pairs whose gcd is exactly g
        exact = [0] * (maxVal + 1)

        for g in range(maxVal, 0, -1):

            # choose any two numbers divisible by g
            exact[g] = divCnt[g] * (divCnt[g] - 1) // 2

            # remove pairs whose gcd is a larger multiple of g
            for m in range(2 * g, maxVal + 1, g):
                exact[g] -= exact[m]

        # prefix[g] = number of pairs with gcd <= g
        prefix = [0] * (maxVal + 1)

        for g in range(1, maxVal + 1):
            prefix[g] = prefix[g - 1] + exact[g]

        ans = []

        for q in queries:
            g = bisect_left(prefix, q + 1, 1)
            ans.append(g)

        return ans


if __name__ == "__main__":
    sol = Solution()

    # Example 1
    nums = [2, 3, 4]
    queries = [0, 2, 2]
    print(sol.gcdValues(nums, queries))  # [1, 2, 2]

    # Example 2
    nums = [4, 4, 2, 1]
    queries = [5, 3, 1, 0]
    print(sol.gcdValues(nums, queries))  # [4, 2, 1, 1]

    # Example 3
    nums = [2, 2]
    queries = [0, 0]
    print(sol.gcdValues(nums, queries))  # [2, 2]