class Solution:
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        l = r = d = 0
        for c in moves:
            if c == 'L':
                l += 1
            elif c == 'R':
                r += 1
            else:
                d += 1
        return abs(l - r) + d

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    moves1 = "L_RL__R"
    output1 = sol.furthestDistanceFromOrigin(moves1)
    print(f"Example 1: moves={moves1}")
    print(f"Output: {output1}")
    print(f"Expected: 3")
    print()
    
    # Example 2
    moves2 = "_R__LL_"
    output2 = sol.furthestDistanceFromOrigin(moves2)
    print(f"Example 2: moves={moves2}")
    print(f"Output: {output2}")
    print(f"Expected: 5")
    print()
    
    # Example 3
    moves3 = "_______"
    output3 = sol.furthestDistanceFromOrigin(moves3)
    print(f"Example 3: moves={moves3}")
    print(f"Output: {output3}")
    print(f"Expected: 7")