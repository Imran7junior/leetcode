class Solution:
    def countSubmatrices(self, grid: list[list[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])
        ans = 0
        px = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(m):
                if px[i+1][j+1] <= k:
                    ans += 1
        return ans

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    grid = [[7,6,3],[6,6,1]]
    k = 18
    output = sol.countSubmatrices(grid, k)
    print(f"Example 1: Input: grid = {grid}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: 4")
    print()
    
    # Example 2:
    grid = [[7,2,9],[1,5,0],[2,6,6]]
    k = 20
    output = sol.countSubmatrices(grid, k)
    print(f"Example 2: Input: grid = {grid}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: 6")

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    grid = [[7,6,3],[6,6,1]]
    k = 18
    output = sol.countSubmatrices(grid, k)
    print(f"Example 1: Input: grid = {grid}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: 4")
    print()
    
    # Example 2:
    grid = [[7,2,9],[1,5,0],[2,6,6]]
    k = 20
    output = sol.countSubmatrices(grid, k)
    print(f"Example 2: Input: grid = {grid}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: 6")
