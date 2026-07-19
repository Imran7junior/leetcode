from collections import Counter


class Solution:
    def smallestSubsequence(self, s: str) -> str:
        freq = Counter(s)
        seen = set()
        stack = []

        for c in s:
            freq[c] -= 1
            if c in seen:
                continue

            while stack and stack[-1] > c and freq[stack[-1]]:
                seen.remove(stack.pop())

            stack.append(c)
            seen.add(c)

        return "".join(stack)


if __name__ == "__main__":
    sol = Solution()

    # Example 1
    s = "bcabc"
    print(sol.smallestSubsequence(s))  # "abc"

    # Example 2
    s = "cbacdcbc"
    print(sol.smallestSubsequence(s))  # "acdb"