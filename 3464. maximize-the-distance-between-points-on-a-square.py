class Solution:
    def maxDistance(self, side: int, points: List[List[int]], k: int) -> int:
        res = []
        for x, y in points:
            if x == 0:
                res.append(y)
            elif y == side:
                res.append(side + x)
            elif x == side:
                res.append(side * 3 - y)
            else:
                res.append(side * 4 - x)
        res.sort()
        def check(n : int) -> bool:
            idx = [0] * k
            curr = res[0]
            for i in range(1, k):
                j = bisect_left(res, curr + n)
                if j == len(res):
                    return False
                idx[i] = j
                curr = res[j]
            if curr - res[0] <= side * 4 - n:
                return True
            
            for idx[0] in range(1, idx[1]):
                for j in range(1, k):
                    while res[idx[j]] < res[idx[j - 1]] + n:
                        idx[j] += 1
                        if idx[j] == len(res):
                            return False
                if res[idx[-1]] - res[idx[0]] <= side * 4 - n:
                    return True
            return False
        
        left, right = 1, side + 1
        while left + 1 < right:
            mid = (left + right) // 2
            if check(mid):
                left = mid
            else:
                right = mid
        return left

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    side1 = 2
    points1 = [[0,2],[2,0],[2,2],[0,0]]
    k1 = 4
    output1 = sol.maxDistance(side1, points1, k1)
    print(f"Example 1: side={side1}, points={points1}, k={k1}")
    print(f"Output: {output1}")
    print(f"Expected: 2")
    print()
    
    # Example 2
    side2 = 2
    points2 = [[0,0],[1,2],[2,0],[2,2],[2,1]]
    k2 = 4
    output2 = sol.maxDistance(side2, points2, k2)
    print(f"Example 2: side={side2}, points={points2}, k={k2}")
    print(f"Output: {output2}")
    print(f"Expected: 1")
    print()
    
    # Example 3
    side3 = 2
    points3 = [[0,0],[0,1],[0,2],[1,2],[2,0],[2,2],[2,1]]
    k3 = 5
    output3 = sol.maxDistance(side3, points3, k3)
    print(f"Example 3: side={side3}, points={points3}, k={k3}")
    print(f"Output: {output3}")
    print(f"Expected: 1")