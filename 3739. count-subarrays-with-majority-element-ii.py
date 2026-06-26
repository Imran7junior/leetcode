class Solution:
    def countMajoritySubarrays(self, nums, target):
        n = len(nums)
        cnt = 0

        for i in range(n):
            if nums[i] == target:
                nums[i] = 1
            else:
                nums[i] = -1

        pref = [0] * n
        pref[0] = nums[0]

        for i in range(1, n):
            pref[i] = pref[i - 1] + nums[i]

        shift = n
        freq = [0] * (2 * n + 1)

        freq[shift] = 1

        valid = 0
        lastSum = 0

        for i in range(n):
            if pref[i] > lastSum:
                valid += freq[lastSum + shift]
            else:
                valid -= freq[pref[i] + shift]

            cnt += valid
            freq[pref[i] + shift] += 1
            lastSum = pref[i]

        return cnt


if __name__ == "__main__":
    sol = Solution()

    print(sol.countMajoritySubarrays([1, 2, 2, 3], 2))  # Expected: 5
    print(sol.countMajoritySubarrays([1, 1, 1, 1], 1))  # Expected: 10
    print(sol.countMajoritySubarrays([1, 2, 3], 4))     # Expected: 0