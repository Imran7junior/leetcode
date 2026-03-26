from collections import defaultdict

class Solution:
    def canPartitionGrid(self, grid):
        m, n = len(grid), len(grid[0])

        total = 0
        bottom = defaultdict(int)
        top = defaultdict(int)
        left = defaultdict(int)
        right = defaultdict(int)

        # Initialize bottom and right maps
        for row in grid:
            for x in row:
                total += x
                bottom[x] += 1
                right[x] += 1

        sumTop = 0

        # 🔹 Horizontal cuts
        for i in range(m - 1):
            for j in range(n):
                val = grid[i][j]
                sumTop += val

                top[val] += 1
                bottom[val] -= 1

            sumBottom = total - sumTop

            if sumTop == sumBottom:
                return True

            diff = abs(sumTop - sumBottom)

            if sumTop > sumBottom:
                if self.check(top, grid, 0, i, 0, n - 1, diff):
                    return True
            else:
                if self.check(bottom, grid, i + 1, m - 1, 0, n - 1, diff):
                    return True

        sumLeft = 0

        # 🔹 Vertical cuts
        for j in range(n - 1):
            for i in range(m):
                val = grid[i][j]
                sumLeft += val

                left[val] += 1
                right[val] -= 1

            sumRight = total - sumLeft

            if sumLeft == sumRight:
                return True

            diff = abs(sumLeft - sumRight)

            if sumLeft > sumRight:
                if self.check(left, grid, 0, m - 1, 0, j, diff):
                    return True
            else:
                if self.check(right, grid, 0, m - 1, j + 1, n - 1, diff):
                    return True

        return False

    def check(self, mp, grid, r1, r2, c1, c2, diff):
        rows = r2 - r1 + 1
        cols = c2 - c1 + 1

        # single cell
        if rows * cols == 1:
            return False

        # 1D row
        if rows == 1:
            return grid[r1][c1] == diff or grid[r1][c2] == diff

        # 1D column
        if cols == 1:
            return grid[r1][c1] == diff or grid[r2][c1] == diff

        return mp.get(diff, 0) > 0

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    grid1 = [[1,4],[2,3]]
    output1 = sol.canPartitionGrid(grid1)
    print(f"Example 1: grid=[[1,4],[2,3]]")
    print(f"Output: {output1}")
    print(f"Expected: True")
    print()
    
    # Example 2
    grid2 = [[1,2],[3,4]]
    output2 = sol.canPartitionGrid(grid2)
    print(f"Example 2: grid=[[1,2],[3,4]]")
    print(f"Output: {output2}")
    print(f"Expected: True")
    print()
    
    # Example 3
    grid3 = [[1,2,4],[2,3,5]]
    output3 = sol.canPartitionGrid(grid3)
    print(f"Example 3: grid=[[1,2,4],[2,3,5]]")
    print(f"Output: {output3}")
    print(f"Expected: False")
    print()
    
    # Example 4
    grid4 = [[4,1,8],[3,2,6]]
    output4 = sol.canPartitionGrid(grid4)
    print(f"Example 4: grid=[[4,1,8],[3,2,6]]")
    print(f"Output: {output4}")
    print(f"Expected: False")