class Solution:
    def minimumCost(self, cost: List[int]) -> int:
        cost.sort()
        total = 0

        i = len(cost) - 1

        while i >= 0:
            total += cost[i]
            if i - 1 >= 0:
                total += cost[i - 1]

            i -= 3

        return total

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    cost1 = [1,2,3]
    output1 = sol.minimumCost(cost1)
    print(f"Example 1: cost={cost1}")
    print(f"Output: {output1}")
    print(f"Expected: 5")
    print()
    
    # Example 2
    cost2 = [6,5,7,9,2,2]
    output2 = sol.minimumCost(cost2)
    print(f"Example 2: cost={cost2}")
    print(f"Output: {output2}")
    print(f"Expected: 23")
    print()
    
    # Example 3
    cost3 = [5,5]
    output3 = sol.minimumCost(cost3)
    print(f"Example 3: cost={cost3}")
    print(f"Output: {output3}")
    print(f"Expected: 10")