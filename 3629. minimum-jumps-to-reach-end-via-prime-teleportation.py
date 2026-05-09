class Solution:
    N = 10**6 + 5
    prime = [True] * N
    prime[0] = prime[1] = False
    
    for i in range(2, 1001):
        if prime[i]:
            for j in range(i * i, N, i):
                prime[j] = False

    def minJumps(self, nums: List[int]) -> int:
        n = len(nums)
        limit = nums[0]
        for c in nums:
            limit = max(limit, c)

        head = [-1] * (limit + 1)
        nxt = [-1] * n
        for i in range(n):
            val = nums[i]
            nxt[i] = head[val]
            head[val] = i

        dp = [-1] * n
        dp[0] = 0
        queue = deque([0])
        seen = set()

        while queue:
            dq = queue.popleft()

            if dq == n - 1:
                return dp[dq]

            right = dq + 1
            if right < n and dp[right] == -1:
                dp[right] = dp[dq] + 1
                queue.append(right)

            left = dq - 1
            if left >= 0 and dp[left] == -1:
                dp[left] = dp[dq] + 1
                queue.append(left)

            val = nums[dq]
            if Solution.prime[val] and val not in seen:
                seen.add(val)
                for i in range(val, limit + 1, val):
                    j = head[i]
                    while j != -1:
                        if dp[j] == -1:
                            dp[j] = dp[dq] + 1
                            queue.append(j)
                        j = nxt[j]
                    head[i] = -1
        return -1


# Test cases
if __name__ == "__main__":
    from typing import List
    from collections import deque
    
    solution = Solution()
    
    # Example 1
    nums1 = [1, 2, 4, 6]
    result1 = solution.minJumps(nums1)
    print(f"Example 1: Input: nums = {nums1}")
    print(f"Output: {result1}")
    print(f"Expected: 2\n")
    
    # Example 2
    nums2 = [2, 3, 4, 7, 9]
    result2 = solution.minJumps(nums2)
    print(f"Example 2: Input: nums = {nums2}")
    print(f"Output: {result2}")
    print(f"Expected: 2\n")
    
    # Example 3
    nums3 = [4, 6, 5, 8]
    result3 = solution.minJumps(nums3)
    print(f"Example 3: Input: nums = {nums3}")
    print(f"Output: {result3}")
    print(f"Expected: 3")