from typing import List
from collections import defaultdict
import heapq
import math


class Solution:
    def minCost(self, n: int, edges: List[List[int]]) -> int:
        # Building augmented graph
        adj = defaultdict(list)
        for u, v, w in edges:
            adj[u].append((v, w))
            adj[v].append((u, 2 * w))  # Reverse edge

        # Initialize distance array from 0 node
        dist = [math.inf] * n
        dist[0] = 0

        # Dijkstra
        heap = [(0, 0)]
        while heap:
            d, u = heapq.heappop(heap)
            if u == n - 1:  # Early exit
                return d
            if d != dist[u]:  # Stale edge
                continue
            for v, w in adj[u]:
                if dist[u] + w < dist[v]:  # Edge relaxation
                    dist[v] = dist[u] + w
                    heapq.heappush(heap, (dist[v], v))

        # No path found
        return -1


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    n1 = 4
    edges1 = [[0,1,3],[3,1,1],[2,3,4],[0,2,2]]
    output1 = solution.minCost(n1, edges1)
    print(f"Test 1: n = {n1}, edges = {edges1}")
    print(f"Output: {output1}, Expected: 5")
    
    # Test case 2
    n2 = 4
    edges2 = [[0,2,1],[2,1,1],[1,3,1],[2,3,3]]
    output2 = solution.minCost(n2, edges2)
    print(f"Test 2: n = {n2}, edges = {edges2}")
    print(f"Output: {output2}, Expected: 3")
    
    print("\nTest cases executed!")
