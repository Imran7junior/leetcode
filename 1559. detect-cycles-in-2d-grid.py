from typing import List

class Solution:
    def containsCycle(self, grid: List[List[str]]) -> bool:
        m, n = len(grid), len(grid[0])
        visited = [[False] * n for _ in range(m)]

        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        for r in range(m):
            for c in range(n):
                if visited[r][c]:
                    continue

                # stack item: (row, col, parent_row, parent_col)
                stack = [(r, c, -1, -1)]
                visited[r][c] = True

                while stack:
                    cr, cc, pr, pc = stack.pop()

                    for dr, dc in dirs:
                        nr, nc = cr + dr, cc + dc

                        if nr < 0 or nr >= m or nc < 0 or nc >= n:
                            continue
                        if grid[nr][nc] != grid[cr][cc]:
                            continue
                        if nr == pr and nc == pc:
                            continue

                        if visited[nr][nc]:
                            return True

                        visited[nr][nc] = True
                        stack.append((nr, nc, cr, cc))

        return False


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Example 1
    grid1 = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
    result1 = solution.containsCycle(grid1)
    print("Example 1: Input: grid = [[\"a\",\"a\",\"a\",\"a\"],[\"a\",\"b\",\"b\",\"a\"],[\"a\",\"b\",\"b\",\"a\"],[\"a\",\"a\",\"a\",\"a\"]]")
    print(f"Output: {result1}")
    print(f"Expected: True\n")
    
    # Example 2
    grid2 = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
    result2 = solution.containsCycle(grid2)
    print("Example 2: Input: grid = [[\"c\",\"c\",\"c\",\"a\"],[\"c\",\"d\",\"c\",\"c\"],[\"c\",\"c\",\"e\",\"c\"],[\"f\",\"c\",\"c\",\"c\"]]")
    print(f"Output: {result2}")
    print(f"Expected: True\n")
    
    # Example 3
    grid3 = [["a","b","b"],["b","z","b"],["b","b","a"]]
    result3 = solution.containsCycle(grid3)
    print("Example 3: Input: grid = [[\"a\",\"b\",\"b\"],[\"b\",\"z\",\"b\"],[\"b\",\"b\",\"a\"]]")
    print(f"Output: {result3}")
    print(f"Expected: False")