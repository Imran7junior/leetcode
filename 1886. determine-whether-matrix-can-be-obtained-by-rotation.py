from typing import List

class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        for _ in range(4):
            if mat == target:
                return True
            # Rotate 90 degrees clockwise
            mat = [list(row) for row in zip(*mat[::-1])]
        return False

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    mat1 = [[0,1],[1,0]]
    target1 = [[1,0],[0,1]]
    output1 = sol.findRotation(mat1, target1)
    print(f"Example 1: mat=[[0,1],[1,0]], target=[[1,0],[0,1]]")
    print(f"Output: {output1}")
    print(f"Expected: True")
    print()
    
    # Example 2
    mat2 = [[0,1],[1,1]]
    target2 = [[1,0],[0,1]]
    output2 = sol.findRotation(mat2, target2)
    print(f"Example 2: mat=[[0,1],[1,1]], target=[[1,0],[0,1]]")
    print(f"Output: {output2}")
    print(f"Expected: False")
    print()
    
    # Example 3
    mat3 = [[0,0,0],[0,1,0],[1,1,1]]
    target3 = [[1,1,1],[0,1,0],[0,0,0]]
    output3 = sol.findRotation(mat3, target3)
    print(f"Example 3: mat=[[0,0,0],[0,1,0],[1,1,1]], target=[[1,1,1],[0,1,0],[0,0,0]]")
    print(f"Output: {output3}")
    print(f"Expected: True")