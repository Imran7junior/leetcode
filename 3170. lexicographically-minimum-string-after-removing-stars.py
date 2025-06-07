class Solution(object):
    def clearStars(self, s):
        s_list = list(s)
        pos = [[] for _ in range(26)]
        heap = []
        for i, c in enumerate(s_list):
            if c == '*':
                smallest = heap[0]
                idx = pos[ord(smallest) - 97].pop()
                s_list[idx] = '*'
                if not pos[ord(smallest) - 97]:
                    heapq.heappop(heap)
            else:
                ci = ord(c) - 97
                if not pos[ci]:
                    heapq.heappush(heap, c)
                pos[ci].append(i)
        return ''.join(ch for ch in s_list if ch != '*')