class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int negativeCount = 0;
        int minAbsValue = Integer.MAX_VALUE;
        
        for (int[] row : matrix) {
            for (int value : row) {
                totalSum += Math.abs(value);
                if (value < 0) {
                    negativeCount++;
                }
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }
        
        // If the count of negative numbers is odd, subtract twice the smallest absolute value
        if (negativeCount % 2 == 1) {
            totalSum -= 2 * minAbsValue;
        }
        
        return totalSum;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[][] matrix1 = {{1, -1}, {-1, 1}};
        System.out.println("Test 1: " + solution.maxMatrixSum(matrix1)); // Expected: 4
        
        // Test case 2
        int[][] matrix2 = {{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}};
        System.out.println("Test 2: " + solution.maxMatrixSum(matrix2)); // Expected: 16
        
        // Test case 3
        int[][] matrix3 = {{-1, 0, -1}, {-2, 1, 3}, {3, 2, 2}};
        System.out.println("Test 3: " + solution.maxMatrixSum(matrix3)); // Expected: 15
    }
}
