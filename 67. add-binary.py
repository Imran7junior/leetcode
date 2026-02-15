class Solution:
    def addBinary(self, a: str, b: str) -> str:
        return bin(int(a,2)+int(b,2))[2:]

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    a1, b1 = "11", "1"
    result1 = sol.addBinary(a1, b1)
    print(f"Example 1: a = \"{a1}\", b = \"{b1}\"")
    print(f"Output: \"{result1}\" (Expected: \"100\")\n")
    
    # Example 2
    a2, b2 = "1010", "1011"
    result2 = sol.addBinary(a2, b2)
    print(f"Example 2: a = \"{a2}\", b = \"{b2}\"")
    print(f"Output: \"{result2}\" (Expected: \"10101\")\n")