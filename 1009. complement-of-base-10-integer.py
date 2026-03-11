class Solution:
    def bitwiseComplement(self, n: int) -> int:
        if n == 0:
            return 1
        bit_length = n.bit_length()
        mask = (1 << bit_length) - 1
        return n ^ mask

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    n = 5
    output = sol.bitwiseComplement(n)
    print(f"Example 1: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: 2")
    print()
    
    # Example 2:
    n = 7
    output = sol.bitwiseComplement(n)
    print(f"Example 2: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: 0")
    print()
    
    # Example 3:
    n = 10
    output = sol.bitwiseComplement(n)
    print(f"Example 3: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: 5")