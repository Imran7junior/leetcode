import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);

        arr[0] = 1;

        for (int i = 1; i < arr.length; i++) {

            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }

        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.maximumElementAfterDecrementingAndRearranging(
            new int[]{2, 2, 1, 2, 1}
        )); // Expected: 2

        System.out.println(sol.maximumElementAfterDecrementingAndRearranging(
            new int[]{100, 1, 1000}
        )); // Expected: 3

        System.out.println(sol.maximumElementAfterDecrementingAndRearranging(
            new int[]{1, 2, 3, 4, 5}
        )); // Expected: 5
    }
}