from typing import List

class Solution:
    def largestSquareArea(self, bl: List[List[int]], tr: List[List[int]]) -> int:
        s = 0
        n = len(bl)

        for i in range(n):
            for j in range(i + 1, n):
                minX = max(bl[i][0], bl[j][0])
                maxX = min(tr[i][0], tr[j][0])
                minY = max(bl[i][1], bl[j][1])
                maxY = min(tr[i][1], tr[j][1])

                if minX < maxX and minY < maxY:
                    length = min(maxX - minX, maxY - minY)
                    s = max(s, length)

        return s * s


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    bottomLeft1 = [[1,1],[2,2],[3,1]]
    topRight1 = [[3,3],[4,4],[6,6]]
    output1 = solution.largestSquareArea(bottomLeft1, topRight1)
    print(f"Test 1: bottomLeft = {bottomLeft1}, topRight = {topRight1}")
    print(f"Output: {output1}, Expected: 1")
    
    # Test case 2
    bottomLeft2 = [[1,1],[1,3],[1,5]]
    topRight2 = [[5,5],[5,7],[5,9]]
    output2 = solution.largestSquareArea(bottomLeft2, topRight2)
    print(f"Test 2: bottomLeft = {bottomLeft2}, topRight = {topRight2}")
    print(f"Output: {output2}, Expected: 4")
    
    # Test case 3
    bottomLeft3 = [[1,1],[2,2],[1,2]]
    topRight3 = [[3,3],[4,4],[3,4]]
    output3 = solution.largestSquareArea(bottomLeft3, topRight3)
    print(f"Test 3: bottomLeft = {bottomLeft3}, topRight = {topRight3}")
    print(f"Output: {output3}, Expected: 1")
    
    # Test case 4
    bottomLeft4 = [[1,1],[3,3],[3,1]]
    topRight4 = [[2,2],[4,4],[4,2]]
    output4 = solution.largestSquareArea(bottomLeft4, topRight4)
    print(f"Test 4: bottomLeft = {bottomLeft4}, topRight = {topRight4}")
    print(f"Output: {output4}, Expected: 0")
    
    print("\nTest cases executed!")
