from typing import List


class Solution:
    def maximizeSquareHoleArea(self, n: int, m: int, hBars: List[int], vBars: List[int]) -> int:
        hBars.sort()
        vBars.sort()

        maxiH, maxiV, maxi = 1, 1, 1

        for i in range(1, len(hBars)):
            if hBars[i] - hBars[i-1] == 1:
                maxi += 1
            else:
                maxiH = max(maxiH, maxi)
                maxi = 1
        maxiH = max(maxiH, maxi)

        maxi = 1
        for i in range(1, len(vBars)):
            if vBars[i] - vBars[i-1] == 1:
                maxi += 1
            else:
                maxiV = max(maxiV, maxi)
                maxi = 1
        maxiV = max(maxiV, maxi)

        side = min(maxiH+1, maxiV+1)
        return side * side


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    n1, m1 = 2, 1
    hBars1 = [2,3]
    vBars1 = [2]
    output1 = solution.maximizeSquareHoleArea(n1, m1, hBars1, vBars1)
    print(f"Test 1: n={n1}, m={m1}, hBars={[2,3]}, vBars={[2]}")
    print(f"Output: {output1}, Expected: 4")
    
    # Test case 2
    n2, m2 = 1, 1
    hBars2 = [2]
    vBars2 = [2]
    output2 = solution.maximizeSquareHoleArea(n2, m2, hBars2, vBars2)
    print(f"Test 2: n={n2}, m={m2}, hBars={[2]}, vBars={[2]}")
    print(f"Output: {output2}, Expected: 4")
    
    # Test case 3
    n3, m3 = 2, 3
    hBars3 = [2,3]
    vBars3 = [2,4]
    output3 = solution.maximizeSquareHoleArea(n3, m3, hBars3, vBars3)
    print(f"Test 3: n={n3}, m={m3}, hBars={[2,3]}, vBars={[2,4]}")
    print(f"Output: {output3}, Expected: 4")
    
    print("\nTest cases executed!")