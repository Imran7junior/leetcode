class Solution:
    def rotatedDigits(self, n: int) -> int:
        dp = [0] * (n + 1)
        count = 0

        for i in range(n + 1):
            if i < 10:
                if i in (0, 1, 8):
                    dp[i] = 1
                elif i in (2, 5, 6, 9):
                    dp[i] = 2
                    count += 1
                else:
                    dp[i] = 0
            else:
                a = dp[i // 10]
                b = dp[i % 10]

                if a == 1 and b == 1:
                    dp[i] = 1
                elif a >= 1 and b >= 1:
                    dp[i] = 2
                    count += 1
                else:
                    dp[i] = 0

        return count


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Example 1
    n1 = 10
    result1 = solution.rotatedDigits(n1)
    print(f"Example 1: Input: n = {n1}")
    print(f"Output: {result1}")
    print(f"Expected: 4\n")
    
    # Example 2
    n2 = 1
    result2 = solution.rotatedDigits(n2)
    print(f"Example 2: Input: n = {n2}")
    print(f"Output: {result2}")
    print(f"Expected: 0\n")
    
    # Example 3
    n3 = 2
    result3 = solution.rotatedDigits(n3)
    print(f"Example 3: Input: n = {n3}")
    print(f"Output: {result3}")
    print(f"Expected: 1")