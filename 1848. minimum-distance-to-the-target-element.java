class Solution {
    public int getMinDistance(int[] nums, int target, int start) {

        int result = nums.length;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                result = Math.min(result, Math.abs(i - start));
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {1,2,3,4,5};
        int target1 = 5;
        int start1 = 3;
        int output1 = sol.getMinDistance(nums1, target1, start1);
        System.out.println("Example 1: nums=[1,2,3,4,5], target=5, start=3");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 2
        int[] nums2 = {1};
        int target2 = 1;
        int start2 = 0;
        int output2 = sol.getMinDistance(nums2, target2, start2);
        System.out.println("Example 2: nums=[1], target=1, start=0");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 0");
        System.out.println();
        
        // Example 3
        int[] nums3 = {1,1,1,1,1,1,1,1,1,1};
        int target3 = 1;
        int start3 = 0;
        int output3 = sol.getMinDistance(nums3, target3, start3);
        System.out.println("Example 3: nums=[1,1,1,1,1,1,1,1,1,1], target=1, start=0");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 0");
    }
}