#translated using AI
class Solution:
    def xorAfterQueries(self, nums, queries):
        MOD = 10**9 + 7

        for l, r, k, v in queries:
            i = l
            while i <= r:
                nums[i] = (nums[i] * v) % MOD
                i += k

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