from typing import List
from collections import defaultdict
import math

class Solution:
    def xorAfterQueries(self, nums: List[int], queries: List[List[int]]) -> int:
        n = len(nums)
        MOD = 10**9 + 7
        limit = math.isqrt(n)
        
        # Group queries with small k for later processing
        lightK = defaultdict(list)
        
        for q in queries:
            l, r, k, v = q
            
            if k >= limit:
                # Large k: apply brute force
                for i in range(l, r + 1, k):
                    nums[i] = (nums[i] * v) % MOD
            else:
                # Small k: process later
                lightK[k].append(q)
                
        for k, query_list in lightK.items():
            # Process small queries grouped by step size k
            diff = [1] * n
            
            for q in query_list:
                l, r, _, v = q
                
                # Multiply starting position
                diff[l] = (diff[l] * v) % MOD
                
                # Cancel the multiplication using modular inverse
                steps = (r - l) // k
                nxt = l + (steps + 1) * k
                if nxt < n:
                    # pow(v, -1, MOD) computes the modular inverse natively
                    diff[nxt] = (diff[nxt] * pow(v, -1, MOD)) % MOD
                    
            # Propagate the multipliers with a step size of k
            for i in range(n):
                if i >= k:
                    diff[i] = (diff[i] * diff[i - k]) % MOD
                nums[i] = (nums[i] * diff[i]) % MOD
                
        ans = 0
        for num in nums:
            ans ^= num
            
        return ans

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1 = [1,1,1]
    queries1 = [[0,2,1,4]]
    output1 = sol.xorAfterQueries(nums1, queries1)
    print(f"Example 1: nums=[1,1,1], queries=[[0,2,1,4]]")
    print(f"Output: {output1}")
    print(f"Expected: 4")
    print()
    
    # Example 2
    nums2 = [2,3,1,5,4]
    queries2 = [[1,4,2,3],[0,2,1,2]]
    output2 = sol.xorAfterQueries(nums2, queries2)
    print(f"Example 2: nums=[2,3,1,5,4], queries=[[1,4,2,3],[0,2,1,2]]")
    print(f"Output: {output2}")
    print(f"Expected: 31")