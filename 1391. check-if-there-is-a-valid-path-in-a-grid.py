class Solution:
    def hasValidPath(self, grid: List[List[int]]) -> bool:
        dirs = {
            1: {0, 1},
            2: {2, 3},
            3: {0, 3},
            4: {1, 3},
            5: {0, 2},
            6: {1, 2}, 
        }
        moves = [
            (0, -1, 0, 1),
            (0, 1, 1, 0),
            (-1, 0, 2, 3),
            (1, 0, 3, 2),
        ]
        rows = len(grid)
        cols = len(grid[0])
        visited = [[False] * cols for _ in range(rows)]
        visited[0][0] = True
        queue = deque([(0, 0)])
 
        while queue:
            row, col = queue.popleft()
            if row == rows - 1 and col == cols - 1:
                return True
            for dr, dc, dx, dy in moves:
                nr = row + dr
                nc = col + dc
                if (0 <= nr < rows and 0 <= nc < cols
                        and not visited[nr][nc]
                        and dx in dirs[grid[row][col]]
                        and dy in dirs[grid[nr][nc]]):
                    visited[nr][nc] = True
                    queue.append((nr, nc))
        return False


# Test cases
if __name__ == "__main__":
    from collections import deque
    from typing import List
    
    solution = Solution()
    
    # Example 1
    grid1 = [[2,4,3],[6,5,2]]
    result1 = solution.hasValidPath(grid1)
    print(f"Example 1: Input: grid = {grid1}")
    print(f"Output: {result1}")
    print(f"Expected: True\n")
    
    # Example 2
    grid2 = [[1,2,1],[1,2,1]]
    result2 = solution.hasValidPath(grid2)
    print(f"Example 2: Input: grid = {grid2}")
    print(f"Output: {result2}")
    print(f"Expected: False\n")
    
    # Example 3
    grid3 = [[1,1,2]]
    result3 = solution.hasValidPath(grid3)
    print(f"Example 3: Input: grid = {grid3}")
    print(f"Output: {result3}")
    print(f"Expected: False")