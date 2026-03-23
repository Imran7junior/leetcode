class Solution:
    def maxProductPath(self, grid):
        m, n = len(grid), len(grid[0])
        MOD = 10**9 + 7

        mx = [[0] * n for _ in range(m)]
        mn = [[0] * n for _ in range(m)]

        mx[0][0] = mn[0][0] = grid[0][0]

        # first row
        for j in range(1, n):
            mx[0][j] = mn[0][j] = mx[0][j - 1] * grid[0][j]

        # first column
        for i in range(1, m):
            mx[i][0] = mn[i][0] = mx[i - 1][0] * grid[i][0]

        for i in range(1, m):
            for j in range(1, n):
                x = grid[i][j]

                a = mx[i - 1][j] * x
                b = mn[i - 1][j] * x
                c = mx[i][j - 1] * x
                d = mn[i][j - 1] * x

                mx[i][j] = max(a, b, c, d)
                mn[i][j] = min(a, b, c, d)

        ans = mx[m - 1][n - 1]
        return -1 if ans < 0 else ans % MOD

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    grid1 = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
    output1 = sol.maxProductPath(grid1)
    print(f"Example 1: grid={grid1}")
    print(f"Output: {output1}")
    print(f"Expected: -1")
    print()
    
    # Example 2
    grid2 = [[1,-2,1],[1,-2,1],[3,-4,1]]
    output2 = sol.maxProductPath(grid2)
    print(f"Example 2: grid={grid2}")
    print(f"Output: {output2}")
    print(f"Expected: 8")
    print()
    
    # Example 3
    grid3 = [[1,3],[0,-4]]
    output3 = sol.maxProductPath(grid3)
    print(f"Example 3: grid={grid3}")
    print(f"Output: {output3}")
    print(f"Expected: 0")