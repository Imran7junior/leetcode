from typing import List


class Solution:
    MOD = 10**9 + 7

    def modPow(self, a, b):
        ans = 1

        while b > 0:
            if b & 1:
                ans = (ans * a) % self.MOD

            a = (a * a) % self.MOD
            b >>= 1

        return ans


if __name__ == "__main__":
    sol = Solution()

    # Example 1
    edges1 = [[1,2]]
    queries1 = [[1,1],[1,2]]
    out1 = sol.assignEdgeWeights(edges1, queries1)
    print(f"Example 1: edges={edges1}, queries={queries1}")
    print(f"Output: {out1}")
    print(f"Expected: [0, 1]")
    print()

    # Example 2
    edges2 = [[1,2],[1,3],[3,4],[3,5]]
    queries2 = [[1,4],[3,4],[2,5]]
    out2 = sol.assignEdgeWeights(edges2, queries2)
    print(f"Example 2: edges={edges2}, queries={queries2}")
    print(f"Output: {out2}")
    print(f"Expected: [2, 1, 4]")

    def dfs(self, node, parent):
        self.up[node][0] = parent

        for j in range(1, self.LOG):
            self.up[node][j] = self.up[self.up[node][j - 1]][j - 1]

        for neighbour in self.adj[node]:
            if neighbour == parent:
                continue

            self.depth[neighbour] = self.depth[node] + 1
            self.dfs(neighbour, node)

    def lca(self, u, v):
        if self.depth[u] < self.depth[v]:
            u, v = v, u

        diff = self.depth[u] - self.depth[v]

        for j in range(self.LOG - 1, -1, -1):
            if diff & (1 << j):
                u = self.up[u][j]

        if u == v:
            return u

        for j in range(self.LOG - 1, -1, -1):
            if self.up[u][j] != self.up[v][j]:
                u = self.up[u][j]
                v = self.up[v][j]

        return self.up[u][0]

    def assignEdgeWeights(self, edges: List[List[int]], queries: List[List[int]]) -> List[int]:
        n = len(edges) + 1

        self.LOG = 1
        while (1 << self.LOG) <= n:
            self.LOG += 1

        self.adj = [[] for _ in range(n + 1)]

        for u, v in edges:
            self.adj[u].append(v)
            self.adj[v].append(u)

        self.depth = [0] * (n + 1)
        self.up = [[0] * self.LOG for _ in range(n + 1)]

        self.dfs(1, 0)

        ans = []

        for u, v in queries:
            L = self.lca(u, v)

            dist = self.depth[u] + self.depth[v] - 2 * self.depth[L]

            if dist == 0:
                ans.append(0)
            else:
                ans.append(self.modPow(2, dist - 1))

        return ans