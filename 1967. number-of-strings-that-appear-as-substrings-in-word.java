class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String s : patterns)
            if (word.contains(s)) count++;
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.numOfStrings(
            new String[]{"a", "abc", "bc", "d"}, "abc"
        )); // Expected: 3

        System.out.println(sol.numOfStrings(
            new String[]{"a", "b", "c"}, "aaaaabbbbb"
        )); // Expected: 2

        System.out.println(sol.numOfStrings(
            new String[]{"a", "a", "a"}, "ab"
        )); // Expected: 3
    }
}