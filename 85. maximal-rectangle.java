import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols + 1]; // Include an extra element for easier calculation
        int maxArea = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                heights[c] = matrix[r][c] == '1' ? heights[c] + 1 : 0;
            }
            
            // Calculate max area using histogram method
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(i);
            }
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        char[][] matrix1 = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        int output1 = 6;
        int result1 = solution.maximalRectangle(matrix1);
        System.out.println("Test 1: " + result1 + " == " + output1 + " -> " + (result1 == output1 ? "PASS" : "FAIL"));
        
        // Test case 2
        char[][] matrix2 = {{'0'}};
        int output2 = 0;
        int result2 = solution.maximalRectangle(matrix2);
        System.out.println("Test 2: " + result2 + " == " + output2 + " -> " + (result2 == output2 ? "PASS" : "FAIL"));
        
        // Test case 3
        char[][] matrix3 = {{'1'}};
        int output3 = 1;
        int result3 = solution.maximalRectangle(matrix3);
        System.out.println("Test 3: " + result3 + " == " + output3 + " -> " + (result3 == output3 ? "PASS" : "FAIL"));
    }
}
