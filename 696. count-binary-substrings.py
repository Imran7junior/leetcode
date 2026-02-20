class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        res = 0
        prev = 0
        strk = 1

        for i in range(1, len(s)):
            if s[i] == s[i - 1]: strk += 1
            else:
                prev = strk
                strk = 1

            if strk <= prev: res += 1

        return res

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    s = "00110011"
    output = sol.countBinarySubstrings(s)
    print(f"Example 1: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: 6")
    print()
    
    # Example 2:
    s = "10101"
    output = sol.countBinarySubstrings(s)
    print(f"Example 2: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: 4")
