from typing import List

class Solution:
    def maxPathScore(self, grid: List[List[int]], k: int) -> int:
        m = len(grid)
        n = len(grid[0])
        NEG = -10**9

        prev = [[NEG] * (k + 1) for _ in range(n)]

        for i in range(m):
            curr = [[NEG] * (k + 1) for _ in range(n)]

            for j in range(n):
                gain = grid[i][j]
                need = 1 if gain > 0 else 0

                limit = min(k, i + j)

                if i == 0 and j == 0:
                    curr[0][0] = 0
                    continue

                for c in range(need, limit + 1):
                    best = NEG

                    if i > 0 and prev[j][c - need] != NEG:
                        best = max(best, prev[j][c - need] + gain)

                    if j > 0 and curr[j - 1][c - need] != NEG:
                        best = max(best, curr[j - 1][c - need] + gain)

                    curr[j][c] = best

            prev = curr

        ans = max(prev[n - 1])
        return -1 if ans < 0 else ans


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Example 1
    grid1 = [[0, 1],[2, 0]]
    k1 = 1
    result1 = solution.maxPathScore(grid1, k1)
    print(f"Example 1: Input: grid = {grid1}, k = {k1}")
    print(f"Output: {result1}")
    print(f"Expected: 2\n")
    
    # Example 2
    grid2 = [[0, 1],[1, 2]]
    k2 = 1
    result2 = solution.maxPathScore(grid2, k2)
    print(f"Example 2: Input: grid = {grid2}, k = {k2}")
    print(f"Output: {result2}")
    print(f"Expected: -1")