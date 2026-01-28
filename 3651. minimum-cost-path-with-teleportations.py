from typing import List
import math
from itertools import product


class Solution:
    def minCost(self, grid: List[List[int]], k: int) -> int:
        rows, cols = len(grid), len(grid[0])
        maxval = max(max(row) for row in grid)

        def dp_iteration(dp: list[list[int]], best_teleport: list[int]) -> list[list[int]]:
            for r in reversed(range(rows)):
                for c in reversed(range(cols)):
                    walk = math.inf if (r, c) != (rows - 1, cols - 1) else 0
                    if r + 1 < rows: walk = min(walk, dp[r + 1][c] + grid[r + 1][c])  # down
                    if c + 1 < cols: walk = min(walk, dp[r][c + 1] + grid[r][c + 1])  # right
                    dp[r][c] = min(walk, best_teleport[grid[r][c]])  # walk or teleport
            return dp

        def build_teleport(dp: list[list[int]]) -> list[int]:
            teleport = [math.inf] * (maxval + 1)

            # First build mincost for each v = value
            for r, c in product(range(rows), range(cols)):
                teleport[grid[r][c]] = min(teleport[grid[r][c]], dp[r][c])

            # Then build prefix mincost for v <= value
            for v in range(maxval + 1):
                teleport[v] = min(teleport[v], teleport[v - 1] if v > 0 else math.inf)

            return teleport

        best_teleport = [math.inf] * (maxval + 1)
        dp = [[math.inf] * cols for _ in range(rows)]
        dp[-1][-1] = 0  # zero cost to reach (m - 1, n - 1) from (m - 1, n - 1)

        for t in range(k + 1):  # t teleports allowed
            dp = dp_iteration(dp, best_teleport)
            best_teleport = build_teleport(dp)

        return dp[0][0]


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    grid1 = [[1,3,3],[2,5,4],[4,3,5]]
    k1 = 2
    output1 = solution.minCost(grid1, k1)
    print(f"Test 1: grid = {grid1}, k = {k1}")
    print(f"Output: {output1}, Expected: 7")
    
    # Test case 2
    grid2 = [[1,2],[2,3],[3,4]]
    k2 = 1
    output2 = solution.minCost(grid2, k2)
    print(f"Test 2: grid = {grid2}, k = {k2}")
    print(f"Output: {output2}, Expected: 9")
    
    print("\nTest cases executed!")
