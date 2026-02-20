
class Solution:
    def makeLargestSpecial(self, s: str) -> str:
        if s == '':
            return ''
        ans = []
        cnt = 0
        i = j = 0
        while i < len(s):
            cnt += 1 if s[i] == '1' else -1
            if cnt == 0:
                ans.append('1' + self.makeLargestSpecial(s[j + 1 : i]) + '0')
                j = i + 1
            i += 1
        ans.sort(reverse=True)
        return ''.join(ans)

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    s = "11011000"
    output = sol.makeLargestSpecial(s)
    print(f"Example 1: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: 11100100")
    print()
    
    # Example 2:
    s = "10"
    output = sol.makeLargestSpecial(s)
    print(f"Example 2: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: 10")