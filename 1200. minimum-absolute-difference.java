import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        
        // Find minimum difference
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
        }
        
        // Collect all pairs with minimum difference
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        
        return result;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] arr1 = {4, 2, 1, 3};
        List<List<Integer>> output1 = solution.minimumAbsDifference(arr1);
        System.out.println("Test 1: arr = [4,2,1,3]");
        System.out.println("Output: " + output1 + ", Expected: [[1,2],[2,3],[3,4]]");
        
        // Test case 2
        int[] arr2 = {1, 3, 6, 10, 15};
        List<List<Integer>> output2 = solution.minimumAbsDifference(arr2);
        System.out.println("Test 2: arr = [1,3,6,10,15]");
        System.out.println("Output: " + output2 + ", Expected: [[1,3]]");
        
        // Test case 3
        int[] arr3 = {3, 8, -10, 23, 19, -4, -14, 27};
        List<List<Integer>> output3 = solution.minimumAbsDifference(arr3);
        System.out.println("Test 3: arr = [3,8,-10,23,19,-4,-14,27]");
        System.out.println("Output: " + output3 + ", Expected: [[-14,-10],[19,23],[23,27]]");
        
        System.out.println("\nTest cases executed!");
    }
}
