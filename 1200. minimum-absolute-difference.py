from typing import List


class Solution:
    def minimumAbsDifference(self, arr: List[int]):
        arr.sort()
        min_diff = min(b - a for a, b in zip(arr, arr[1:]))
        return [[a, b] for a, b in zip(arr, arr[1:]) if b - a == min_diff]


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    arr1 = [4,2,1,3]
    output1 = solution.minimumAbsDifference(arr1)
    print(f"Test 1: arr = [4,2,1,3]")
    print(f"Output: {output1}, Expected: [[1,2],[2,3],[3,4]]")
    
    # Test case 2
    arr2 = [1,3,6,10,15]
    output2 = solution.minimumAbsDifference(arr2)
    print(f"Test 2: arr = [1,3,6,10,15]")
    print(f"Output: {output2}, Expected: [[1,3]]")
    
    # Test case 3
    arr3 = [3,8,-10,23,19,-4,-14,27]
    output3 = solution.minimumAbsDifference(arr3)
    print(f"Test 3: arr = [3,8,-10,23,19,-4,-14,27]")
    print(f"Output: {output3}, Expected: [[-14,-10],[19,23],[23,27]]")
    
    print("\nTest cases executed!")
