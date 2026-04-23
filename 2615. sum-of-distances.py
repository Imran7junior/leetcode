class Solution:
    def distance(self, nums: List[int]) -> List[int]:
        num_indices = dict()
        occ=dict()
        for i, num in enumerate(nums):
            if num not in num_indices:
                num_indices[num] = i
                occ[num]=1
            else:
                num_indices[num]=num_indices[num]+i
                occ[num]=occ[num]+1
        arr = [0] * len(nums)
        n=len(nums)
        for i in range(n):
            arr[i] = num_indices[nums[i]] - occ[nums[i]]*i     
            num_indices[nums[i]]=num_indices[nums[i]]-2*i
            occ[nums[i]]=occ[nums[i]]-2
            
        return arr

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1 = [1,3,1,1,2]
    output1 = sol.distance(nums1)
    print(f"Example 1: nums={nums1}")
    print(f"Output: {output1}")
    print(f"Expected: [5,0,3,4,0]")
    print()
    
    # Example 2
    nums2 = [0,5,3]
    output2 = sol.distance(nums2)
    print(f"Example 2: nums={nums2}")
    print(f"Output: {output2}")
    print(f"Expected: [0,0,0]")
        