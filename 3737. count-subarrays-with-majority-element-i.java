class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int balance = n + 1;

        int[] freq = new int[2 * n + 2];
        int[] pref = new int[2 * n + 2];

        freq[balance] = 1;
        pref[balance] = 1;

        int answer = 0;

        for (int num : nums) {
            if (num == target) {
                balance++;
            } else {
                balance--;
            }
            freq[balance]++;

            pref[balance] = pref[balance - 1] + freq[balance];

            answer += pref[balance - 1];
        }

        return answer;
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