from typing import List

class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        MOD = 10**9 + 7
        n = len(board)

        next_score = [-1] * (n + 1)
        next_ways = [0] * (n + 1)

        for i in range(n - 1, -1, -1):
            curr_score = [-1] * (n + 1)
            curr_ways = [0] * (n + 1)

            for j in range(n - 1, -1, -1):
                cell = board[i][j]

                if cell == 'X':
                    continue

                if cell == 'S':
                    curr_score[j] = 0
                    curr_ways[j] = 1
                    continue

                best = max(
                    next_score[j],
                    curr_score[j + 1],
                    next_score[j + 1]
                )

                if best == -1:
                    continue

                ways = 0

                if next_score[j] == best:
                    ways += next_ways[j]
                if curr_score[j + 1] == best:
                    ways += curr_ways[j + 1]
                if next_score[j + 1] == best:
                    ways += next_ways[j + 1]

                value = 0 if cell == 'E' else int(cell)

                curr_score[j] = best + value
                curr_ways[j] = ways % MOD

            next_score = curr_score
            next_ways = curr_ways

        if next_score[0] == -1:
            return [0, 0]

        return [next_score[0], next_ways[0]]


if __name__ == "__main__":
    sol = Solution()

    print(sol.pathsWithMaxScore([
        "E23",
        "2X2",
        "12S"
    ]))  # Expected: [7, 1]

    print(sol.pathsWithMaxScore([
        "E12",
        "1X1",
        "21S"
    ]))  # Expected: [4, 2]

    print(sol.pathsWithMaxScore([
        "E11",
        "XXX",
        "11S"
    ]))  # Expected: [0, 0]