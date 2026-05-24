class Solution:
    def maxJumps(self, arr: list[int], d: int) -> int:
        n = len(arr)
        dp = [-1] * n

        def dfs(i):
            if dp[i] != -1:
                return dp[i]

            best = 1

            # Right scan
            for nxt in range(i + 1, min(n, i + d + 1)):
                if arr[nxt] >= arr[i]:
                    break

                best = max(best, 1 + dfs(nxt))

            # Left scan
            for nxt in range(i - 1, max(-1, i - d - 1), -1):
                if arr[nxt] >= arr[i]:
                    break

                best = max(best, 1 + dfs(nxt))

            dp[i] = best
            return dp[i]

        return max(dfs(i) for i in range(n))

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    arr1 = [6,4,14,6,8,13,9,7,10,6,12]
    d1 = 2
    output1 = sol.maxJumps(arr1, d1)
    print(f"Example 1: arr={arr1}, d={d1}")
    print(f"Output: {output1}")
    print(f"Expected: 4")
    print()
    
    # Example 2
    arr2 = [3,3,3,3,3]
    d2 = 3
    output2 = sol.maxJumps(arr2, d2)
    print(f"Example 2: arr={arr2}, d={d2}")
    print(f"Output: {output2}")
    print(f"Expected: 1")
    print()
    
    # Example 3
    arr3 = [7,6,5,4,3,2,1]
    d3 = 1
    output3 = sol.maxJumps(arr3, d3)
    print(f"Example 3: arr={arr3}, d={d3}")
    print(f"Output: {output3}")
    print(f"Expected: 7")