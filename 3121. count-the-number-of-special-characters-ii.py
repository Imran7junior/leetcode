class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        last_lower = {}
        first_upper = {}
        invalid = set()

        for i, ch in enumerate(word):
            letter = ch.lower()

            if ch.islower():
                last_lower[letter] = i

                # lowercase appeared after uppercase
                if letter in first_upper:
                    invalid.add(letter)

            else:
                # store only first uppercase occurrence
                if letter not in first_upper:
                    first_upper[letter] = i

        special_count = 0

        for letter in last_lower:
            if letter in first_upper and letter not in invalid:
                special_count += 1

        return special_count

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
    word3 = "AbBCab"
    output3 = sol.numberOfSpecialChars(word3)
    print(f"Example 3: word={word3}")
    print(f"Output: {output3}")
    print(f"Expected: 0")