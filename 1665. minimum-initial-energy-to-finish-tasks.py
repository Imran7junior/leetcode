class Solution:
    def minimumEffort(self, tasks: List[List[int]]) -> int:
        tasks.sort(key=lambda t: -(t[1] - t[0]))

        curr = 0
        ans  = 0
        for actual, minimum in tasks:
            if curr < minimum:
                ans  += (minimum - curr)
                curr  = minimum

            curr -= actual

        return ans


# Test cases
if __name__ == "__main__":
    from typing import List
    
    solution = Solution()
    
    # Example 1
    tasks1 = [[1,2],[2,4],[4,8]]
    result1 = solution.minimumEffort(tasks1)
    print(f"Example 1: Input: tasks = {tasks1}")
    print(f"Output: {result1}")
    print(f"Expected: 8\n")
    
    # Example 2
    tasks2 = [[1,3],[2,4],[10,11],[10,12],[8,9]]
    result2 = solution.minimumEffort(tasks2)
    print(f"Example 2: Input: tasks = {tasks2}")
    print(f"Output: {result2}")
    print(f"Expected: 32\n")
    
    # Example 3
    tasks3 = [[1,7],[2,8],[3,9],[4,10],[5,11],[6,12]]
    result3 = solution.minimumEffort(tasks3)
    print(f"Example 3: Input: tasks = {tasks3}")
    print(f"Output: {result3}")
    print(f"Expected: 27")