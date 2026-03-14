class Solution:
    def __init__(self):
        self.ans = ""

    def solve(self, length, k, n, chars, s):
        if length == n:
            k[0] -= 1
            if k[0] == 0:
                self.ans = s
            return
        for c in chars:
            if length == 0 or s[-1] != c:
                self.solve(length + 1, k, n, chars, s + c)
                if k[0] == 0:
                    return  # Stop recursion early

    def getHappyString(self, n: int, k: int) -> str:
        self.ans = ""
        self.solve(0, [k], n, ['a', 'b', 'c'], "")
        return self.ans

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    n = 1
    k = 3
    output = sol.getHappyString(n, k)
    print(f"Example 1: Input: n = {n}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: c")
    print()
    
    # Example 2:
    n = 1
    k = 4
    output = sol.getHappyString(n, k)
    print(f"Example 2: Input: n = {n}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: (empty string)")
    print()
    
    # Example 3:
    n = 3
    k = 9
    output = sol.getHappyString(n, k)
    print(f"Example 3: Input: n = {n}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: cab")
