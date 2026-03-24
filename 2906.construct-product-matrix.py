class Solution:
    def constructProductMatrix(self, grid):
        MOD = 12345
        n, m = len(grid), len(grid[0])

        # Flatten grid
        arr = []
        for row in grid:
            for x in row:
                arr.append(x % MOD)

        N = len(arr)

        # Prefix and suffix arrays
        prefix = [1] * N
        suffix = [1] * N

        # Build prefix
        for i in range(1, N):
            prefix[i] = (prefix[i - 1] * arr[i - 1]) % MOD

        # Build suffix
        for i in range(N - 2, -1, -1):
            suffix[i] = (suffix[i + 1] * arr[i + 1]) % MOD

        # Build result
        res = [[0] * m for _ in range(n)]
        idx = 0

        for i in range(n):
            for j in range(m):
                res[i][j] = (prefix[idx] * suffix[idx]) % MOD
                idx += 1

        return res

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    grid1 = [[1,2],[3,4]]
    output1 = sol.constructProductMatrix(grid1)
    print(f"Example 1: grid={grid1}")
    print(f"Output: {output1}")
    print(f"Expected: [[24,12],[8,6]]")
    print()
    
    # Example 2
    grid2 = [[12345],[2],[1]]
    output2 = sol.constructProductMatrix(grid2)
    print(f"Example 2: grid={grid2}")
    print(f"Output: {output2}")
    print(f"Expected: [[2],[0],[0]]")