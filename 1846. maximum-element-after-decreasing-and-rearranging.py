from typing import List

class Solution:
    def maximumElementAfterDecrementingAndRearranging(self, arr: List[int]) -> int:

        arr.sort()

        arr[0] = 1

        for i in range(1, len(arr)):
            arr[i] = min(arr[i], arr[i - 1] + 1)

        return arr[-1]


if __name__ == "__main__":
    sol = Solution()

    print(sol.maximumElementAfterDecrementingAndRearranging([2, 2, 1, 2, 1]))  # Expected: 2
    print(sol.maximumElementAfterDecrementingAndRearranging([100, 1, 1000]))    # Expected: 3
    print(sol.maximumElementAfterDecrementingAndRearranging([1, 2, 3, 4, 5]))   # Expected: 5