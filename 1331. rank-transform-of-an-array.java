import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();

        Arrays.sort(sorted);

        HashMap<Integer, Integer> rank = new HashMap<>();
        int currentRank = 1;

        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, currentRank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }

        return arr;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] arr1 = {40, 10, 20, 30};
        System.out.println(Arrays.toString(sol.arrayRankTransform(arr1))); // [4,1,2,3]

        // Example 2
        int[] arr2 = {100, 100, 100};
        System.out.println(Arrays.toString(sol.arrayRankTransform(arr2))); // [1,1,1]

        // Example 3
        int[] arr3 = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        System.out.println(Arrays.toString(sol.arrayRankTransform(arr3))); // [5,3,4,2,8,6,7,1,3]
    }
}