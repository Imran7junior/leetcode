class Solution:
    def areSimilar(self, mat, k):
        m, n = len(mat), len(mat[0])
        
        k %= n  # (reduce k<n)
        
        for i in range(m):
            for j in range(n):
                if i % 2 == 0:
                    # even row , left shift
                    if mat[i][j] != mat[i][(j + k) % n]:
                        return False
                else:
                    # odd row , right shift
                    if mat[i][j] != mat[i][(j - k) % n]:
                        return False
        
        return True

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    mat1 = [[1,2,3],[4,5,6],[7,8,9]]
    k1 = 4
    output1 = sol.areSimilar(mat1, k1)
    print(f"Example 1: mat=[[1,2,3],[4,5,6],[7,8,9]], k={k1}")
    print(f"Output: {output1}")
    print(f"Expected: False")
    print()
    
    # Example 2
    mat2 = [[1,2,1,2],[5,5,5,5],[6,3,6,3]]
    k2 = 2
    output2 = sol.areSimilar(mat2, k2)
    print(f"Example 2: mat=[[1,2,1,2],[5,5,5,5],[6,3,6,3]], k={k2}")
    print(f"Output: {output2}")
    print(f"Expected: True")
    print()
    
    # Example 3
    mat3 = [[2,2],[2,2]]
    k3 = 3
    output3 = sol.areSimilar(mat3, k3)
    print(f"Example 3: mat=[[2,2],[2,2]], k={k3}")
    print(f"Output: {output3}")
    print(f"Expected: True")