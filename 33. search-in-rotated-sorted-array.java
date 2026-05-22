class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            // left half is sorted
            if(nums[low] <= nums[mid]) {

                if(nums[low] <= target &&
                   target < nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }

            // right half is sorted
            else {

                if(nums[mid] < target &&
                   target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {4,5,6,7,0,1,2};
        int target1 = 0;
        int output1 = sol.search(nums1, target1);
        System.out.println("Example 1: nums=[4,5,6,7,0,1,2], target=0");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 4");
        System.out.println();
        
        // Example 2
        int[] nums2 = {4,5,6,7,0,1,2};
        int target2 = 3;
        int output2 = sol.search(nums2, target2);
        System.out.println("Example 2: nums=[4,5,6,7,0,1,2], target=3");
        System.out.println("Output: " + output2);
        System.out.println("Expected: -1");
        System.out.println();
        
        // Example 3
        int[] nums3 = {1};
        int target3 = 0;
        int output3 = sol.search(nums3, target3);
        System.out.println("Example 3: nums=[1], target=0");
        System.out.println("Output: " + output3);
        System.out.println("Expected: -1");
    }
}