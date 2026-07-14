from typing import List


class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: (x[0], -x[1]))

        count = 0
        max_end = 0

        for start, end in intervals:
            if end > max_end:
                count += 1
                max_end = end

        return count


if __name__ == "__main__":
    sol = Solution()

    # Example 1
    intervals = [[1, 4], [3, 6], [2, 8]]
    print(sol.removeCoveredIntervals(intervals))  # 2

    # Example 2
    intervals = [[1, 4], [2, 3]]
    print(sol.removeCoveredIntervals(intervals))  # 1