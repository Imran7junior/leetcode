class Solution:
    def binaryGap(self, n: int) -> int:
        last_position = -1
        max_gap = 0
        position = 0

        while n > 0:
            if n & 1:
                if last_position != -1:
                    max_gap = max(max_gap, position - last_position)
                last_position = position

            n >>= 1
            position += 1

        return max_gap

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    n = 22
    output = sol.binaryGap(n)
    print(f"Example 1: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: 2")
    print()
    
    # Example 2:
    n = 8
    output = sol.binaryGap(n)
    print(f"Example 2: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: 0")
    print()
    
    # Example 3:
    n = 5
    output = sol.binaryGap(n)
    print(f"Example 3: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: 2")