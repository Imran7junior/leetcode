class Solution:
    def numOfWays(self, n: int) -> int:
        MOD = 10**9 + 7
        A = B = 6

        for _ in range(2, n + 1):
            A, B = (2*A + 2*B) % MOD, (2*A + 3*B) % MOD

        return (A + B) % MOD

# Example usage
sol = Solution()
print(sol.numOfWays(1))  # Output: 12	
print(sol.numOfWays(5000))  # Output: 30228214