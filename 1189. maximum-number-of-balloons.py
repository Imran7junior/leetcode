class Solution:
    def maxNumberOfBalloons(self, text):
        text = list(text)
        ans = 0

        while True:
            word = list("balloon")

            for c in word:
                found = False

                for i in range(len(text)):
                    if text[i] == c:
                        text[i] = '#'
                        found = True
                        break

                if not found:
                    return ans

            ans += 1


if __name__ == "__main__":
    sol = Solution()

    print(sol.maxNumberOfBalloons("nlaebolko"))         # Expected: 1
    print(sol.maxNumberOfBalloons("loonbalxballpoon"))  # Expected: 2
    print(sol.maxNumberOfBalloons("leetcode"))          # Expected: 0