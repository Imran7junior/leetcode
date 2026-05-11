class Solution {
    public int[] separateDigits(int[] nums) {
        
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {

            String s = String.valueOf(num);

            for (char ch : s.toCharArray()) {

                list.add(ch - '0');
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] nums1 = {13, 25, 83, 77};
        int[] result1 = solution.separateDigits(nums1);
        System.out.println("Example 1: Input: nums = [13, 25, 83, 77]");
        System.out.print("Output: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [1, 3, 2, 5, 8, 3, 7, 7]\n");
        
        // Example 2
        int[] nums2 = {7, 1, 3, 9};
        int[] result2 = solution.separateDigits(nums2);
        System.out.println("Example 2: Input: nums = [7, 1, 3, 9]");
        System.out.print("Output: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [7, 1, 3, 9]");
    }
}