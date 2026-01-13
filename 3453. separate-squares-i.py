from typing import List
from collections import Counter
class Solution:
    def separateSquares(self, squares: List[List[int]]) -> float:
        axis = Counter()
        total = 0
        for _, y, s in squares:
            area = s*s
            total += area
            axis[y] += s
            axis[y+s] -= s
        
        target = total / 2
        
        events = sorted(axis.items())
        cur = 0
        last_y = events[0][0] - 1
        for y, a_unit in events:
            dy = (y-last_y)
            nar = cur * dy
            if target - nar <= 0:
                return last_y + (target / nar) * dy

            target -= nar
            cur += a_unit
            last_y = y


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    squares1 = [[0,0,1],[2,2,1]]
    output1 = solution.separateSquares(squares1)
    print(f"Test 1: squares = {squares1}")
    print(f"Output: {output1:.5f}, Expected: 1.00000")
    
    # Test case 2
    squares2 = [[0,0,2],[1,1,1]]
    output2 = solution.separateSquares(squares2)
    print(f"Test 2: squares = {squares2}")
    print(f"Output: {output2:.5f}, Expected: 1.16667")
    
    print("\nTest cases executed!")