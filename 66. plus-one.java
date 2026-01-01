import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        // Start from the rightmost digit
        int n = digits.length;
        
        for (int i = n - 1; i >= 0; i--) {
            // If current digit is less than 9, just increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // Otherwise, set it to 0 and continue (carry over)
            digits[i] = 0;
        }
        
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test 1
        int[] digits1 = {1, 2, 3};
        int[] result1 = solution.plusOne(digits1);
        System.out.println("Test 1: digits=[1,2,3] -> " + Arrays.toString(result1) + ", Expected: [1,2,4]");
        
        // Test 2
        int[] digits2 = {4, 3, 2, 1};
        int[] result2 = solution.plusOne(digits2);
        System.out.println("Test 2: digits=[4,3,2,1] -> " + Arrays.toString(result2) + ", Expected: [4,3,2,2]");
        
        // Test 3: Single digit
        int[] digits3 = {9};
        int[] result3 = solution.plusOne(digits3);
        System.out.println("Test 3: digits=[9] -> " + Arrays.toString(result3) + ", Expected: [1,0]");
        
    }
}
