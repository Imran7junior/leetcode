from typing import List

class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        sorted_arr = sorted(arr)

        rank = {}
        current_rank = 1

        for num in sorted_arr:
            if num not in rank:
                rank[num] = current_rank
                current_rank += 1

        return [rank[num] for num in arr]


# Test cases
sol = Solution()

# Example 1
arr = [40, 10, 20, 30]
print(sol.arrayRankTransform(arr))  # [4, 1, 2, 3]

# Example 2
arr = [100, 100, 100]
print(sol.arrayRankTransform(arr))  # [1, 1, 1]

# Example 3
arr = [37, 12, 28, 9, 100, 56, 80, 5, 12]
print(sol.arrayRankTransform(arr))  # [5, 3, 4, 2, 8, 6, 7, 1, 3]