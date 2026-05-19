class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1_1 = {1,2,3};
        int[] nums2_1 = {2,4};
        int output1 = sol.getCommon(nums1_1, nums2_1);
        System.out.println("Example 1: nums1=[1,2,3], nums2=[2,4]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 2");
        System.out.println();
        
        // Example 2
        int[] nums1_2 = {1,2,3,6};
        int[] nums2_2 = {2,3,4,5};
        int output2 = sol.getCommon(nums1_2, nums2_2);
        System.out.println("Example 2: nums1=[1,2,3,6], nums2=[2,3,4,5]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 2");
    }
}