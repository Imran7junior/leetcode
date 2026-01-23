import java.util.*;

class Solution {
    public int minimumPairRemoval(List<Integer> nums) {
        int n = nums.size();
        
        // Check if already sorted
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        
        // Create mutable array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums.get(i);
        }
        
        boolean[] rmv = new boolean[n];
        int[] prv = new int[n];
        int[] nxt = new int[n];
        
        for (int i = 0; i < n; i++) {
            prv[i] = i - 1;
            nxt[i] = (i + 1 < n) ? i + 1 : -1;
        }
        
        // Min heap: (sum, index)
        PriorityQueue<long[]> heap = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        for (int i = 0; i < n - 1; i++) {
            heap.offer(new long[]{(long)arr[i] + arr[i + 1], i});
        }
        
        int bad = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) bad++;
        }
        
        int op = 0;
        while (bad > 0) {
            long[] entry = heap.poll();
            long Sum = entry[0];
            int i = (int)entry[1];
            
            if (rmv[i] || nxt[i] == -1) continue;
            int j = nxt[i];
            if (rmv[j] || arr[i] + arr[j] != Sum) continue;
            
            int pi = prv[i];
            int nj = nxt[j];
            
            // Remove old violations
            if (pi != -1 && arr[pi] > arr[i]) bad--;
            if (arr[i] > arr[j]) bad--;
            if (nj != -1 && arr[j] > arr[nj]) bad--;
            
            // Merge
            arr[i] = (int)Sum;
            rmv[j] = true;
            
            nxt[i] = nj;
            if (nj != -1) prv[nj] = i;
            
            // Add new violations
            if (pi != -1 && arr[pi] > arr[i]) bad++;
            if (nj != -1 && arr[i] > arr[nj]) bad++;
            
            // Update heap
            if (pi != -1) {
                heap.offer(new long[]{(long)arr[pi] + arr[i], pi});
            }
            if (nj != -1) {
                heap.offer(new long[]{(long)arr[i] + arr[nj], i});
            }
            
            op++;
        }
        return op;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        List<Integer> nums1 = Arrays.asList(5, 2, 3, 1);
        int output1 = solution.minimumPairRemoval(nums1);
        System.out.println("Test 1: nums = [5,2,3,1]");
        System.out.println("Output: " + output1 + ", Expected: 2");
        
        // Test case 2
        List<Integer> nums2 = Arrays.asList(1, 2, 2);
        int output2 = solution.minimumPairRemoval(nums2);
        System.out.println("Test 2: nums = [1,2,2]");
        System.out.println("Output: " + output2 + ", Expected: 0");
        
        System.out.println("\nTest cases executed!");
    }
}
