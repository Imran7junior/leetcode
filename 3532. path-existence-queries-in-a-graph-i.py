from typing import List


class Solution:
    def pathExistenceQueries(
        self, n: int, nums: List[int], maxDiff: int, queries: List[List[int]]
    ) -> List[bool]:
        component = [0] * n

        val = 0

        for i in range(1, n):
            if nums[i] - nums[i - 1] > maxDiff:
                val += 1
            component[i] = val

        ans = []

        for u, v in queries:
            ans.append(component[u] == component[v])

        return ans


if __name__ == "__main__":
    sol = Solution()

    # Example 1
    n = 2
    nums = [1, 3]
    maxDiff = 1
    queries = [[0, 0], [0, 1]]
    print(sol.pathExistenceQueries(n, nums, maxDiff, queries))
    # [True, False]

    # Example 2
    n = 4
    nums = [2, 5, 6, 8]
    maxDiff = 2
    queries = [[0, 1], [0, 2], [1, 3], [2, 3]]
    print(sol.pathExistenceQueries(n, nums, maxDiff, queries))
    # [False, False, True, True]