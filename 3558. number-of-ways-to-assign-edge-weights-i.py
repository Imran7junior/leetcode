from typing import List

class Solution:
    def assignEdgeWeights(self, edges: List[List[int]]) -> int:
        mod = 1_000_000_007
        n = len(edges) + 1
        graph = [[] for _ in range(n + 1)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        def dfs(node: int, prev: int) -> int:
            d = 0
            for c in graph[node]:
                if c != prev:
                    d = max(d, dfs(c, node) + 1)
            return d

        return pow(2, dfs(1, 0) - 1, mod)

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    edges1 = [[1,2]]
    output1 = sol.assignEdgeWeights(edges1)
    print(f"Example 1: edges={edges1}")
    print(f"Output: {output1}")
    print(f"Expected: 1")
    print()
    
    # Example 2
    edges2 = [[1,2],[1,3],[3,4],[3,5]]
    output2 = sol.assignEdgeWeights(edges2)
    print(f"Example 2: edges={edges2}")
    print(f"Output: {output2}")
    print(f"Expected: 2")