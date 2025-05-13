class Solution:
    def lengthAfterTransformations(self, s: str, t: int) -> int:
        mod = 10 ** 9 + 7
        dp = [1] * 26 + [0] * 100100
        for i in range(26, 100100):
            dp[i] = (dp[i - 26] + dp[i - 26 + 1]) % mod
        return sum(dp[ord(c) - ord('a') + t] for c in s) % mod