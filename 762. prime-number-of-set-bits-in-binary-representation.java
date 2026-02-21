class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        
        for (int i=left;i<=right;i++) {
            int setBits=Integer.bitCount(i);
            if (isPrime(setBits)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isPrime(int n) {
        if (n<=1) {
            return false;
        }
        for (int i=2;i*i <= n;i++) {
            if (n%i==0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int left1 = 6;
        int right1 = 10;
        int output1 = sol.countPrimeSetBits(left1, right1);
        System.out.println("Example 1: Input: left = " + left1 + ", right = " + right1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 4");
        System.out.println();
        
        // Example 2:
        int left2 = 10;
        int right2 = 15;
        int output2 = sol.countPrimeSetBits(left2, right2);
        System.out.println("Example 2: Input: left = " + left2 + ", right = " + right2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 5");
    }
}