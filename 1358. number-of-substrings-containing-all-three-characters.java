class Solution {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int[] p = {-1, -1, -1};

        for (int i = 0; i < s.length(); i++) {
            p[(s.charAt(i) & 31) - 1] = i;
            res += Math.min(p[0], Math.min(p[1], p[2])) + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.numberOfSubstrings("abcabc")); // Expected: 10
        System.out.println(sol.numberOfSubstrings("aaacb"));  // Expected: 3
        System.out.println(sol.numberOfSubstrings("abc"));    // Expected: 1
    }
}