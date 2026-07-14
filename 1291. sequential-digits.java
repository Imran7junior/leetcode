import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        String digits = "123456789";

        List<Integer> ans = new ArrayList<>();

        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();

        for (int len = minLen; len <= maxLen; len++) {

            for (int start = 0; start + len <= 9; start++) {

                int num = Integer.parseInt(digits.substring(start, start + len));

                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.sequentialDigits(
            100, 300
        )); // Expected: [123, 234]

        System.out.println(sol.sequentialDigits(
            1000, 13000
        )); // Expected: [1234, 2345, 3456, 4567, 5678, 6789, 12345]
    }
}