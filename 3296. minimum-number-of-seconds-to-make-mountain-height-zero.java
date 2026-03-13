class Solution {
    public long minNumberOfSeconds(int height, int[] times) {
        long lo = 1, hi = 10000000000000000L;

        while (lo < hi) {
            long mid = (lo + hi) >> 1;
            long tot = 0;
            for (int i = 0; i < times.length && tot < height; i++)
                tot += (long) (Math.sqrt((double) mid / times[i] * 2 + 0.25) - 0.5);
            if (tot >= height)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int height1 = 4;
        int[] times1 = {2,1,1};
        long output1 = sol.minNumberOfSeconds(height1, times1);
        System.out.println("Example 1: Input: mountainHeight = " + height1 + ", workerTimes = [2,1,1]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 3");
        System.out.println();
        
        // Example 2:
        int height2 = 10;
        int[] times2 = {3,2,2,4};
        long output2 = sol.minNumberOfSeconds(height2, times2);
        System.out.println("Example 2: Input: mountainHeight = " + height2 + ", workerTimes = [3,2,2,4]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 12");
        System.out.println();
        
        // Example 3:
        int height3 = 5;
        int[] times3 = {1};
        long output3 = sol.minNumberOfSeconds(height3, times3);
        System.out.println("Example 3: Input: mountainHeight = " + height3 + ", workerTimes = [1]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 15");
    }
}