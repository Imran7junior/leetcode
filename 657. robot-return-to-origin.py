class Solution:
    def judgeCircle(self, moves: str) -> bool:
        return moves.count('L') == moves.count('R') and \
               moves.count('U') == moves.count('D')

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    moves1 = "UD"
    output1 = sol.judgeCircle(moves1)
    print(f"Example 1: moves='{moves1}'")
    print(f"Output: {output1}")
    print(f"Expected: True")
    print()
    
    # Example 2
    moves2 = "LL"
    output2 = sol.judgeCircle(moves2)
    print(f"Example 2: moves='{moves2}'")
    print(f"Output: {output2}")
    print(f"Expected: False")