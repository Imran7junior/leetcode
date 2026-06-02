class Solution:
    def calFinishTime(self, ls, ld, ws, wd):

        mini = float('inf')

        for i in range(len(ls)):
            mini = min(mini, ls[i] + ld[i])

        ans = float('inf')

        for i in range(len(ws)):
            ans = min(
                ans,
                max(mini, ws[i]) + wd[i]
            )

        return ans

    def earliestFinishTime(self, landStartTime: List[int], landDuration: List[int], waterStartTime: List[int], waterDuration: List[int]) -> int:
        return min(
            self.calFinishTime(landStartTime,landDuration,waterStartTime,waterDuration),
            self.calFinishTime(waterStartTime,waterDuration,landStartTime,landDuration)
        )

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    landStartTime1 = [2,8]
    landDuration1 = [4,1]
    waterStartTime1 = [6]
    waterDuration1 = [3]
    output1 = sol.earliestFinishTime(landStartTime1, landDuration1, waterStartTime1, waterDuration1)
    print(f"Example 1: landStartTime={landStartTime1}, landDuration={landDuration1}, waterStartTime={waterStartTime1}, waterDuration={waterDuration1}")
    print(f"Output: {output1}")
    print(f"Expected: 9")
    print()
    
    # Example 2
    landStartTime2 = [5]
    landDuration2 = [3]
    waterStartTime2 = [1]
    waterDuration2 = [10]
    output2 = sol.earliestFinishTime(landStartTime2, landDuration2, waterStartTime2, waterDuration2)
    print(f"Example 2: landStartTime={landStartTime2}, landDuration={landDuration2}, waterStartTime={waterStartTime2}, waterDuration={waterDuration2}")
    print(f"Output: {output2}")
    print(f"Expected: 14")