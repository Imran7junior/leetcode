class Solution:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        arr = [num for row in grid for num in row]  # Flatten the grid
        arr.sort()
        median = arr[len(arr) // 2]  # Find the median
        
        # Check if all elements can be transformed
        for num in arr:
            if (num - median) % x != 0:
                return -1  # Impossible case

        # Calculate the minimum number of operations
        return sum(abs(num - median) // x for num in arr)


# Test cases
if __name__ == "__main__":
    from typing import List
    
    solution = Solution()
    
    # Example 1
    grid1 = [[2,4],[6,8]]
    x1 = 2
    result1 = solution.minOperations(grid1, x1)
    print(f"Example 1: Input: grid = {grid1}, x = {x1}")
    print(f"Output: {result1}")
    print(f"Expected: 4\n")
    
    # Example 2
    grid2 = [[1,5],[2,3]]
    x2 = 1
    result2 = solution.minOperations(grid2, x2)
    print(f"Example 2: Input: grid = {grid2}, x = {x2}")
    print(f"Output: {result2}")
    print(f"Expected: 5\n")
    
    # Example 3
    grid3 = [[1,2],[3,4]]
    x3 = 2
    result3 = solution.minOperations(grid3, x3)
    print(f"Example 3: Input: grid = {grid3}, x = {x3}")
    print(f"Output: {result3}")
    print(f"Expected: -1")