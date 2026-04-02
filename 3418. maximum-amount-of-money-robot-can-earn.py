class Solution(object):
    def maximumAmount(self, coins):
        n = len(coins)
        m = len(coins[0])
        dp = [[[-10**9] * 3 for _ in range(m)] for _ in range(n)]

        dp[0][0][1] = dp[0][0][2] = 0
        dp[0][0][0] = coins[0][0]

        for i in range(n):
            for j in range(m):
                for k in range(3):
                    if i:
                        dp[i][j][k] = max(dp[i][j][k], dp[i - 1][j][k] + coins[i][j])
                    if i and k:
                        dp[i][j][k] = max(dp[i][j][k], dp[i - 1][j][k - 1])
                    if j:
                        dp[i][j][k] = max(dp[i][j][k], dp[i][j - 1][k] + coins[i][j])
                    if j and k:
                        dp[i][j][k] = max(dp[i][j][k], dp[i][j - 1][k - 1])

        return max(dp[n - 1][m - 1])

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    coins1 = [[0,1,-1],[1,-2,3],[2,-3,4]]
    output1 = sol.maximumAmount(coins1)
    print(f"Example 1: coins=[[0,1,-1],[1,-2,3],[2,-3,4]]")
    print(f"Output: {output1}")
    print(f"Expected: 8")
    print()
    
    # Example 2
    coins2 = [[10,10,10],[10,10,10]]
    output2 = sol.maximumAmount(coins2)
    print(f"Example 2: coins=[[10,10,10],[10,10,10]]")
    print(f"Output: {output2}")
    print(f"Expected: 40")