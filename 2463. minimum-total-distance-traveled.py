from typing import List
from collections import deque

class Solution:
    def minimumTotalDistance(self, robot: List[int], factory: List[List[int]]) -> int:
        # Sort positions to enable optimal matching
        robot.sort()
        factory.sort()
        
        m, n = len(robot), len(factory)
        # DP table initialization
        dp = [[0]*(n+1) for _ in range(m+1)]
        
        # Base case: if no factories left, distance is infinite
        for i in range(m): 
            dp[i][-1] = float('inf')
        
        # Process each factory from right to left
        for j in range(n-1, -1, -1):
            prefix = 0
            qq = deque([(m, 0)])
            
            # Process each robot from right to left
            for i in range(m-1, -1, -1):
                # Add distance to current factory
                prefix += abs(robot[i] - factory[j][0])
                
                # Remove elements outside factory limit window
                if qq[0][0] > i+factory[j][1]: 
                    qq.popleft()
                
                # Maintain monotonic queue property
                while qq and qq[-1][1] >= dp[i][j+1] - prefix:
                    qq.pop()
                    
                qq.append((i, dp[i][j+1] - prefix))
                dp[i][j] = qq[0][1] + prefix
                
        return dp[0][0]

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    robot1 = [0, 4, 6]
    factory1 = [[2, 2], [6, 2]]
    output1 = sol.minimumTotalDistance(robot1, factory1)
    print(f"Example 1: robot={robot1}, factory={factory1}")
    print(f"Output: {output1}")
    print(f"Expected: 4")
    print()
    
    # Example 2
    robot2 = [1, -1]
    factory2 = [[-2, 1], [2, 1]]
    output2 = sol.minimumTotalDistance(robot2, factory2)
    print(f"Example 2: robot={robot2}, factory={factory2}")
    print(f"Output: {output2}")
    print(f"Expected: 2")