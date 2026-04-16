from typing import List

class Solution:
    def closestTarget(self, words: List[str], target: str, startIndex: int) -> int:
        n = len(words)
        ans = float('inf')

        for i in range(n):
            if words[i] == target:
                clockwise = (i - startIndex + n) % n
                anticlockwise = (startIndex - i + n) % n
                ans = min(ans, min(clockwise, anticlockwise))

        return -1 if ans == float('inf') else ans

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    words1 = ["hello","i","am","leetcode","hello"]
    target1 = "hello"
    startIndex1 = 1
    output1 = sol.closestTarget(words1, target1, startIndex1)
    print(f"Example 1: words={words1}, target='{target1}', startIndex={startIndex1}")
    print(f"Output: {output1}")
    print(f"Expected: 1")
    print()
    
    # Example 2
    words2 = ["a","b","leetcode"]
    target2 = "leetcode"
    startIndex2 = 0
    output2 = sol.closestTarget(words2, target2, startIndex2)
    print(f"Example 2: words={words2}, target='{target2}', startIndex={startIndex2}")
    print(f"Output: {output2}")
    print(f"Expected: 1")
    print()
    
    # Example 3
    words3 = ["i","eat","leetcode"]
    target3 = "ate"
    startIndex3 = 0
    output3 = sol.closestTarget(words3, target3, startIndex3)
    print(f"Example 3: words={words3}, target='{target3}', startIndex={startIndex3}")
    print(f"Output: {output3}")
    print(f"Expected: -1")