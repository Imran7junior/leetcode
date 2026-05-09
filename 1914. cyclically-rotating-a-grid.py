class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:

        m = len(grid)
        n = len(grid[0])

        layers = min(m, n) // 2

        for layer in range(layers):

            nums = []

            top = layer
            bottom = m - layer - 1
            left = layer
            right = n - layer - 1

            for j in range(left, right + 1):
                nums.append(grid[top][j])

            for i in range(top + 1, bottom):
                nums.append(grid[i][right])

            for j in range(right, left - 1, -1):
                nums.append(grid[bottom][j])

            for i in range(bottom - 1, top, -1):
                nums.append(grid[i][left])

            length = len(nums)

            rotate = k % length

            rotated = nums[rotate:] + nums[:rotate]

            idx = 0

            for j in range(left, right + 1):
                grid[top][j] = rotated[idx]
                idx += 1

            for i in range(top + 1, bottom):
                grid[i][right] = rotated[idx]
                idx += 1

            for j in range(right, left - 1, -1):
                grid[bottom][j] = rotated[idx]
                idx += 1

            for i in range(bottom - 1, top, -1):
                grid[i][left] = rotated[idx]
                idx += 1

        return grid


# Test cases
if __name__ == "__main__":
    from typing import List
    from copy import deepcopy
    
    solution = Solution()
    
    # Example 1
    grid1 = [[40,10],[30,20]]
    grid1_copy = deepcopy(grid1)
    result1 = solution.rotateGrid(grid1_copy, 1)
    print(f"Example 1: Input: grid = {grid1}, k = 1")
    print(f"Output: {result1}")
    print(f"Expected: [[10,20],[40,30]]\n")
    
    # Example 2
    grid2 = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
    grid2_copy = deepcopy(grid2)
    result2 = solution.rotateGrid(grid2_copy, 2)
    print(f"Example 2: Input: grid = {grid2}, k = 2")
    print(f"Output: {result2}")
    print(f"Expected: [[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]")