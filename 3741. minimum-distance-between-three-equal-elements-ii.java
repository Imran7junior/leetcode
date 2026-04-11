import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int ans=Integer.MAX_VALUE;
        for(int i:map.keySet()){
            List<Integer> arr=map.get(i);
            if(arr.size()>=3){
                for(int j=0;j<arr.size()-2;j++){
                    ans=Math.min(ans,
                                (arr.get(j+1)-arr.get(j))+
                                (arr.get(j+2)-arr.get(j+1))+
                                (arr.get(j+2)-arr.get(j)));
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {1,2,1,1,3};
        int output1 = sol.minimumDistance(nums1);
        System.out.println("Example 1: nums=[1,2,1,1,3]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 6");
        System.out.println();
        
        // Example 2
        int[] nums2 = {1,1,2,3,2,1,2};
        int output2 = sol.minimumDistance(nums2);
        System.out.println("Example 2: nums=[1,1,2,3,2,1,2]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 8");
        System.out.println();
        
        // Example 3
        int[] nums3 = {1};
        int output3 = sol.minimumDistance(nums3);
        System.out.println("Example 3: nums=[1]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: -1");
    }
}