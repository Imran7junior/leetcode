class Solution {
    private int calFinishTime(int[] ls, int[] ld,int[] ws, int[] wd) {

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < ls.length; i++) {
            mini = Math.min(mini, ls[i] + ld[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < ws.length; i++) {
            ans = Math.min(
                ans,
                Math.max(mini, ws[i]) + wd[i]
            );
        }

        return ans;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(
            calFinishTime(landStartTime,landDuration,waterStartTime,waterDuration),
            calFinishTime(waterStartTime,waterDuration,landStartTime,landDuration)
        );
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] landStartTime1 = {2,8};
        int[] landDuration1 = {4,1};
        int[] waterStartTime1 = {6};
        int[] waterDuration1 = {3};
        int output1 = sol.earliestFinishTime(landStartTime1, landDuration1, waterStartTime1, waterDuration1);
        System.out.println("Example 1: landStartTime=[2,8], landDuration=[4,1], waterStartTime=[6], waterDuration=[3]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 9");
        System.out.println();
        
        // Example 2
        int[] landStartTime2 = {5};
        int[] landDuration2 = {3};
        int[] waterStartTime2 = {1};
        int[] waterDuration2 = {10};
        int output2 = sol.earliestFinishTime(landStartTime2, landDuration2, waterStartTime2, waterDuration2);
        System.out.println("Example 2: landStartTime=[5], landDuration=[3], waterStartTime=[1], waterDuration=[10]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 14");
    }
}