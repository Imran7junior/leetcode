from collections import defaultdict

class Solution:
    def canBeEqual(self, s1: str, s2: str) -> bool:
        odd, even = defaultdict(int), defaultdict(int)
        for i in range(len(s1)):
            if i % 2 == 0:
                even[s1[i]] += 1
                even[s2[i]] -= 1
            else:
                odd[s1[i]] += 1
                odd[s2[i]] -= 1

        return set(odd.values()) == {0} and set(even.values()) == {0}

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    s1_1 = "abcd"
    s2_1 = "cdab"
    output1 = sol.canBeEqual(s1_1, s2_1)
    print(f"Example 1: s1='{s1_1}', s2='{s2_1}'")
    print(f"Output: {output1}")
    print(f"Expected: True")
    print()
    
    # Example 2
    s1_2 = "abcd"
    s2_2 = "dacb"
    output2 = sol.canBeEqual(s1_2, s2_2)
    print(f"Example 2: s1='{s1_2}', s2='{s2_2}'")
    print(f"Output: {output2}")
    print(f"Expected: False")