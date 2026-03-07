class Solution:
    def minFlips(self, s):
        n = len(s)
        e, o = (n + 1) // 2, n // 2
        x = s[::2].count('1') - s[1::2].count('1')
        r = min(e - x, o + x)
        if n & 1:
            for c in s:
                x = 2 * (ord(c) & 1) - x
                r = min(r, e - x, o + x)
        return r

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    s = "111000"
    output = sol.minFlips(s)
    print(f"Example 1: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: 2")
    print()
    
    # Example 2:
    s = "010"
    output = sol.minFlips(s)
    print(f"Example 2: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: 0")
    print()
    
    # Example 3:
    s = "1110"
    output = sol.minFlips(s)
    print(f"Example 3: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: 1")