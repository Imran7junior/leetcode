class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        r, c=len(box), len(box[0])
        rotate=[['.']*r for _ in range(c)]
        for i, row in enumerate(box):
            bottom=c-1
            for j in range(c-1, -1, -1):
                if row[j]=='#':
                    rotate[bottom][r-1-i]='#'
                    bottom-=1
                elif row[j]=='*':
                    rotate[j][r-1-i]='*'
                    bottom=j-1
        return rotate


# Test cases
if __name__ == "__main__":
    from typing import List
    
    solution = Solution()
    
    # Example 1
    boxGrid1 = [["#",".","#"]]
    result1 = solution.rotateTheBox(boxGrid1)
    print("Example 1: Input: boxGrid = [[\"#\",\".\",\"#\"]]")
    print(f"Output: {result1}")
    print(f"Expected: [[\".\"], [\"#\"], [\"#\"]]\n")
    
    # Example 2
    boxGrid2 = [["#",".","*","."],["#","#","*","."]]
    result2 = solution.rotateTheBox(boxGrid2)
    print("Example 2: Input: boxGrid = [[\"#\",\".\",\"*\",\".\"],[\"#\",\"#\",\"*\",\".\"]]")
    print(f"Output: {result2}")
    print(f"Expected: [[\"#\",\".\"], [\"#\",\"#\"], [\"*\",\"*\"], [\".\",\".\"]]\n")
    
    # Example 3
    boxGrid3 = [["#","#","*",".","*","."],["#","#","#","*",".","."],["#","#","#",".","#","."]]
    result3 = solution.rotateTheBox(boxGrid3)
    print("Example 3: Input: boxGrid = [[\"#\",\"#\",\"*\",\".\",\"*\",\".\"],[\"#\",\"#\",\"#\",\"*\",\".\",\".\"],[\"#\",\"#\",\"#\",\".\",\"#\",\".\"]]")
    print(f"Output: {result3}")
    print(f"Expected: [[\".\",\"#\",\"#\"], [\".\",\"#\",\"#\"], [\"*\",\"*\",\"*\"], [\"#\",\"*\",\".\"], [\"#\",\".\",\"*\"], [\"#\",\".\",\"\"]]")