class Solution {

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public int findGCD(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return gcd(min, max);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] nums1 = {2, 5, 6, 9, 10};
        System.out.println(sol.findGCD(nums1)); // 2

        // Example 2
        int[] nums2 = {7, 5, 6, 8, 3};
        System.out.println(sol.findGCD(nums2)); // 1

        // Example 3
        int[] nums3 = {3, 3};
        System.out.println(sol.findGCD(nums3)); // 3
    }
}