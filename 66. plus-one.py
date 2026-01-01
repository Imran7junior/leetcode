from typing import List

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        # Start from the rightmost digit
        n = len(digits)
        
        for i in range(n - 1, -1, -1):
            # If current digit is less than 9, just increment and return
            if digits[i] < 9:
                digits[i] += 1
                return digits
            
            # Otherwise, set it to 0 and continue (carry over)
            digits[i] = 0
        
        return [1] + digits


# Test cases
solution = Solution()

# Test 1
digits1 = [1, 2, 3]
result1 = solution.plusOne(digits1)
print(f"Test 1: digits={[1,2,3]} -> {result1}, Expected: [1,2,4]")

# Test 2
digits2 = [4, 3, 2, 1]
result2 = solution.plusOne(digits2)
print(f"Test 2: digits={[4,3,2,1]} -> {result2}, Expected: [4,3,2,2]")

# Test 3: Single digit
digits4 = [9]
result4 = solution.plusOne(digits4)
print(f"Test 4: digits={[9]} -> {result4}, Expected: [1,0]")