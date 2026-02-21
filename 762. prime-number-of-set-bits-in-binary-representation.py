class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        count = 0
        
        for i in range(left, right + 1):
            setBits = bin(i).count('1')  # Convert to binary and count '1's
            if self.isPrime(setBits):
                count += 1
        
        return count
    
    def isPrime(self, n: int) -> bool:
        if n <= 1:
            return False
        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                return False
        return True

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    left = 6
    right = 10
    output = sol.countPrimeSetBits(left, right)
    print(f"Example 1: Input: left = {left}, right = {right}")
    print(f"Output: {output}")
    print(f"Expected: 4")
    print()
    
    # Example 2:
    left = 10
    right = 15
    output = sol.countPrimeSetBits(left, right)
    print(f"Example 2: Input: left = {left}, right = {right}")
    print(f"Output: {output}")
    print(f"Expected: 5")