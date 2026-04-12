class Solution(object):
    def cal(self, a, b):
        return abs(a // 6 - b // 6) + abs(a % 6 - b % 6)

    def minimumDistance(self, word):
        n = len(word)
        dp = [0] * 26
        ndp = [0] * 26

        for i in range(1, n):
            p = ord(word[i - 1]) - ord('A')
            t = ord(word[i]) - ord('A')

            for j in range(26):
                ndp[j] = dp[j] + self.cal(p, t)

            for j in range(26):
                ndp[p] = min(ndp[p], dp[j] + self.cal(j, t))

            dp, ndp = ndp, dp

        return min(dp)

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    word1 = "CAKE"
    output1 = sol.minimumDistance(word1)
    print(f"Example 1: word='{word1}'")
    print(f"Output: {output1}")
    print(f"Expected: 3")
    print()
    
    # Example 2
    word2 = "HAPPY"
    output2 = sol.minimumDistance(word2)
    print(f"Example 2: word='{word2}'")
    print(f"Output: {output2}")
    print(f"Expected: 6")