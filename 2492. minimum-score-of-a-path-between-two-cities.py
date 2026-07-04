class Solution:
    def minScore(self, n: int, roads: list[list[int]]) -> int:
        root = list(range(n + 1))

        def find(i: int) -> int:
            root[i] = find(root[i]) if root[i] != i else i
            return root[i]

        for x, y, _ in roads:
            root[find(x)] = find(y)

        res, g1 = 10001, find(1)
        for x, _, d in roads:
            if find(x) == g1:
                res = min(res, d)

        return res


if __name__ == "__main__":
    sol = Solution()

    print(sol.minScore(
        4,
        [
            [1, 2, 9],
            [2, 3, 6],
            [2, 4, 5],
            [1, 4, 7]
        ]
    ))  # Expected: 5

    print(sol.minScore(
        4,
        [
            [1, 2, 2],
            [1, 3, 4],
            [3, 4, 7]
        ]
    ))  # Expected: 2