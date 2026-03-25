class Solution(object):
    def canPartitionGrid(self, grid):
        n = len(grid)
        m = len(grid[0])

        def checkHz():
            st = set()
            pref = 0

            for i in range(n):
                rowSum = 0
                for j in range(m):
                    rowSum += grid[i][j]
                pref += rowSum
                st.add(pref)

            if pref % 2 != 0:
                return False

            return (pref // 2) in st

        def checkVz():
            st = set()
            pref = 0

            for j in range(m):
                colSum = 0
                for i in range(n):
                    colSum += grid[i][j]
                pref += colSum
                st.add(pref)

            if pref % 2 != 0:
                return False

            return (pref // 2) in st

        return checkHz() or checkVz()

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    grid1 = [[1,4],[2,3]]
    output1 = sol.canPartitionGrid(grid1)
    print(f"Example 1: grid=[[1,4],[2,3]]")
    print(f"Output: {output1}")
    print(f"Expected: True")
    print()
    
    # Example 2
    grid2 = [[1,3],[2,4]]
    output2 = sol.canPartitionGrid(grid2)
    print(f"Example 2: grid=[[1,3],[2,4]]")
    print(f"Output: {output2}")
    print(f"Expected: False")