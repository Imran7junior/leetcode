class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        res, p = 0, [5e4, -1, -1, -1]

        for i, ch in enumerate(s):
            p[ord(ch) & 31] = i
            res += min(p) + 1

        return res


if __name__ == "__main__":
    sol = Solution()

    print(sol.numberOfSubstrings("abcabc"))  # Expected: 10
    print(sol.numberOfSubstrings("aaacb"))   # Expected: 3
    print(sol.numberOfSubstrings("abc"))     # Expected: 1