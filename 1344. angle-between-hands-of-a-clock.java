class Solution {
    public double angleClock(int hour, int minutes) {
        double x = hour + minutes / 60.0;
        double diff = (11.0 * x) % 12.0;
        return Math.min(diff, 12.0 - diff) * 30.0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: hour = 12, minutes = 30 -> Expected: 165.0
        assert sol.angleClock(12, 30) == 165.0 : "Test 1 failed: " + sol.angleClock(12, 30);

        // Example 2: hour = 3, minutes = 30 -> Expected: 75.0
        assert sol.angleClock(3, 30) == 75.0 : "Test 2 failed: " + sol.angleClock(3, 30);

        // Example 3: hour = 3, minutes = 15 -> Expected: 7.5
        assert sol.angleClock(3, 15) == 7.5 : "Test 3 failed: " + sol.angleClock(3, 15);

        System.out.println("All test cases passed!");
    }
}