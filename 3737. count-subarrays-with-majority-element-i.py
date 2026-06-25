from typing import List

class Solution:
    def countMajoritySubarrays(self, nums: List[int], target: int) -> int:
        n = len(nums)
        ans = 0

        for l in range(n):
            target_count = 0

            for r in range(l, n):
                if nums[r] == target:
                    target_count += 1

                length = r - l + 1

                if target_count > length // 2:
                    ans += 1

        return ans


if __name__ == "__main__":
    sol = Solution()

    print(sol.countMajoritySubarrays([1, 2, 2, 3], 2))  # Expected: 5
    print(sol.countMajoritySubarrays([1, 1, 1, 1], 1))  # Expected: 10
    print(sol.countMajoritySubarrays([1, 2, 3], 4))     # Expected: 0