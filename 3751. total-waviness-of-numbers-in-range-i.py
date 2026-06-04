class Solution:
    def waviness(self, x: int) -> int:
        s = str(x)

        cnt = 0

        for i in range(1, len(s) - 1):
            if ((s[i] > s[i - 1] and s[i] > s[i + 1]) or
                (s[i] < s[i - 1] and s[i] < s[i + 1])):
                cnt += 1

        return cnt

    def totalWaviness(self, num1: int, num2: int) -> int:
        ans = 0

        for x in range(num1, num2 + 1):
            ans += self.waviness(x)

        return ans

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    num1_1 = 120
    num2_1 = 130
    output1 = sol.totalWaviness(num1_1, num2_1)
    print(f"Example 1: num1={num1_1}, num2={num2_1}")
    print(f"Output: {output1}")
    print(f"Expected: 3")
    print()
    
    # Example 2
    num1_2 = 198
    num2_2 = 202
    output2 = sol.totalWaviness(num1_2, num2_2)
    print(f"Example 2: num1={num1_2}, num2={num2_2}")
    print(f"Output: {output2}")
    print(f"Expected: 3")
    print()
    
    # Example 3
    num1_3 = 4848
    num2_3 = 4848
    output3 = sol.totalWaviness(num1_3, num2_3)
    print(f"Example 3: num1={num1_3}, num2={num2_3}")
    print(f"Output: {output3}")
    print(f"Expected: 2")