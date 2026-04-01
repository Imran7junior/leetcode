from typing import List

class Solution:
    def survivedRobotsHealths(self, positions: List[int], h: List[int], directions: str) -> List[int]:
        n = len(positions)
        ind = sorted(range(n), key=positions.__getitem__)
        stack = []
        for i in ind:
            if directions[i] == 'R':
                stack.append(i)
                continue
            while stack and h[i] > 0:
                if h[stack[-1]] < h[i]:
                    h[stack.pop()] = 0
                    h[i] -= 1
                elif h[stack[-1]] > h[i]:
                    h[stack[-1]] -= 1
                    h[i] = 0
                else:
                    h[stack.pop()] = 0
                    h[i] = 0
        return [v for v in h if v > 0]

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    positions1 = [5,4,3,2,1]
    healths1 = [2,17,9,15,10]
    directions1 = "RRRRR"
    output1 = sol.survivedRobotsHealths(positions1, healths1, directions1)
    print(f"Example 1: positions={positions1}, healths={healths1}, directions='{directions1}'")
    print(f"Output: {output1}")
    print(f"Expected: [2,17,9,15,10]")
    print()
    
    # Example 2
    positions2 = [3,5,2,6]
    healths2 = [10,10,15,12]
    directions2 = "RLRL"
    output2 = sol.survivedRobotsHealths(positions2, healths2, directions2)
    print(f"Example 2: positions={positions2}, healths={healths2}, directions='{directions2}'")
    print(f"Output: {output2}")
    print(f"Expected: [14]")
    print()
    
    # Example 3
    positions3 = [1,2,5,6]
    healths3 = [10,10,11,11]
    directions3 = "RLRL"
    output3 = sol.survivedRobotsHealths(positions3, healths3, directions3)
    print(f"Example 3: positions={positions3}, healths={healths3}, directions='{directions3}'")
    print(f"Output: {output3}")
    print(f"Expected: []")