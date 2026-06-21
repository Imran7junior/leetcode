from typing import List

class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        max_cost = max(costs)

        freq = [0] * (max_cost + 1)

        for cost in costs:
            freq[cost] += 1

        ans = 0

        for price in range(1, max_cost + 1):
            if freq[price] == 0:
                continue

            can_buy = min(freq[price], coins // price)

            ans += can_buy
            coins -= can_buy * price

            if coins < price:
                break

        return ans


if __name__ == "__main__":
    sol = Solution()

    print(sol.maxIceCream([1, 3, 2, 4, 1], 7))      # Expected: 4
    print(sol.maxIceCream([10, 6, 8, 7, 7, 8], 5))  # Expected: 0
    print(sol.maxIceCream([1, 6, 3, 1, 2, 5], 20))  # Expected: 6