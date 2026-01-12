class Solution {
    public int minTimeToVisitAllPoints(int[][] p) {
        int ans = 0;
        for (int i = 1; i < p.length; i++) {
            ans += Math.max(
                Math.abs(p[i][0] - p[i - 1][0]),
                Math.abs(p[i][1] - p[i - 1][1])
            );
        }
        return ans;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[][] points1 = {{1,1},{3,4},{-1,0}};
        int output1 = solution.minTimeToVisitAllPoints(points1);
        System.out.println("Test 1: points = [[1,1],[3,4],[-1,0]]");
        System.out.println("Output: " + output1 + ", Expected: 7");
        assert output1 == 7 : "Test 1 failed: expected 7, got " + output1;
        
        // Test case 2
        int[][] points2 = {{3,2},{-2,2}};
        int output2 = solution.minTimeToVisitAllPoints(points2);
        System.out.println("Test 2: points = [[3,2],[-2,2]]");
        System.out.println("Output: " + output2 + ", Expected: 5");
        assert output2 == 5 : "Test 2 failed: expected 5, got " + output2;
        
        System.out.println("\nAll test cases passed!");
    }
}
