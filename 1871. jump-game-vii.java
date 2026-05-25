class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int reachable = 0;

        for(int i = 1; i < n; i++) {

            // add new index entering window
            if(i - minJump >= 0 && dp[i - minJump]) {
                reachable++;
            }

            // remove old index leaving window
            if(i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) {
                reachable--;
            }

            dp[i] =(reachable > 0 && s.charAt(i) == '0');
        }

        return dp[n - 1];
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String s1 = "011010";
        int minJump1 = 2;
        int maxJump1 = 3;
        boolean output1 = sol.canReach(s1, minJump1, maxJump1);
        System.out.println("Example 1: s=\"011010\", minJump=2, maxJump=3");
        System.out.println("Output: " + output1);
        System.out.println("Expected: true");
        System.out.println();
        
        // Example 2
        String s2 = "01101110";
        int minJump2 = 2;
        int maxJump2 = 3;
        boolean output2 = sol.canReach(s2, minJump2, maxJump2);
        System.out.println("Example 2: s=\"01101110\", minJump=2, maxJump=3");
        System.out.println("Output: " + output2);
        System.out.println("Expected: false");
    }
}