class Solution:
    def numberOfStableArrays(self, zero: int, one: int, limit: int) -> int:
        MOD = 10**9 + 7

        dp = [[[0,0] for _ in range(one+1)] for _ in range(zero+1)]

        for i in range(1, min(zero,limit)+1):
            dp[i][0][0] = 1

        for j in range(1, min(one,limit)+1):
            dp[0][j][1] = 1

        for i in range(1, zero+1):
            for j in range(1, one+1):

                over0 = dp[i-limit-1][j][1] if i-limit >= 1 else 0
                over1 = dp[i][j-limit-1][0] if j-limit >= 1 else 0

                dp[i][j][0] = (
                    dp[i-1][j][0] + dp[i-1][j][1] - over0
                ) % MOD

                dp[i][j][1] = (
                    dp[i][j-1][0] + dp[i][j-1][1] - over1
                ) % MOD

        return (dp[zero][one][0] + dp[zero][one][1]) % MOD

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    zero = 1
    one = 1
    limit = 2
    output = sol.numberOfStableArrays(zero, one, limit)
    print(f"Example 1: Input: zero = {zero}, one = {one}, limit = {limit}")
    print(f"Output: {output}")
    print(f"Expected: 2")
    print()
    
    # Example 2:
    zero = 1
    one = 2
    limit = 1
    output = sol.numberOfStableArrays(zero, one, limit)
    print(f"Example 2: Input: zero = {zero}, one = {one}, limit = {limit}")
    print(f"Output: {output}")
    print(f"Expected: 1")
    print()
    
    # Example 3:
    zero = 3
    one = 3
    limit = 2
    output = sol.numberOfStableArrays(zero, one, limit)
    print(f"Example 3: Input: zero = {zero}, one = {one}, limit = {limit}")
    print(f"Output: {output}")
    print(f"Expected: 14")