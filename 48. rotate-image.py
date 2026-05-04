class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)

        # transpose
        for i in range(n):
            for j in range(i + 1, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

        # reverse each row
        for row in matrix:
            row.reverse()


# Test cases
if __name__ == "__main__":
    from typing import List
    from copy import deepcopy
    
    solution = Solution()
    
    # Example 1
    matrix1 = [[1,2,3],[4,5,6],[7,8,9]]
    matrix1_copy = deepcopy(matrix1)
    solution.rotate(matrix1_copy)
    print(f"Example 1: Input: matrix = {matrix1}")
    print(f"Output: {matrix1_copy}")
    print(f"Expected: [[7,4,1],[8,5,2],[9,6,3]]\n")
    
    # Example 2
    matrix2 = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    matrix2_copy = deepcopy(matrix2)
    solution.rotate(matrix2_copy)
    print(f"Example 2: Input: matrix = {matrix2}")
    print(f"Output: {matrix2_copy}")
    print(f"Expected: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]")