class Solution {
    private int rev(int n) {
        int a = 0;
        while(n > 0) {
            a = a * 10 + (n % 10);
            n /= 10;
        }
        return a;
    }
    public int mirrorDistance(int n) {
        int m = rev(n);
        return Math. abs(m - n);
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int n1 = 25;
        int result1 = solution.mirrorDistance(n1);
        System.out.println("Example 1: Input: n = " + n1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: 27\n");
        
        // Example 2
        int n2 = 10;
        int result2 = solution.mirrorDistance(n2);
        System.out.println("Example 2: Input: n = " + n2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: 9\n");
        
        // Example 3
        int n3 = 7;
        int result3 = solution.mirrorDistance(n3);
        System.out.println("Example 3: Input: n = " + n3);
        System.out.println("Output: " + result3);
        System.out.println("Expected: 0");
    }
}