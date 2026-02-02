from typing import List
from math import inf
from heapq import heappop, heappush, heapreplace


class Solution:
    def minimumCost(self, nums: List[int], k: int, dist: int) -> int:
        heap_used, heap_unused, used = [], [], set()
        s, ans = 0, inf
        for right in range(1, len(nums)):
            left = right - dist - 1

            # Move the left border of the window
            if left > 0 and left in used:
                    # If the left element was used in calculating the cost, then we delete it
                used.remove(left)
                s -= nums[left]

                    # Find the smallest unused element within the window boundary
                while heap_unused and heap_unused[0][1] < left:
                    heappop(heap_unused)

                if heap_unused: # If it exists, use it to calculate the cost
                    num, i = heappop(heap_unused)
                    heappush(heap_used, (-num, i))
                    used.add(i)
                    s += num

            # Move the right border of the window
            if len(used) < k - 1:
                # If less than k-1 elements are used, use the added element to calculate the cost
                heappush(heap_used, (-nums[right], right))
                used.add(right)
                s += nums[right]
            else:
                    #Find the largest used element
                while heap_used[0][1] not in used:
                    heappop(heap_used)
                
                if nums[right] < -heap_used[0][0]:
                        # If it is larger than the element being added to the window, replace it
                    num, i = heapreplace(heap_used, (-nums[right], right))
                    used.remove(i)
                    used.add(right)
                    s += num + nums[right]

                        # Add the vacated element to the unused element heap
                    heappush(heap_unused, (-num, i))
                else:
                    # If the element being added to the window is larger than the largest used element, 
                    # place it on the unused element heap
                    heappush(heap_unused, (nums[right], right))

            if left >= 0:
                ans = min(s, ans)

        return nums[0] + ans


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    nums1 = [1,3,2,6,4,2]
    k1 = 3
    dist1 = 3
    output1 = solution.minimumCost(nums1, k1, dist1)
    print(f"Test 1: nums = {nums1}, k = {k1}, dist = {dist1}")
    print(f"Output: {output1}, Expected: 5")
    
    # Test case 2
    nums2 = [10,1,2,2,2,1]
    k2 = 4
    dist2 = 3
    output2 = solution.minimumCost(nums2, k2, dist2)
    print(f"Test 2: nums = {nums2}, k = {k2}, dist = {dist2}")
    print(f"Output: {output2}, Expected: 15")
    
    # Test case 3
    nums3 = [10,8,18,9]
    k3 = 3
    dist3 = 1
    output3 = solution.minimumCost(nums3, k3, dist3)
    print(f"Test 3: nums = {nums3}, k = {k3}, dist = {dist3}")
    print(f"Output: {output3}, Expected: 36")
    
    print("\nTest cases executed!")
