class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0
        for i in range(32):
            res = (res << 1) | (n & 1)
            n >>= 1
        return res

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    n = 43261596
    output = sol.reverseBits(n)
    print(f"Example 1: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: 964176192")
    print()
    
    # Example 2:
    n = 2147483644
    output = sol.reverseBits(n)
    print(f"Example 2: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: 1073741822")