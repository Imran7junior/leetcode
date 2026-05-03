class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        if len(s) != len(goal):
            return False
        return goal in s + s


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Example 1
    s1 = "abcde"
    goal1 = "cdeab"
    result1 = solution.rotateString(s1, goal1)
    print(f"Example 1: Input: s = \"{s1}\", goal = \"{goal1}\"")
    print(f"Output: {result1}")
    print(f"Expected: True\n")
    
    # Example 2
    s2 = "abcde"
    goal2 = "abced"
    result2 = solution.rotateString(s2, goal2)
    print(f"Example 2: Input: s = \"{s2}\", goal = \"{goal2}\"")
    print(f"Output: {result2}")
    print(f"Expected: False")