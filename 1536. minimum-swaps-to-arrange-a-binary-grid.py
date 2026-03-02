class Solution:
    def minSwaps(self, grid):
        n = len(grid)
        zeros = []

        for row in grid:
            count = 0
            for j in range(n - 1, -1, -1):
                if row[j] == 0:
                    count += 1
                else:
                    break
            zeros.append(count)

        swaps = 0

        for i in range(n):
            needed = n - i - 1
            j = i
            while j < n and zeros[j] < needed:
                j += 1
            if j == n:
                return -1
            while j > i:
                zeros[j], zeros[j - 1] = zeros[j - 1], zeros[j]
                j -= 1
                swaps += 1

        return swaps

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    grid = [[0,0,1],[1,1,0],[1,0,0]]
    output = sol.minSwaps(grid)
    print(f"Example 1: Input: grid = {grid}")
    print(f"Output: {output}")
    print(f"Expected: 3")
    print()
    
    # Example 2:
    grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
    output = sol.minSwaps(grid)
    print(f"Example 2: Input: grid = {grid}")
    print(f"Output: {output}")
    print(f"Expected: -1")
    print()
    
    # Example 3:
    grid = [[1,0,0],[1,1,0],[1,1,1]]
    output = sol.minSwaps(grid)
    print(f"Example 3: Input: grid = {grid}")
    print(f"Output: {output}")
    print(f"Expected: 0")