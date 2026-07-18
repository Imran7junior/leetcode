from typing import List


class Solution:
    def gcd(self, a, b):
        while b:
            a, b = b, a % b

        return a

    def findGCD(self, nums: List[int]) -> int:
        minimum = min(nums)
        maximum = max(nums)

        return self.gcd(minimum, maximum)


if __name__ == "__main__":
    sol = Solution()

    # Example 1
    nums = [2, 5, 6, 9, 10]
    print(sol.findGCD(nums))  # 2

    # Example 2
    nums = [7, 5, 6, 8, 3]
    print(sol.findGCD(nums))  # 1

    # Example 3
    nums = [3, 3]
    print(sol.findGCD(nums))  # 3