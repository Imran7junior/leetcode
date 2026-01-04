class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int n : nums) {
            int val = sumOne(n);
            if (val != -1) {
                res += val;
            }
        }
        return res;
    }

    private int sumOne(int n) {
        int p = (int) Math.round(Math.pow(n, 1.0 / 3));
        if (p * p * p == n && isPrime(p)) {
            return 1 + p + p * p + p * p * p;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                int a = i;
                int b = n / i;
                if (a != b && isPrime(a) && isPrime(b)) {
                    return 1 + a + b + n;
                }
                return -1;
            }
        }
        return -1;
    }

    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println(solution.sumFourDivisors(new int[]{21, 4, 7})); // Expected: 32
        System.out.println(solution.sumFourDivisors(new int[]{21, 21}));   // Expected: 64
        System.out.println(solution.sumFourDivisors(new int[]{1, 2, 3, 4, 5})); // Expected: 0
    }
}
