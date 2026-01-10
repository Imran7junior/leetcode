class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        m, n = len(s1), len(s2)
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if s1[i] == s2[j]:
                    dp[i][j] = ord(s1[i]) + dp[i + 1][j + 1]
                else:
                    dp[i][j] = max(dp[i + 1][j], dp[i][j + 1])

        total = sum(ord(c) for c in s1) + sum(ord(c) for c in s2)
        return total - 2 * dp[0][0]


# Test cases
if __name__ == "__main__":
    sol = Solution()
    
    # Test case 1: s1 = "sea", s2 = "eat" expected output: 231
    result1 = sol.minimumDeleteSum("sea", "eat")
    print(f"Test 1: {result1}")
    
    # Test case 2: s1 = "delete", s2 = "leet" expected output: 403
    result2 = sol.minimumDeleteSum("delete", "leet")
    print(f"Test 2: {result2}")
    
    print("All test cases executed!")
