from typing import List
from bisect import insort, bisect_left

class Solution:
    def minAbsDiff(self, grid: List[List[int]], k: int) -> List[List[int]]:
        rows = len(grid)
        cols = len(grid[0])
        res = [[0] * (cols - k + 1) for _ in range(rows - k + 1)]
        def diff(window):
            if len(window) < 2:
                return 0
            min_diff = float('inf')
            for i in range(len(window) - 1):
                diff = window[i + 1] - window[i]
                if diff > 0 and diff < min_diff:
                    min_diff = diff
            return min_diff if min_diff != float('inf') else 0
        for r in range(rows - k + 1):
            cur = []
            for i in range(k):
                for j in range(k):
                    insort(cur, grid[r+i][j])
            res[r][0] = diff(cur)
            for c in range(1, cols - k + 1):
                for i in range(k):
                    remove = grid[r+i][c-1]
                    index = bisect_left(cur, remove)
                    cur.pop(index)
                for i in range(k):
                    add = grid[r+i][c+k-1]
                    insort(cur, add)
                res[r][c] = diff(cur)
        return res

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    grid1 = [[1,8],[3,-2]]
    k1 = 2
    output1 = sol.minAbsDiff(grid1, k1)
    print(f"Example 1: grid={grid1}, k={k1}")
    print(f"Output: {output1}")
    print(f"Expected: [[2]]")
    print()
    
    # Example 2
    grid2 = [[3,-1]]
    k2 = 1
    output2 = sol.minAbsDiff(grid2, k2)
    print(f"Example 2: grid={grid2}, k={k2}")
    print(f"Output: {output2}")
    print(f"Expected: [[0,0]]")
    print()
    
    # Example 3
    grid3 = [[1,-2,3],[2,3,5]]
    k3 = 2
    output3 = sol.minAbsDiff(grid3, k3)
    print(f"Example 3: grid={grid3}, k={k3}")
    print(f"Output: {output3}")
    print(f"Expected: [[1,2]]")
            