class Solution:
    def concatenatedBinary(self, n: int) -> int:
        MOD = 10**9 + 7
        res = 0
        bits = 0

        for i in range(1, n+1):
            if (i & (i-1)) == 0:
                bits += 1
            res = ((res << bits) | i) % MOD

        return res

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    n = 1
    output = sol.concatenatedBinary(n)
    print(f"Example 1: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: 1")
    print()
    
    # Example 2:
    n = 3
    output = sol.concatenatedBinary(n)
    print(f"Example 2: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: 27")
    print()
    
    # Example 3:
    n = 12
    output = sol.concatenatedBinary(n)
    print(f"Example 3: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: 505379714")