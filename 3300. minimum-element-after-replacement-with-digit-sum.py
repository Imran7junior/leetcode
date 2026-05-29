class Solution:
    def minElement(self, nums: list[int]) -> int:
        min_val = float('inf')
        
        for num in nums:
            current_sum = 0
            
            while num > 0:
                current_sum += num % 10
                num //= 10
            
            min_val = min(min_val, current_sum)
                
        return min_val

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1 = [10,12,13,14]
    output1 = sol.minElement(nums1)
    print(f"Example 1: nums={nums1}")
    print(f"Output: {output1}")
    print(f"Expected: 1")
    print()
    
    # Example 2
    nums2 = [1,2,3,4]
    output2 = sol.minElement(nums2)
    print(f"Example 2: nums={nums2}")
    print(f"Output: {output2}")
    print(f"Expected: 1")
    print()
    
    # Example 3
    nums3 = [999,19,199]
    output3 = sol.minElement(nums3)
    print(f"Example 3: nums={nums3}")
    print(f"Output: {output3}")
    print(f"Expected: 10")