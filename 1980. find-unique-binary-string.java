class Solution {
    public String findDifferentBinaryString(String[] nums) {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            result.append(nums[i].charAt(i) == '1' ? '0' : '1');
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        String[] nums1 = {"01","10"};
        String output1 = sol.findDifferentBinaryString(nums1);
        System.out.println("Example 1: Input: nums = [\"01\",\"10\"]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: '11' or '00'");
        System.out.println();
        
        // Example 2:
        String[] nums2 = {"00","01"};
        String output2 = sol.findDifferentBinaryString(nums2);
        System.out.println("Example 2: Input: nums = [\"00\",\"01\"]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: '11' or '10'");
        System.out.println();
        
        // Example 3:
        String[] nums3 = {"111","011","001"};
        String output3 = sol.findDifferentBinaryString(nums3);
        System.out.println("Example 3: Input: nums = [\"111\",\"011\",\"001\"]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: '101' (or another valid binary string)");
    }
}