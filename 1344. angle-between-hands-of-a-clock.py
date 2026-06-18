class Solution:
    def angleClock(self, hour: int, minutes: int) -> float:
        x = hour + minutes / 60
        diff = (11 * x) % 12
        return min(diff, 12 - diff) * 30


if __name__ == "__main__":
    sol = Solution()

    # Example 1: hour = 12, minutes = 30 -> Expected: 165
    assert sol.angleClock(12, 30) == 165, f"Test 1 failed: {sol.angleClock(12, 30)}"

    # Example 2: hour = 3, minutes = 30 -> Expected: 75
    assert sol.angleClock(3, 30) == 75, f"Test 2 failed: {sol.angleClock(3, 30)}"

    # Example 3: hour = 3, minutes = 15 -> Expected: 7.5
    assert sol.angleClock(3, 15) == 7.5, f"Test 3 failed: {sol.angleClock(3, 15)}"

    print("All test cases passed!")