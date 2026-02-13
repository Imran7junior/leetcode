from collections import Counter

class Solution:
    def longestBalanced(self, s: str) -> int:
        def calc1(s):
            res = 0
            i = 0
            while i < len(s):
                j = i
                while j < len(s) and s[j] == s[i]:
                    j += 1
                res = max(res, j - i)
                i = j
            return res

        def calc2(s, a, b):
            res = 0
            i = 0
            while i < len(s):
                while i < len(s) and s[i] not in (a, b):
                    i += 1
                mp = {0: i - 1}
                diff = 0
                while i < len(s) and s[i] in (a, b):
                    diff += 1 if s[i] == a else -1
                    if diff in mp:
                        res = max(res, i - mp[diff])
                    else:
                        mp[diff] = i
                    i += 1
            return res

        def calc3(s):
            mp = {(0, 0): -1}
            cnt = [0, 0, 0]
            res = 0
            for i, c in enumerate(s):
                cnt[ord(c) - ord('a')] += 1
                x = cnt[0] - cnt[1]
                y = cnt[1] - cnt[2]
                key = (x, y)
                if key in mp:
                    res = max(res, i - mp[key])
                else:
                    mp[key] = i
            return res

        x = calc1(s)
        y = max(calc2(s, 'a', 'b'),
                calc2(s, 'b', 'c'),
                calc2(s, 'a', 'c'))
        z = calc3(s)
        return max(x, y, z)

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    s1 = "abbac"
    result1 = sol.longestBalanced(s1)
    print(f"Example 1: s = '{s1}' -> {result1} (Expected: 4)")
    print(f"Explanation: The longest balanced substring is 'abba' because both distinct characters 'a' and 'b' each appear exactly 2 times.\n")
    
    # Example 2
    s2 = "aabcc"
    result2 = sol.longestBalanced(s2)
    print(f"Example 2: s = '{s2}' -> {result2} (Expected: 3)")
    print(f"Explanation: The longest balanced substring is 'abc' because all distinct characters 'a', 'b' and 'c' each appear exactly 1 time.\n")
    
    # Example 3
    s3 = "aba"
    result3 = sol.longestBalanced(s3)
    print(f"Example 3: s = '{s3}' -> {result3} (Expected: 2)\n")