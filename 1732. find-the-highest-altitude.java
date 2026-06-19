class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int mx = 0;

        for (int i = 0; i <= n; i++) {
            int alt = 0;
            for (int j = 0; j < i; j++) {
                alt += gain[j];
            }
            mx = Math.max(mx, alt);
        }

        return mx;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.largestAltitude(new int[]{-5, 1, 5, 0, -7})); // Expected: 1
        System.out.println(sol.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2})); // Expected: 0
    }
}