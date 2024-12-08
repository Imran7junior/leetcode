import heapq

class Solution:
    def maxTwoEvents(self, events):
        events.sort()  # Sort by start time
        pq = []  # Priority queue to store (end_time, value)
        max_value = 0
        ans = 0
        
        for start, end, value in events:
            # Remove all events that end before the current event's start time
            while pq and pq[0][0] < start:
                max_value = max(max_value, heapq.heappop(pq)[1])
            
            # Update the maximum sum of values
            ans = max(ans, max_value + value)
            
            # Push the current event into the priority queue
            heapq.heappush(pq, (end, value))
        
        return ans