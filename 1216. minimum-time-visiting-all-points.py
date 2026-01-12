from typing import List

class Solution:
    def minTimeToVisitAllPoints(self, p: List[List[int]]) -> int:
        Ans = 0
        for i in range(1, len(p)):
            Ans += max(
                abs(p[i][0] - p[i - 1][0]),
                abs(p[i][1] - p[i - 1][1])
            )
        return Ans


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    points1 = [[1,1],[3,4],[-1,0]]
    output1 = solution.minTimeToVisitAllPoints(points1)
    print(f"Test 1: points = {points1}")
    print(f"Output: {output1}, Expected: 7")
    assert output1 == 7, f"Test 1 failed: expected 7, got {output1}"
    
    # Test case 2
    points2 = [[3,2],[-2,2]]
    output2 = solution.minTimeToVisitAllPoints(points2)
    print(f"Test 2: points = {points2}")
    print(f"Output: {output2}, Expected: 5")
    assert output2 == 5, f"Test 2 failed: expected 5, got {output2}"
    
    print("\nAll test cases passed!")