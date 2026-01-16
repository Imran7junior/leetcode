from typing import List


class Solution:
    def maximizeSquareArea(self, m: int, n: int, hFences: List[int], vFences: List[int]) -> int:
        hFences.extend([1, m])
        vFences.extend([1, n])

        stt = set()
        ans = 0

        for i in range(len(hFences)):
            for j in range(i+1, len(hFences)):
                stt.add(abs(hFences[j]-hFences[i]))
        
        for i in range(len(vFences)):
            for j in range(i+1, len(vFences)):
                val = abs(vFences[j]-vFences[i])
                if val in stt:
                    ans = max(ans, val)
        
        if ans == 0:
            return -1
        return (ans*ans)%(10**9+7)


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    m1, n1 = 4, 3
    hFences1 = [2, 3]
    vFences1 = [2]
    output1 = solution.maximizeSquareArea(m1, n1, hFences1, vFences1)
    print(f"Test 1: m={m1}, n={n1}, hFences={[2,3]}, vFences={[2]}")
    print(f"Output: {output1}, Expected: 4")
    
    # Test case 2
    m2, n2 = 6, 7
    hFences2 = [2]
    vFences2 = [4]
    output2 = solution.maximizeSquareArea(m2, n2, hFences2, vFences2)
    print(f"Test 2: m={m2}, n={n2}, hFences={[2]}, vFences={[4]}")
    print(f"Output: {output2}, Expected: -1")
    
    print("\nTest cases executed!")