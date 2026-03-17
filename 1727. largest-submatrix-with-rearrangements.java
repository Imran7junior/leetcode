class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int maxArea = 0;
        int[] h = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) h[j]++;
                else h[j] = 0;
            }
            int[] sh = h.clone();
            Arrays.sort(sh);
            for (int j = n - 1; j >= 0; j--) {
                if (sh[j] == 0) break;
                maxArea = Math.max(maxArea, sh[j] * (n - j));
            }
        }
        return maxArea;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int[][] matrix1 = {{0,0,1},{1,1,1},{1,0,1}};
        int output1 = sol.largestSubmatrix(matrix1);
        System.out.println("Example 1: Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 4");
        System.out.println();
        
        // Example 2:
        int[][] matrix2 = {{1,0,1,0,1}};
        int output2 = sol.largestSubmatrix(matrix2);
        System.out.println("Example 2: Input: matrix = [[1,0,1,0,1]]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 3");
        System.out.println();
        
        // Example 3:
        int[][] matrix3 = {{1,1,0},{1,0,1}};
        int output3 = sol.largestSubmatrix(matrix3);
        System.out.println("Example 3: Input: matrix = [[1,1,0],[1,0,1]]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 2");
    }
}
