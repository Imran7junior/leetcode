class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];

        int left = 0;
        int right = n - 1;

        int i = 0;
        int j = n - 1;

        while (i < n) {
            if (nums[i] < pivot) {
                ans[left++] = nums[i];
            }

            if (nums[j] > pivot) {
                ans[right--] = nums[j];
            }

            i++;
            j--;
        }

        // Remaining positions contain pivot
        while (left <= right) {
            ans[left++] = pivot;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {9,12,5,10,14,3,10};
        int pivot1 = 10;
        int[] output1 = sol.pivotArray(nums1, pivot1);
        System.out.println("Example 1: nums=[9,12,5,10,14,3,10], pivot=10");
        System.out.println("Output: " + java.util.Arrays.toString(output1));
        System.out.println("Expected: [9, 5, 3, 10, 10, 12, 14]");
        System.out.println();
        
        // Example 2
        int[] nums2 = {-3,4,3,2};
        int pivot2 = 2;
        int[] output2 = sol.pivotArray(nums2, pivot2);
        System.out.println("Example 2: nums=[-3,4,3,2], pivot=2");
        System.out.println("Output: " + java.util.Arrays.toString(output2));
        System.out.println("Expected: [-3, 2, 4, 3]");
    }
}