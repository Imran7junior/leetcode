class Solution:
    def __init__(self):
        self.MOD = 10**9 + 7
        self.dp = []

    def solve(self, low, high, zero, one, length):
        if length > high:
            return 0  # Base case
        if self.dp[length] != -1:
            return self.dp[length]  # Memoization

        count = 0
        if low <= length <= high:
            count = 1  # Count valid string

        # Recursive calls for 'zero' and 'one'
        add_one = self.solve(low, high, zero, one, length + one) % self.MOD
        add_zero = self.solve(low, high, zero, one, length + zero) % self.MOD

        self.dp[length] = (count + add_one + add_zero) % self.MOD
        return self.dp[length]

    def countGoodStrings(self, low, high, zero, one):
        self.dp = [-1] * 100001  # Initialize memoization array
        return self.solve(low, high, zero, one, 0)