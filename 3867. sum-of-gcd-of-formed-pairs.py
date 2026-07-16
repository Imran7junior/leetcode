from math import gcd


class Solution:
    def gcdSum(self, nums: list[int]) -> int:
        mx = 0

        for i in range(len(nums)):
            mx = max(mx, nums[i])
            nums[i] = gcd(mx, nums[i])

        nums.sort()

        left, right = 0, len(nums) - 1
        ans = 0

        while left < right:
            ans += gcd(nums[left], nums[right])
            left += 1
            right -= 1

        return ans


if __name__ == "__main__":
    sol = Solution()

    # Example 1
    nums = [2, 6, 4]
    print(sol.gcdSum(nums))  # 2

    # Example 2
    nums = [3, 6, 2, 8]
    print(sol.gcdSum(nums))  # 5