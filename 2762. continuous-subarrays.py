from heapq import heappush, heappop

class Solution:
    def continuousSubarrays(self, nums):
        cnt = 0
        l = 0
        r = 0
        max_heap = []  # Max-heap (negative values for max-heap simulation)
        min_heap = []  # Min-heap

        while r < len(nums):
            heappush(max_heap, (-nums[r], r))  # Push negative for max-heap
            heappush(min_heap, (nums[r], r))

            while max_heap and min_heap and (-max_heap[0][0] - min_heap[0][0]) > 2:
                l += 1
                while max_heap and max_heap[0][1] < l:
                    heappop(max_heap)
                while min_heap and min_heap[0][1] < l:
                    heappop(min_heap)

            cnt += (r - l + 1)
            r += 1
        
        return cnt