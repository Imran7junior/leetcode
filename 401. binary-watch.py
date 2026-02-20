class Solution:
    def readBinaryWatch(self, turnedOn: int) -> list[str]:

        if turnedOn > 8: return []
        ans = []
        
        for hour in range(12):
            for minute in range(60):
                if hour.bit_count() + minute.bit_count() == turnedOn:
                    ans.append(f"{hour}:{minute:02d}")

        return ans

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    turnedOn = 1
    output = sol.readBinaryWatch(turnedOn)
    print(f"Example 1: Input: turnedOn = {turnedOn}")
    print(f"Output: {output}")
    print(f"Expected: ['0:01','0:02','0:04','0:08','0:16','0:32','1:00','2:00','4:00','8:00']")
    print()
    
    # Example 2:
    turnedOn = 9
    output = sol.readBinaryWatch(turnedOn)
    print(f"Example 2: Input: turnedOn = {turnedOn}")
    print(f"Output: {output}")
    print(f"Expected: []")
        