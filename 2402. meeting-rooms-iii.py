from typing import List
import heapq
class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        meetings.sort()

        available = [i for i in range(n)]
        used = [] # (end_time, room_number)
        count = [0] * n # count[n] = meetings schedule

        for start, end in meetings:
            # Finish meetings
            while used and start >= used[0][0]:
                _, room = heapq.heappop(used)
                heapq.heappush(available, room)
            # no room is available
            if not available:
                end_time, room = heapq.heappop(used)
                end = end_time + (end - start)
                heapq.heappush(available, room)
            
            room = heapq.heappop(available)
            heapq.heappush(used, (end, room))
            count[room] += 1

        return count.index(max(count))
# Test case
solution = Solution()
print(solution.mostBooked(2, [[0,10],[1,5],[2,7],[3,4]]))  # Output: 0
print(solution.mostBooked(3, [[1,20],[2,10],[3,5],[4,9],[6,8]]))  # Output: 1