class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        x = n ^ (n >> 1)
        return (x & (x + 1)) == 0

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    n = 5
    output = sol.hasAlternatingBits(n)
    print(f"Example 1: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: true")
    print()
    
    # Example 2:
    n = 7
    output = sol.hasAlternatingBits(n)
    print(f"Example 2: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: false")
    print()
    
    # Example 3:
    n = 11
    output = sol.hasAlternatingBits(n)
    print(f"Example 3: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: false")