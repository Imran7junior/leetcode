class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long ans = 0;

        for (int l = 0; l < n; l++) {
            int targetCount = 0;

            for (int r = l; r < n; r++) {
                if (nums[r] == target) {
                    targetCount++;
                }

                int len = r - l + 1;

                if (targetCount > len / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.countMajoritySubarrays(
            new int[]{1, 2, 2, 3}, 2
        )); // Expected: 5

        System.out.println(sol.countMajoritySubarrays(
            new int[]{1, 1, 1, 1}, 1
        )); // Expected: 10

        System.out.println(sol.countMajoritySubarrays(
            new int[]{1, 2, 3}, 4
        )); // Expected: 0
    }
}