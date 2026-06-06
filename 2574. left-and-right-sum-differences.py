class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        right_sum = sum(nums)

        left_sum = 0
        result = []

        for num in nums:
            right_sum -= num
            result.append(abs(left_sum - right_sum))
            left_sum += num

        return result

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1 = [10,4,8,3]
    output1 = sol.leftRightDifference(nums1)
    print(f"Example 1: nums={nums1}")
    print(f"Output: {output1}")
    print(f"Expected: [15,1,11,22]")
    print()
    
    # Example 2
    nums2 = [1]
    output2 = sol.leftRightDifference(nums2)
    print(f"Example 2: nums={nums2}")
    print(f"Output: {output2}")
    print(f"Expected: [0]")