class Solution:
    def minOperations(self, s: str) -> int:
        count, n = 0, len(s)
        for i in range(n):
            count += (ord(s[i]) ^ i) & 1
            
        return min(count, n - count)

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    s = "0100"
    output = sol.minOperations(s)
    print(f"Example 1: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: 1")
    print()
    
    # Example 2:
    s = "10"
    output = sol.minOperations(s)
    print(f"Example 2: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: 0")
    print()
    
    # Example 3:
    s = "1111"
    output = sol.minOperations(s)
    print(f"Example 3: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: 2")