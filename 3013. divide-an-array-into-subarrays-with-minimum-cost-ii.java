import java.util.*;

class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        // Max heap for used elements (store as negative for max behavior)
        PriorityQueue<int[]> heapUsed = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        // Min heap for unused elements
        PriorityQueue<int[]> heapUnused = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Set<Integer> used = new HashSet<>();
        
        long s = 0;
        long ans = Long.MAX_VALUE;
        
        for (int right = 1; right < nums.length; right++) {
            int left = right - dist - 1;
            
            // Move the left border of the window
            if (left > 0 && used.contains(left)) {
                // If the left element was used in calculating the cost, then we delete it
                used.remove(left);
                s -= nums[left];
                
                // Find the smallest unused element within the window boundary
                while (!heapUnused.isEmpty() && heapUnused.peek()[1] < left) {
                    heapUnused.poll();
                }
                
                if (!heapUnused.isEmpty()) { // If it exists, use it to calculate the cost
                    int[] entry = heapUnused.poll();
                    int num = entry[0];
                    int i = entry[1];
                    heapUsed.offer(new int[]{num, i});
                    used.add(i);
                    s += num;
                }
            }
            
            // Move the right border of the window
            if (used.size() < k - 1) {
                // If less than k-1 elements are used, use the added element to calculate the cost
                heapUsed.offer(new int[]{nums[right], right});
                used.add(right);
                s += nums[right];
            } else {
                // Find the largest used element
                while (!heapUsed.isEmpty() && !used.contains(heapUsed.peek()[1])) {
                    heapUsed.poll();
                }
                
                if (!heapUsed.isEmpty() && nums[right] < heapUsed.peek()[0]) {
                    // If it is larger than the element being added to the window, replace it
                    int[] entry = heapUsed.poll();
                    int num = entry[0];
                    int i = entry[1];
                    
                    heapUsed.offer(new int[]{nums[right], right});
                    used.remove(i);
                    used.add(right);
                    s += nums[right] - num;
                    
                    // Add the vacated element to the unused element heap
                    heapUnused.offer(new int[]{num, i});
                } else {
                    // If the element being added to the window is larger than the largest used element,
                    // place it on the unused element heap
                    heapUnused.offer(new int[]{nums[right], right});
                }
            }
            
            if (left >= 0) {
                ans = Math.min(s, ans);
            }
        }
        
        return nums[0] + ans;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {1, 3, 2, 6, 4, 2};
        int k1 = 3;
        int dist1 = 3;
        long output1 = solution.minimumCost(nums1, k1, dist1);
        System.out.println("Test 1: nums = [1,3,2,6,4,2], k = 3, dist = 3");
        System.out.println("Output: " + output1 + ", Expected: 5");
        
        // Test case 2
        int[] nums2 = {10, 1, 2, 2, 2, 1};
        int k2 = 4;
        int dist2 = 3;
        long output2 = solution.minimumCost(nums2, k2, dist2);
        System.out.println("Test 2: nums = [10,1,2,2,2,1], k = 4, dist = 3");
        System.out.println("Output: " + output2 + ", Expected: 15");
        
        // Test case 3
        int[] nums3 = {10, 8, 18, 9};
        int k3 = 3;
        int dist3 = 1;
        long output3 = solution.minimumCost(nums3, k3, dist3);
        System.out.println("Test 3: nums = [10,8,18,9], k = 3, dist = 1");
        System.out.println("Output: " + output3 + ", Expected: 36");
        
        System.out.println("\nTest cases executed!");
    }
}
