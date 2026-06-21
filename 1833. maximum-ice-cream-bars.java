class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;

        for (int cost : costs) {
            maxCost = Math.max(maxCost, cost);
        }

        int[] freq = new int[maxCost + 1];

        for (int cost : costs) {
            freq[cost]++;
        }

        int ans = 0;

        for (int price = 1; price <= maxCost; price++) {
            if (freq[price] == 0) {
                continue;
            }

            int canBuy = Math.min(freq[price], coins / price);

            ans += canBuy;
            coins -= canBuy * price;

            if (coins < price) {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.maxIceCream(
            new int[]{1, 3, 2, 4, 1}, 7
        )); // Expected: 4

        System.out.println(sol.maxIceCream(
            new int[]{10, 6, 8, 7, 7, 8}, 5
        )); // Expected: 0

        System.out.println(sol.maxIceCream(
            new int[]{1, 6, 3, 1, 2, 5}, 20
        )); // Expected: 6
    }
}