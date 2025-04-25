class Solution:
    def countInterestingSubarrays(self, nums, modulo, k):
        from collections import defaultdict
        cnt = defaultdict(int)
        cnt[0] = 1
        prefix = res = 0
        for num in nums:
            prefix += (num % modulo == k)
            res += cnt[(prefix - k) % modulo]
            cnt[prefix % modulo] += 1
        return res