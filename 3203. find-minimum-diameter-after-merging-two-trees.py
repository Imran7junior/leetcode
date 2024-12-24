class Solution:
    def build(self, adj, edges):
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

    def get(self, p, adj, node, dis, vis):
        d = p[1]
        vis[node] = True
        if dis > d:
            p[0], p[1] = node, dis
        for neighbor in adj[node]:
            if not vis[neighbor]:
                self.get(p, adj, neighbor, dis + 1, vis)

    def minimumDiameterAfterMerge(self, edges1, edges2):
        n = len(edges1) + 1
        m = len(edges2) + 1
        adj1 = [[] for _ in range(n)]
        adj2 = [[] for _ in range(m)]

        self.build(adj1, edges1)
        self.build(adj2, edges2)

        p1 = [-1, float('-inf')]
        vis = [False] * n
        self.get(p1, adj1, 0, 0, vis)

        p2 = [-1, float('-inf')]
        vis = [False] * n
        self.get(p2, adj1, p1[0], 0, vis)
        d1 = p2[1]

        p1 = [-1, float('-inf')]
        vis = [False] * m
        self.get(p1, adj2, 0, 0, vis)

        p2 = [-1, float('-inf')]
        vis = [False] * m
        self.get(p2, adj2, p1[0], 0, vis)
        d2 = p2[1]

        if not edges1:
            d1 = 0
        if not edges2:
            d2 = 0

        return max(d1, d2, (d1 + 1) // 2 + (d2 + 1) // 2 + 1)