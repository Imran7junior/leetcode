from typing import List

class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:

        digits = "123456789"

        ans = []

        min_len = len(str(low))
        max_len = len(str(high))

        for length in range(min_len, max_len + 1):

            for start in range(10 - length):

                num = int(digits[start:start + length])

                if low <= num <= high:
                    ans.append(num)

        return ans


if __name__ == "__main__":
    sol = Solution()

    print(sol.sequentialDigits(
        100, 300
    ))  # Expected: [123, 234]

    print(sol.sequentialDigits(
        1000, 13000
    ))  # Expected: [1234, 2345, 3456, 4567, 5678, 6789, 12345]