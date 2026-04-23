import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!hm.containsKey(nums[i])) {
                hm.put(nums[i], new ArrayList<>());
            }
            hm.get(nums[i]).add(i);
        }
        
        long[] ans = new long[nums.length];
        for(ArrayList<Integer> indices : hm.values()) {
            int n = indices.size();
            long sum = 0;
            for(int i = 0; i < n; i++) {
                sum += indices.get(i);
            }
            long leftsum = 0;
            long rightsum = sum;
            long currsum = 0;
            for(int i = 0; i < n; i++) {
                currsum = 0;
                currsum += (long)i*(long)indices.get(i) - leftsum;
                currsum += rightsum - (long)(n-i)*(long)indices.get(i);
                leftsum += (long)indices.get(i);
                rightsum -= (long)indices.get(i);
                ans[indices.get(i)] = currsum;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {1,3,1,1,2};
        long[] output1 = sol.distance(nums1);
        System.out.println("Example 1: nums=[1,3,1,1,2]");
        System.out.print("Output: [");
        for(int i = 0; i < output1.length; i++) {
            if(i > 0) System.out.print(",");
            System.out.print(output1[i]);
        }
        System.out.println("]");
        System.out.println("Expected: [5,0,3,4,0]");
        System.out.println();
        
        // Example 2
        int[] nums2 = {0,5,3};
        long[] output2 = sol.distance(nums2);
        System.out.println("Example 2: nums=[0,5,3]");
        System.out.print("Output: [");
        for(int i = 0; i < output2.length; i++) {
            if(i > 0) System.out.print(",");
            System.out.print(output2[i]);
        }
        System.out.println("]");
        System.out.println("Expected: [0,0,0]");
    }
}