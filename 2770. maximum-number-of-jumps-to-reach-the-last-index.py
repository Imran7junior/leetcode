class Solution:
    def maximumJumps(self, nums, target):

        n = len(nums)

        # dp[i] stores maximum jumps to reach index i
        dp = [-1] * n

        # Starting index needs 0 jumps
        dp[0] = 0

        for i in range(1, n):

            # Check all previous indices
            for j in range(i):

                # Valid jump and previous index reachable
                if abs(nums[i] - nums[j]) <= target and dp[j] != -1:

                    # Update maximum jumps
                    dp[i] = max(dp[i], dp[j] + 1)

        return dp[-1]


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Example 1
    nums1 = [1, 3, 6, 4, 1, 2]
    target1 = 2
    result1 = solution.maximumJumps(nums1, target1)
    print(f"Example 1: Input: nums = {nums1}, target = {target1}")
    print(f"Output: {result1}")
    print(f"Expected: 3\n")
    
    # Example 2
    nums2 = [1, 3, 6, 4, 1, 2]
    target2 = 3
    result2 = solution.maximumJumps(nums2, target2)
    print(f"Example 2: Input: nums = {nums2}, target = {target2}")
    print(f"Output: {result2}")
    print(f"Expected: 5\n")
    
    # Example 3
    nums3 = [1, 3, 6, 4, 1, 2]
    target3 = 0
    result3 = solution.maximumJumps(nums3, target3)
    print(f"Example 3: Input: nums = {nums3}, target = {target3}")
    print(f"Output: {result3}")
    print(f"Expected: -1")