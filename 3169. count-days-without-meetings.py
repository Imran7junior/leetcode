class Solution:
    def countDays(self, days: int, nums: list[list[int]]) -> int:
        visited = [False] * days
        for start, end in nums:
            for j in range(start, end + 1):
                visited[j - 1] = True
        return visited.count(False)