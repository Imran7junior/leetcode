class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int ans = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                ans = Math.max(ans, j - i);
                j++;
            }else{
                i++;
                if(i > j) j = i;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1_1 = {55,30,5,4,2};
        int[] nums2_1 = {100,20,10,10,5};
        int output1 = sol.maxDistance(nums1_1, nums2_1);
        System.out.println("Example 1: nums1=[55,30,5,4,2], nums2=[100,20,10,10,5]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 2");
        System.out.println();
        
        // Example 2
        int[] nums1_2 = {2,2,2};
        int[] nums2_2 = {10,10,1};
        int output2 = sol.maxDistance(nums1_2, nums2_2);
        System.out.println("Example 2: nums1=[2,2,2], nums2=[10,10,1]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 3
        int[] nums1_3 = {30,29,19,5};
        int[] nums2_3 = {25,25,25,25,25};
        int output3 = sol.maxDistance(nums1_3, nums2_3);
        System.out.println("Example 3: nums1=[30,29,19,5], nums2=[25,25,25,25,25]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 2");
    }
}