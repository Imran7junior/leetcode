class Solution:
    def rev(self, n: int) -> int:
        a = 0
        while(n > 0):
            a = a * 10 + (n % 10)
            n //= 10
        return a
    def mirrorDistance(self, n: int) -> int:
        m = self.rev(n)
        return abs(m - n)


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Example 1
    n1 = 25
    result1 = solution.mirrorDistance(n1)
    print(f"Example 1: Input: n = {n1}")
    print(f"Output: {result1}")
    print(f"Expected: 27\n")
    
    # Example 2
    n2 = 10
    result2 = solution.mirrorDistance(n2)
    print(f"Example 2: Input: n = {n2}")
    print(f"Output: {result2}")
    print(f"Expected: 9\n")
    
    # Example 3
    n3 = 7
    result3 = solution.mirrorDistance(n3)
    print(f"Example 3: Input: n = {n3}")
    print(f"Output: {result3}")
    print(f"Expected: 0")