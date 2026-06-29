class Solution:
    def numOfStrings(self, patterns: list[str], word: str) -> int:
        count = 0
        for s in patterns:
            if s in word:
                count += 1
        return count


if __name__ == "__main__":
    sol = Solution()

    print(sol.numOfStrings(["a", "abc", "bc", "d"], "abc"))        # Expected: 3
    print(sol.numOfStrings(["a", "b", "c"], "aaaaabbbbb"))         # Expected: 2
    print(sol.numOfStrings(["a", "a", "a"], "ab"))                 # Expected: 3