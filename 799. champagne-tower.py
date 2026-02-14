class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        tower = [[0] * 102 for _ in range(102)]
        tower[0][0] = poured
        
        for r in range(query_row + 1):
            for c in range(r + 1):
                if tower[r][c] > 1:
                    excess = (tower[r][c] - 1.0) / 2.0
                    tower[r][c] = 1
                    tower[r+1][c] += excess
                    tower[r+1][c+1] += excess
                    
        return tower[query_row][query_glass]

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    poured1, query_row1, query_glass1 = 1, 1, 1
    result1 = sol.champagneTower(poured1, query_row1, query_glass1)
    print(f"Example 1: poured = {poured1}, query_row = {query_row1}, query_glass = {query_glass1}")
    print(f"Output: {result1:.5f} (Expected: 0.00000)\n")
    
    # Example 2
    poured2, query_row2, query_glass2 = 2, 1, 1
    result2 = sol.champagneTower(poured2, query_row2, query_glass2)
    print(f"Example 2: poured = {poured2}, query_row = {query_row2}, query_glass = {query_glass2}")
    print(f"Output: {result2:.5f} (Expected: 0.50000)\n")
    
    # Example 3
    poured3, query_row3, query_glass3 = 100000009, 33, 17
    result3 = sol.champagneTower(poured3, query_row3, query_glass3)
    print(f"Example 3: poured = {poured3}, query_row = {query_row3}, query_glass = {query_glass3}")
    print(f"Output: {result3:.5f} (Expected: 1.00000)\n")