from collections import deque, defaultdict

class Solution:
    def minJumps(self, arr: List[int]) -> int:
        n = len(arr)
        if n == 1:
            return 0

        # Map each value to list of indices
        indices_map = defaultdict(list)
        for i, val in enumerate(arr):
            indices_map[val].append(i)

        dist = [-1] * n
        dist[0] = 0
        q = deque([0])

        while q:
            idx = q.popleft()

            if idx == n - 1:
                return dist[idx]

            # Jump to idx+1
            if idx + 1 < n and dist[idx + 1] == -1:
                dist[idx + 1] = dist[idx] + 1
                q.append(idx + 1)
            # Jump to idx-1 (only if >0)
            if idx - 1 > 0 and dist[idx - 1] == -1:
                dist[idx - 1] = dist[idx] + 1
                q.append(idx - 1)

            # Jump to all indices with the same value
            if arr[idx] in indices_map:
                for j in indices_map[arr[idx]]:
                    if dist[j] == -1:
                        dist[j] = dist[idx] + 1
                        q.append(j)
                # Clear to avoid re-processing this value
                indices_map[arr[idx]].clear()

        return -1


# Test cases
if __name__ == "__main__":
    from typing import List
    from collections import deque, defaultdict
    
    solution = Solution()
    
    # Example 1
    arr1 = [100, -23, -23, 404, 100, 23, 23, 23, 3, 404]
    result1 = solution.minJumps(arr1)
    print(f"Example 1: Input: arr = {arr1}")
    print(f"Output: {result1}")
    print(f"Expected: 3\n")
    
    # Example 2
    arr2 = [7]
    result2 = solution.minJumps(arr2)
    print(f"Example 2: Input: arr = {arr2}")
    print(f"Output: {result2}")
    print(f"Expected: 0\n")
    
    # Example 3
    arr3 = [7, 6, 9, 6, 9, 6, 9, 7]
    result3 = solution.minJumps(arr3)
    print(f"Example 3: Input: arr = {arr3}")
    print(f"Output: {result3}")
    print(f"Expected: 1")