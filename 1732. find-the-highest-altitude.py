class Solution:
    def largestAltitude(self, gain):
        n = len(gain)
        mx = 0

        for i in range(n + 1):
            alt = 0
            for j in range(i):
                alt += gain[j]
            mx = max(mx, alt)

        return mx


if __name__ == "__main__":
    sol = Solution()

    print(sol.largestAltitude([-5, 1, 5, 0, -7]))  # Expected: 1
    print(sol.largestAltitude([-4, -3, -2, -1, 4, 3, 2]))  # Expected: 0