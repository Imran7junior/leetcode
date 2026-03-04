class Solution:
    def numSpecial(self, mat):
        m, n = len(mat), len(mat[0])
        row = [0] * m
        col = [0] * n

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    row[i] += 1
                    col[j] += 1

        return sum(
            mat[i][j] == 1 and row[i] == 1 and col[j] == 1
            for i in range(m)
            for j in range(n)
        )

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    mat = [[1,0,0],[0,0,1],[1,0,0]]
    output = sol.numSpecial(mat)
    print(f"Example 1: Input: mat = {mat}")
    print(f"Output: {output}")
    print(f"Expected: 1")
    print()
    
    # Example 2:
    mat = [[1,0,0],[0,1,0],[0,0,1]]
    output = sol.numSpecial(mat)
    print(f"Example 2: Input: mat = {mat}")
    print(f"Output: {output}")
    print(f"Expected: 3")