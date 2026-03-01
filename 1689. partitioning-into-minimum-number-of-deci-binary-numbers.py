class Solution:
    def minPartitions(self, n: str) -> int:
        return int(max(n))

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    n = "32"
    output = sol.minPartitions(n)
    print(f"Example 1: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: 3")
    print()
    
    # Example 2:
    n = "82734"
    output = sol.minPartitions(n)
    print(f"Example 2: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: 8")
    print()
    
    # Example 3:
    n = "27346209830709182346"
    output = sol.minPartitions(n)
    print(f"Example 3: Input: n = {n}")
    print(f"Output: {output}")
    print(f"Expected: 9")