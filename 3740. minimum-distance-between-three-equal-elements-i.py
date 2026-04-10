from typing import List

class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        pos = {}
        
        for i, num in enumerate(nums):
            if num not in pos:
                pos[num] = []
            pos[num].append(i)
        
        ans = float('inf')
        
        for indices in pos.values():
            if len(indices) < 3:
                continue
            
            for i in range(len(indices) - 2):
                distance = 2 * (indices[i + 2] - indices[i])
                ans = min(ans, distance)
        
        return -1 if ans == float('inf') else ans

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1 = [1,2,1,1,3]
    output1 = sol.minimumDistance(nums1)
    print(f"Example 1: nums={nums1}")
    print(f"Output: {output1}")
    print(f"Expected: 6")
    print()
    
    # Example 2
    nums2 = [1,1,2,3,2,1,2]
    output2 = sol.minimumDistance(nums2)
    print(f"Example 2: nums={nums2}")
    print(f"Output: {output2}")
    print(f"Expected: 8")
    print()
    
    # Example 3
    nums3 = [1]
    output3 = sol.minimumDistance(nums3)
    print(f"Example 3: nums={nums3}")
    print(f"Output: {output3}")
    print(f"Expected: -1")