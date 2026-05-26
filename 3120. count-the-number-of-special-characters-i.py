class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        lower = 0
        upper = 0

        for ch in word:
            if ch.islower():
                lower |= (1 << (ord(ch) - ord('a')))
            else:
                upper |= (1 << (ord(ch) - ord('A')))

        common = lower & upper

        # counting number of set bits
        return common.bit_count()

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    word1 = "aaAbcBC"
    output1 = sol.numberOfSpecialChars(word1)
    print(f"Example 1: word={word1}")
    print(f"Output: {output1}")
    print(f"Expected: 3")
    print()
    
    # Example 2
    word2 = "abc"
    output2 = sol.numberOfSpecialChars(word2)
    print(f"Example 2: word={word2}")
    print(f"Output: {output2}")
    print(f"Expected: 0")
    print()
    
    # Example 3
    word3 = "abBCab"
    output3 = sol.numberOfSpecialChars(word3)
    print(f"Example 3: word={word3}")
    print(f"Output: {output3}")
    print(f"Expected: 1")