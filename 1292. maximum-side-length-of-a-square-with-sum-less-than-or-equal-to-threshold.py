from typing import List

class Solution:
    def maxSideLength(self, mat: List[List[int]], threshold: int) -> int:
        m, n = len(mat), len(mat[0])

        pref = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                pref[i][j] = (
                    mat[i-1][j-1]
                    + pref[i-1][j]
                    + pref[i][j-1]
                    - pref[i-1][j-1]
                )

        maxSide = min(m, n)

        while maxSide > 0:
            for i in range(m - maxSide + 1):
                for j in range(n - maxSide + 1):
                    s = (
                        pref[i+maxSide][j+maxSide]
                        - pref[i][j+maxSide]
                        - pref[i+maxSide][j]
                        + pref[i][j]
                    )
                    if s <= threshold:
                        return maxSide
            maxSide -= 1

        return 0


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    mat1 = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]]
    threshold1 = 4
    output1 = solution.maxSideLength(mat1, threshold1)
    print(f"Test 1: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = {threshold1}")
    print(f"Output: {output1}, Expected: 2")
    
    # Test case 2
    mat2 = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]]
    threshold2 = 1
    output2 = solution.maxSideLength(mat2, threshold2)
    print(f"Test 2: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = {threshold2}")
    print(f"Output: {output2}, Expected: 0")
    
    print("\nTest cases executed!")
