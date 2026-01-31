from typing import List


class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        left, right = 0, len(letters) - 1
        while left <= right:
            mid = (left + right) // 2
            if letters[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return letters[left % len(letters)]


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    letters1 = ["c","f","j"]
    target1 = "a"
    output1 = solution.nextGreatestLetter(letters1, target1)
    print(f"Test 1: letters = {letters1}, target = \"{target1}\"")
    print(f"Output: \"{output1}\", Expected: \"c\"")
    
    # Test case 2
    letters2 = ["c","f","j"]
    target2 = "c"
    output2 = solution.nextGreatestLetter(letters2, target2)
    print(f"Test 2: letters = {letters2}, target = \"{target2}\"")
    print(f"Output: \"{output2}\", Expected: \"f\"")
    
    # Test case 3
    letters3 = ["x","x","y","y"]
    target3 = "z"
    output3 = solution.nextGreatestLetter(letters3, target3)
    print(f"Test 3: letters = {letters3}, target = \"{target3}\"")
    print(f"Output: \"{output3}\", Expected: \"x\"")
    
    print("\nTest cases executed!")
