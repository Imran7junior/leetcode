class Solution:
    def numSteps(self, s: str) -> int:
        steps = 0
        carry = 0
        
        for i in range(len(s) - 1, 0, -1):
            bit = int(s[i]) + carry
            
            if bit == 1:
                steps += 2
                carry = 1
            else:
                steps += 1
        
        return steps + carry

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    s = "1101"
    output = sol.numSteps(s)
    print(f"Example 1: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: 6")
    print()
    
    # Example 2:
    s = "10"
    output = sol.numSteps(s)
    print(f"Example 2: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: 1")
    print()
    
    # Example 3:
    s = "1"
    output = sol.numSteps(s)
    print(f"Example 3: Input: s = {s}")
    print(f"Output: {output}")
    print(f"Expected: 0")