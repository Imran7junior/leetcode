class Solution {
    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int n = nums.length, ans = (int) 1e6;

        for (int i = 0; i < n; i++) {
            if (mpp.containsKey(nums[i])) {
                ans = Math.min(ans, i - mpp.get(nums[i]));
            }
            mpp.put(reverse(nums[i]), i);
        }

        return ans == (int) 1e6 ? -1 : ans;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] nums1 = {12, 21, 45, 33, 54};
        int result1 = solution.minMirrorPairDistance(nums1);
        System.out.println("Example 1: Input: nums = [12, 21, 45, 33, 54]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 1\n");
        
        // Example 2
        int[] nums2 = {120, 21};
        int result2 = solution.minMirrorPairDistance(nums2);
        System.out.println("Example 2: Input: nums = [120, 21]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 1");
    }
}