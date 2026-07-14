from collections import deque


class Solution:
    def countCompleteComponents(self, n: int, edges: list[list[int]]) -> int:
        adj = [[] for _ in range(n)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        vis = [False] * n
        ans = 0

        def bfs(node):
            q = deque([node])
            vis[node] = True
            comp = []

            while q:
                cur = q.popleft()
                comp.append(cur)

                for neighbor in adj[cur]:
                    if not vis[neighbor]:
                        vis[neighbor] = True
                        q.append(neighbor)

            return comp

        for i in range(n):
            if not vis[i]:
                comp = bfs(i)

                if all(len(adj[node]) == len(comp) - 1 for node in comp):
                    ans += 1

        return ans


if __name__ == "__main__":
    sol = Solution()

    # Example 1
    n = 6
    edges = [[0, 1], [0, 2], [1, 2], [3, 4]]
    print(sol.countCompleteComponents(n, edges))  # 3

    # Example 2
    n = 6
    edges = [[0, 1], [0, 2], [1, 2], [3, 4], [3, 5]]
    print(sol.countCompleteComponents(n, edges))  # 1