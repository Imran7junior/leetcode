from typing import List

class Solution:
    def maxTotalValue(self, A: List[int], k: int) -> int:
        gMin = gMax = A[0]

        for n in A:
            gMin = min(gMin, n)
            gMax = max(gMax, n)

        return (gMax - gMin) * k

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    A1 = [1,3,2]
    k1 = 2
    output1 = sol.maxTotalValue(A1, k1)
    print(f"Example 1: A={A1}, k={k1}")
    print(f"Output: {output1}")
    print(f"Expected: 4")
    print()
    
    # Example 2
    A2 = [4,2,5,1]
    k2 = 3
    output2 = sol.maxTotalValue(A2, k2)
    print(f"Example 2: A={A2}, k={k2}")
    print(f"Output: {output2}")
    print(f"Expected: 12")