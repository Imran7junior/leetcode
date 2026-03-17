class Solution:
    def largestSubmatrix(self, matrix: list[list[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        maxArea = 0
        h = [0] * n

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 1:
                    h[j] += 1
                else:
                    h[j] = 0
            sh = sorted(h, reverse=True)
            for j in range(n):
                if sh[j] == 0:
                    break
                maxArea = max(maxArea, sh[j] * (j + 1))
        
        return maxArea

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    matrix = [[0,0,1],[1,1,1],[1,0,1]]
    output = sol.largestSubmatrix(matrix)
    print(f"Example 1: Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]")
    print(f"Output: {output}")
    print(f"Expected: 4")
    print()
    
    # Example 2:
    matrix = [[1,0,1,0,1]]
    output = sol.largestSubmatrix(matrix)
    print(f"Example 2: Input: matrix = [[1,0,1,0,1]]")
    print(f"Output: {output}")
    print(f"Expected: 3")
    print()
    
    # Example 3:
    matrix = [[1,1,0],[1,0,1]]
    output = sol.largestSubmatrix(matrix)
    print(f"Example 3: Input: matrix = [[1,1,0],[1,0,1]]")
    print(f"Output: {output}")
    print(f"Expected: 2")

