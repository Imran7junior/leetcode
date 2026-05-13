class Solution:
    def minMoves(self, nums: List[int], limit: int) -> int:
        n = len(nums)

        # difference array
        diff = [0] * (2 * limit + 2)

        for i in range(n // 2):
            a = nums[i]
            b = nums[n - 1 - i]

            low = min(a, b) + 1
            high = max(a, b) + limit

            total = a + b

            # initially all sums need 2 moves
            diff[2] += 2
            diff[2 * limit + 1] -= 2

            # one move range
            diff[low] -= 1
            diff[high + 1] += 1

            # exact sum needs 0 move
            diff[total] -= 1
            diff[total + 1] += 1

        ans = float('inf')
        moves = 0

        # calculate prefix sum
        for target in range(2, 2 * limit + 1):
            moves += diff[target]
            ans = min(ans, moves)

        return ans


# Test cases
if __name__ == "__main__":
    from typing import List
    
    solution = Solution()
    
    # Example 1
    nums1 = [1, 2, 4, 3]
    limit1 = 4
    result1 = solution.minMoves(nums1, limit1)
    print(f"Example 1: Input: nums = {nums1}, limit = {limit1}")
    print(f"Output: {result1}")
    print(f"Expected: 1\n")
    
    # Example 2
    nums2 = [1, 2, 2, 1]
    limit2 = 2
    result2 = solution.minMoves(nums2, limit2)
    print(f"Example 2: Input: nums = {nums2}, limit = {limit2}")
    print(f"Output: {result2}")
    print(f"Expected: 2\n")
    
    # Example 3
    nums3 = [1, 2, 1, 2]
    limit3 = 2
    result3 = solution.minMoves(nums3, limit3)
    print(f"Example 3: Input: nums = {nums3}, limit = {limit3}")
    print(f"Output: {result3}")
    print(f"Expected: 0")