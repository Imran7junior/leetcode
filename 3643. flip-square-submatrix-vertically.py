class Solution:
    def reverseSubmatrix(self, grid: list[list[int]], x: int, y: int, k: int) -> list[list[int]]:
        sc, ec = y, y + k - 1
        sr = x
        for j in range(sc, ec + 1):
            for i in range(k // 2):
                grid[sr+i][j], grid[sr+k-i-1][j] = grid[sr+k-i-1][j], grid[sr+i][j]
        return grid

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    grid1 = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
    x1, y1, k1 = 1, 0, 3
    output1 = sol.reverseSubmatrix(grid1, x1, y1, k1)
    print(f"Example 1: grid (4x4), x={x1}, y={y1}, k={k1}")
    print(f"Output: {output1}")
    print(f"Expected: [[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]")
    print()
    
    # Example 2
    grid2 = [[3,4,2,3],[2,3,4,2]]
    x2, y2, k2 = 0, 2, 2
    output2 = sol.reverseSubmatrix(grid2, x2, y2, k2)
    print(f"Example 2: grid (2x4), x={x2}, y={y2}, k={k2}")
    print(f"Output: {output2}")
    print(f"Expected: [[3,4,4,2],[2,3,2,3]]")