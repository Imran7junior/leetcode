class Solution:
    def findDifferentBinaryString(self, nums):
        seen = set(nums)
        n = len(nums)

        for i in range(1 << n):  
            binary = format(i, '0' + str(n) + 'b')
            if binary not in seen:
                return binary
        return ""

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    nums = ["01","10"]
    output = sol.findDifferentBinaryString(nums)
    print(f"Example 1: Input: nums = {nums}")
    print(f"Output: {output}")
    print(f"Expected: '11' or '00'")
    print()
    
    # Example 2:
    nums = ["00","01"]
    output = sol.findDifferentBinaryString(nums)
    print(f"Example 2: Input: nums = {nums}")
    print(f"Output: {output}")
    print(f"Expected: '11' or '10'")
    print()
    
    # Example 3:
    nums = ["111","011","001"]
    output = sol.findDifferentBinaryString(nums)
    print(f"Example 3: Input: nums = {nums}")
    print(f"Output: {output}")
    print(f"Expected: '101' (or another valid binary string)")