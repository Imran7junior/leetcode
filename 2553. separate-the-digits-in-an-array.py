class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        
        result = []

        for num in nums:

            s = str(num)

            for ch in s:

                result.append(int(ch))

        return result


# Test cases
if __name__ == "__main__":
    from typing import List
    
    solution = Solution()
    
    # Example 1
    nums1 = [13, 25, 83, 77]
    result1 = solution.separateDigits(nums1)
    print(f"Example 1: Input: nums = {nums1}")
    print(f"Output: {result1}")
    print(f"Expected: [1, 3, 2, 5, 8, 3, 7, 7]\n")
    
    # Example 2
    nums2 = [7, 1, 3, 9]
    result2 = solution.separateDigits(nums2)
    print(f"Example 2: Input: nums = {nums2}")
    print(f"Output: {result2}")
    print(f"Expected: [7, 1, 3, 9]")