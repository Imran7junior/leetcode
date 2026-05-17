class Solution:
    def canReach(self, arr: list[int], start: int) -> bool:
        n = len(arr)
        visited = set()
        q = deque([start])

        while q:
            i = q.popleft()

            if i < 0 or i >= n or i in visited:
                continue

            if arr[i] == 0:
                return True

            visited.add(i)
            q.append(i + arr[i])
            q.append(i - arr[i])

        return False

    # DFS alternative (recursive)
    def canReachDFS(self, arr: list[int], start: int) -> bool:
        n = len(arr)
        visited = set()

        def dfs(i: int) -> bool:
            if i < 0 or i >= n or i in visited:
                return False
            if arr[i] == 0:
                return True
            visited.add(i)
            return dfs(i + arr[i]) or dfs(i - arr[i])

        return dfs(start)


# Test cases
if __name__ == "__main__":
    from collections import deque
    
    solution = Solution()
    
    # Example 1
    arr1 = [4, 2, 3, 0, 3, 1, 2]
    start1 = 5
    result1 = solution.canReach(arr1, start1)
    print(f"Example 1: Input: arr = {arr1}, start = {start1}")
    print(f"Output: {result1}")
    print(f"Expected: True\n")
    
    # Example 2
    arr2 = [4, 2, 3, 0, 3, 1, 2]
    start2 = 0
    result2 = solution.canReach(arr2, start2)
    print(f"Example 2: Input: arr = {arr2}, start = {start2}")
    print(f"Output: {result2}")
    print(f"Expected: True\n")
    
    # Example 3
    arr3 = [3, 0, 2, 1, 2]
    start3 = 2
    result3 = solution.canReach(arr3, start3)
    print(f"Example 3: Input: arr = {arr3}, start = {start3}")
    print(f"Output: {result3}")
    print(f"Expected: False")