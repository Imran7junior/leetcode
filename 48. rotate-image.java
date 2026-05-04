class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate(matrix1);
        System.out.println("Example 1: Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]");
        System.out.print("Output: [");
        for (int i = 0; i < matrix1.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(matrix1[i][j]);
                if (j < matrix1[i].length - 1) System.out.print(",");
            }
            System.out.print("]");
            if (i < matrix1.length - 1) System.out.print(",");
        }
        System.out.println("]");
        System.out.println("Expected: [[7,4,1],[8,5,2],[9,6,3]]\n");
        
        // Example 2
        int[][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        solution.rotate(matrix2);
        System.out.println("Example 2: Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]");
        System.out.print("Output: [");
        for (int i = 0; i < matrix2.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j]);
                if (j < matrix2[i].length - 1) System.out.print(",");
            }
            System.out.print("]");
            if (i < matrix2.length - 1) System.out.print(",");
        }
        System.out.println("]");
        System.out.println("Expected: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]");
    }
}