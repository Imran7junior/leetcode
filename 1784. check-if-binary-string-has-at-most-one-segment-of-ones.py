class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        count = 0
        i = 0
        n = len(s)

        while i < n:
            if s[i] == '1':
                while i < n and s[i] == '1':
                    i += 1

                if count > 0:
                    return False

                count += 1
            else:
                i += 1

        return True

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    s = "1001"
    output = sol.checkOnesSegment(s)
    print(f"Example 1: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: False")
    print()
    
    # Example 2:
    s = "110"
    output = sol.checkOnesSegment(s)
    print(f"Example 2: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: True")