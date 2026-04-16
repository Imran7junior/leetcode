from typing import List
from collections import defaultdict
from bisect import bisect_left

class Solution:
    def solveQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        n = len(nums)

        indices = defaultdict(list)  # num -> sorted indices
        for i, num in enumerate(nums):
            indices[num].append(i)

        result = []
        for q in queries:
            qind = indices[nums[q]]
            if len(qind) == 1:
                result.append(-1)
            else:
                j = bisect_left(qind, q)
                prev = qind[(j - 1) % len(qind)]
                nextt = qind[(j + 1) % len(qind)]
                result.append(min(
                    (nextt + n - qind[j]) % n,
                    (qind[j] - prev + n) % n,
                ))

        return result

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1 = [1,3,1,4,1,3,2]
    queries1 = [0,3,5]
    output1 = sol.solveQueries(nums1, queries1)
    print(f"Example 1: nums={nums1}, queries={queries1}")
    print(f"Output: {output1}")
    print(f"Expected: [2,-1,3]")
    print()
    
    # Example 2
    nums2 = [1,2,3,4]
    queries2 = [0,1,2,3]
    output2 = sol.solveQueries(nums2, queries2)
    print(f"Example 2: nums={nums2}, queries={queries2}")
    print(f"Output: {output2}")
    print(f"Expected: [-1,-1,-1,-1]")