class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (nums[0] >= nums[1] || n < 4) return false;
        
        int q = 0, t = 0, i = 2;
        
        while (i < n) {
            // Increasing phase
            while (i < n && nums[i - 1] < nums[i]) i++;
            if (i < n && nums[i - 1] == nums[i]) return false;
            
            // Decreasing phase
            while (i < n && nums[i - 1] > nums[i]) i++;
            if (i < n && nums[i - 1] == nums[i]) return false;
            
            q = i;
            if (!(1 < q && q < n)) return false;
            
            // Final increasing phase
            while (i < n && nums[i - 1] < nums[i]) i++;
            t = i;
            if (t < n) return false;
            i++;
        }
        
        return true;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {1, 3, 5, 4, 2, 6};
        boolean output1 = solution.isTrionic(nums1);
        System.out.println("Test 1: nums = [1,3,5,4,2,6]");
        System.out.println("Output: " + output1 + ", Expected: true");
        
        // Test case 2
        int[] nums2 = {2, 1, 3};
        boolean output2 = solution.isTrionic(nums2);
        System.out.println("Test 2: nums = [2,1,3]");
        System.out.println("Output: " + output2 + ", Expected: false");
        
        System.out.println("\nTest cases executed!");
    }
}
