class Solution:
    def sumFourDivisors(self, nums: list[int]) -> int:
        res = 0
        for n in nums:
            val = self.sumOne(n)
            if val != -1:
                res += val
        return res

    def sumOne(self, n: int) -> int:
        p = round(n ** (1/3))
        if p ** 3 == n and self.isPrime(p):
            return 1 + p + p*p + p*p*p

        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                a, b = i, n // i
                if a != b and self.isPrime(a) and self.isPrime(b):
                    return 1 + a + b + n
                return -1
        return -1

    def isPrime(self, x: int) -> bool:
        if x < 2:
            return False
        for i in range(2, int(x ** 0.5) + 1):
            if x % i == 0:
                return False
        return True
# Example usage
sol = Solution()
print(sol.sumFourDivisors([21,4,7]))  # Output: 32
print(sol.sumFourDivisors([1,2,3,4,5])) # Output: 0
print(sol.sumFourDivisors([21,21]))  # Output: 64
