class Solution:
    def maximumScore(self, grid: List[List[int]]) -> int:
        

        prefix = [[0] * (len(grid) + 1)]

        for i in range(len(grid) + 1):
            prefix.append([0] * (len(grid) + 1))
        
        # print(prefix)

        for i in range(len(grid)):
            sm = 0
            for j in range(len(grid[0])):
                sm += grid[j][i]
                prefix[j + 1][i] = sm

        # print(prefix)

        @cache
        def dp(col, prev, flag):

            if col >= len(grid):
                return 0

            
            ans = 0 
            
            for i in range(0, len(grid) + 1):


                if prev > i:
                    sm = 0
                    sm = (prefix[prev][col] - prefix[i][col])
                    ans = max(ans, sm + dp(col + 1, i, True))
                elif i > prev and not flag and col > 0:
                    sm_prev = 0
                    # for r in range(prev, i):
                    # print(i, prev)
                    # print(prefix[i][col], prefix[prev][col])
                    sm_prev = (prefix[i][col - 1] - prefix[prev][col - 1])
                    ans = max(ans, sm_prev + dp(col + 1, i, False))
                else:
                    ans = max(ans, 0 + dp(col + 1, i, False))

            
            return ans 
        

        tmp = dp(0, 0, True)
        dp.cache_clear()
        return (tmp)


# Test cases
if __name__ == "__main__":
    from typing import List
    from functools import cache
    
    solution = Solution()
    
    # Example 1
    grid1 = [[0,0,0,0,0],[0,0,3,0,0],[0,1,0,0,0],[5,0,0,3,0],[0,0,0,0,2]]
    result1 = solution.maximumScore(grid1)
    print(f"Example 1: Input: grid = [[0,0,0,0,0],[0,0,3,0,0],[0,1,0,0,0],[5,0,0,3,0],[0,0,0,0,2]]")
    print(f"Output: {result1}")
    print(f"Expected: 11\n")
    
    # Example 2
    grid2 = [[10,9,0,0,15],[7,1,0,8,0],[5,20,0,11,0],[0,0,0,1,2],[8,12,1,10,3]]
    result2 = solution.maximumScore(grid2)
    print(f"Example 2: Input: grid = [[10,9,0,0,15],[7,1,0,8,0],[5,20,0,11,0],[0,0,0,1,2],[8,12,1,10,3]]")
    print(f"Output: {result2}")
    print(f"Expected: 94")