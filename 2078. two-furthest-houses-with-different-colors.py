from typing import List

class Solution:
    def maxDistance(self, colors: List[int]) -> int:
        n=len(colors)
        c0, cN=colors[0], colors[-1]
        lMax, rMax=0, 0
        for i, c in enumerate(colors):
            if c0!=c: lMax=max(lMax, i)
            if cN!=c: rMax=max(rMax, n-1-i)
        return max(lMax, rMax)

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    colors1 = [1,1,1,6,1,1,1]
    output1 = sol.maxDistance(colors1)
    print(f"Example 1: colors={colors1}")
    print(f"Output: {output1}")
    print(f"Expected: 3")
    print()
    
    # Example 2
    colors2 = [1,8,3,8,3]
    output2 = sol.maxDistance(colors2)
    print(f"Example 2: colors={colors2}")
    print(f"Output: {output2}")
    print(f"Expected: 4")
    print()
    
    # Example 3
    colors3 = [0,1]
    output3 = sol.maxDistance(colors3)
    print(f"Example 3: colors={colors3}")
    print(f"Output: {output3}")
    print(f"Expected: 1")