import math

class Solution:
    def minNumberOfSeconds(self, height: int, times: list[int]) -> int:
        lo, hi = 1, 10**16

        while lo < hi:
            mid = (lo + hi) >> 1
            tot = 0
            for t in times:
                tot += int(math.sqrt(mid / t * 2 + 0.25) - 0.5)
                if tot >= height: break
            if tot >= height:
                hi = mid
            else:
                lo = mid + 1

        return lo

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    height = 4
    times = [2,1,1]
    output = sol.minNumberOfSeconds(height, times)
    print(f"Example 1: Input: mountainHeight = {height}, workerTimes = {times}")
    print(f"Output: {output}")
    print(f"Expected: 3")
    print()
    
    # Example 2:
    height = 10
    times = [3,2,2,4]
    output = sol.minNumberOfSeconds(height, times)
    print(f"Example 2: Input: mountainHeight = {height}, workerTimes = {times}")
    print(f"Output: {output}")
    print(f"Expected: 12")
    print()
    
    # Example 3:
    height = 5
    times = [1]
    output = sol.minNumberOfSeconds(height, times)
    print(f"Example 3: Input: mountainHeight = {height}, workerTimes = {times}")
    print(f"Output: {output}")
    print(f"Expected: 15")