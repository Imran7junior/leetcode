class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        n = len(A)
        result = [0] * n
        count = [0] * (n + 1)
        common = 0
        
        for i in range(n):
            count[A[i]] += 1
            if count[A[i]] == 2:
                common += 1
            count[B[i]] += 1
            if count[B[i]] == 2:
                common += 1
            result[i] = common
        return result

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    A1 = [1,3,2,4]
    B1 = [3,1,2,4]
    output1 = sol.findThePrefixCommonArray(A1, B1)
    print(f"Example 1: A={A1}, B={B1}")
    print(f"Output: {output1}")
    print(f"Expected: [0,2,3,4]")
    print()
    
    # Example 2
    A2 = [2,3,1]
    B2 = [3,1,2]
    output2 = sol.findThePrefixCommonArray(A2, B2)
    print(f"Example 2: A={A2}, B={B2}")
    print(f"Output: {output2}")
    print(f"Expected: [0,1,3]")