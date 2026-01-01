from typing import List

class UnionFind:
    """Union-Find (Disjoint Set Union) data structure with path compression and union by rank"""
    
    def __init__(self, n: int):
        self.parent = list(range(n))
        self.rank = [0] * n
    
    def find(self, x: int) -> int:
        """Find the root of x with path compression"""
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, x: int, y: int) -> bool:
        """Union two sets by rank, returns True if they were not already connected"""
        root_x, root_y = self.find(x), self.find(y)
        
        if root_x == root_y:
            return False
        
        # Union by rank
        if self.rank[root_x] < self.rank[root_y]:
            self.parent[root_x] = root_y
        elif self.rank[root_x] > self.rank[root_y]:
            self.parent[root_y] = root_x
        else:
            self.parent[root_y] = root_x
            self.rank[root_x] += 1
        
        return True
    
    def connected(self, x: int, y: int) -> bool:
        """Check if x and y are in the same set"""
        return self.find(x) == self.find(y)


class Solution:
    def latestDayToCross(self, row: int, col: int, cells: List[List[int]]) -> int:
        """
        Optimized Union-Find approach (work backwards):
        - Start from the last day (all flooded)
        - Work backwards, "unflooding" cells one by one
        - Use Union-Find to connect adjacent land cells
        - Use virtual top and bottom nodes
        - When top and bottom become connected, that's our answer
        
        Time: O(R * C * α(R*C)) where α is inverse Ackermann (nearly O(R*C))
        Space: O(R * C)
        """
        
        # Create Union-Find with row*col cells + 2 virtual nodes (top and bottom)
        uf = UnionFind(row * col + 2)
        top_node = row * col  # Virtual node for top row
        bottom_node = row * col + 1  # Virtual node for bottom row
        
        # Mark all cells as water initially
        grid = [[1] * col for _ in range(row)]
        
        # 4 directions
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        
        # Work backwards from the last day
        for day in range(len(cells) - 1, -1, -1):
            r, c = cells[day]
            r -= 1  # Convert to 0-indexed
            c -= 1
            
            # Unflood this cell (make it land)
            grid[r][c] = 0
            cell_id = r * col + c
            
            # Connect to top virtual node if in first row
            if r == 0:
                uf.union(cell_id, top_node)
            
            # Connect to bottom virtual node if in last row
            if r == row - 1:
                uf.union(cell_id, bottom_node)
            
            # Connect to adjacent land cells
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < row and 0 <= nc < col and grid[nr][nc] == 0:
                    neighbor_id = nr * col + nc
                    uf.union(cell_id, neighbor_id)
            
            # Check if top and bottom are connected
            if uf.connected(top_node, bottom_node):
                return day
        
        return 0


# Test cases
solution = Solution()

# Test 1
row1, col1 = 2, 2
cells1 = [[1,1],[2,1],[1,2],[2,2]]
result1 = solution.latestDayToCross(row1, col1, cells1)
print(f"Test 1: row={row1}, col={col1}, cells={cells1}")
print(f"Output: {result1}, Expected: 2\n")

# Test 2
row2, col2 = 2, 2
cells2 = [[1,1],[1,2],[2,1],[2,2]]
result2 = solution.latestDayToCross(row2, col2, cells2)
print(f"Test 2: row={row2}, col={col2}, cells={cells2}")
print(f"Output: {result2}, Expected: 1\n")

# Test 3
row3, col3 = 3, 3
cells3 = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,1],[3,2]]
result3 = solution.latestDayToCross(row3, col3, cells3)
print(f"Test 3: row={row3}, col={col3}, cells={cells3}")
print(f"Output: {result3}, Expected: 3\n")
