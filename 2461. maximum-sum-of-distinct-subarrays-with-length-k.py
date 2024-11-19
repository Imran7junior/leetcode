class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        um = defaultdict(int)
        q = deque()
        l, r = 0, 0
        sum_val = 0
        last_sum = 0

        # Initialize the first window of size k
        for r in range(k):
            um[nums[r]] += 1
            last_sum += nums[r]

            if um[nums[r]] > 1:
                q.append(nums[r])

        # Slide the window across the array
        while r <= len(nums):
            if not q:
                sum_val = max(last_sum, sum_val)

            if q and q[0] == nums[l]:
                q.popleft()
            um[nums[l]] -= 1
            last_sum -= nums[l]
            l += 1

            if r < len(nums):
                um[nums[r]] += 1
                last_sum += nums[r]
                if um[nums[r]] > 1:
                    q.append(nums[r])
            r += 1

        return sum_val