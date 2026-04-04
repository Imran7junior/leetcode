class Solution:
    def decodeCiphertext(self, encodedText: str, rows: int) -> str:
        if rows == 0:
            return ""

        n = len(encodedText)
        if n == 0:
            return ""

        cols = n // rows

        # Step 1: Build matrix
        mat = []
        idx = 0
        for i in range(rows):
            row = []
            for j in range(cols):
                row.append(encodedText[idx])
                idx += 1
            mat.append(row)

        # Step 2: Diagonal traversal
        result = []

        for startCol in range(cols):
            i, j = 0, startCol
            while i < rows and j < cols:
                result.append(mat[i][j])
                i += 1
                j += 1

        # Step 3: Remove trailing spaces
        return "".join(result).rstrip()

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    encodedText1 = "ch   ie   pr"
    rows1 = 3
    output1 = sol.decodeCiphertext(encodedText1, rows1)
    print(f"Example 1: encodedText='{encodedText1}', rows={rows1}")
    print(f"Output: '{output1}'")
    print(f"Expected: 'cipher'")
    print()
    
    # Example 2
    encodedText2 = "iveo    eed   l te   olc"
    rows2 = 4
    output2 = sol.decodeCiphertext(encodedText2, rows2)
    print(f"Example 2: encodedText='{encodedText2}', rows={rows2}")
    print(f"Output: '{output2}'")
    print(f"Expected: 'i love leetcode'")
    print()
    
    # Example 3
    encodedText3 = "coding"
    rows3 = 1
    output3 = sol.decodeCiphertext(encodedText3, rows3)
    print(f"Example 3: encodedText='{encodedText3}', rows={rows3}")
    print(f"Output: '{output3}'")
    print(f"Expected: 'coding'")