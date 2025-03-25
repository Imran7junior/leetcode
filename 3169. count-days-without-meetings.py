class Solution:
    def countDays(self, days: int, meetings: list[list[int]]) -> int:
        meetings.sort()
        unvisited, temp = 0, 1
        for start, end in meetings:
            unvisited += max(0, start - temp)
            temp = max(temp, end + 1)
            if temp > days:
                break
        return unvisited + max(0, days - temp + 1)