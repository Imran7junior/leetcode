class Solution:
    def zigZagArrays(self, n: int, l: int, r: int) -> int:
        MOD = 1000000007
        m = r - l + 1
        dp = [1] * m

        for i in range(2, n + 1):
            dp.reverse()
            s = 0
            for j in range(m):
                dp[j], s = s, (s + dp[j]) % MOD

        return (sum(dp) % MOD << 1) % MOD


if __name__ == "__main__":
    sol = Solution()

    print(sol.zigZagArrays(3, 4, 5))  # Expected: 2
    print(sol.zigZagArrays(3, 1, 3))  # Expected: 10