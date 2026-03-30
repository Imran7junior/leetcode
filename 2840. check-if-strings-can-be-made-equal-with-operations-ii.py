class Solution:
    def checkStrings(self, s1: str, s2: str) -> bool:
        evenfreq1 = [0] * 26
        oddfreq1 = [0] * 26
        evenfreq2 = [0] * 26
        oddfreq2 = [0] * 26
        
        for i in range(len(s1)):
            char1idx = ord(s1[i]) - 97
            char2idx = ord(s2[i]) - 97
            if i % 2 == 0:
                evenfreq1[char1idx] += 1
                evenfreq2[char2idx] += 1
            else:
                oddfreq1[char1idx] += 1
                oddfreq2[char2idx] += 1
                
        return evenfreq1 == evenfreq2 and oddfreq1 == oddfreq2

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    s1_1 = "abcdba"
    s2_1 = "cabdab"
    output1 = sol.checkStrings(s1_1, s2_1)
    print(f"Example 1: s1='{s1_1}', s2='{s2_1}'")
    print(f"Output: {output1}")
    print(f"Expected: True")
    print()
    
    # Example 2
    s1_2 = "abe"
    s2_2 = "bea"
    output2 = sol.checkStrings(s1_2, s2_2)
    print(f"Example 2: s1='{s1_2}', s2='{s2_2}'")
    print(f"Output: {output2}")
    print(f"Expected: False")