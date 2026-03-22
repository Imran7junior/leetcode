import java.util.*;

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (isEqual(mat, target)) return true;
            rotate(mat);
        }
        return false;
    }

    private void rotate(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
    }

    private boolean isEqual(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[][] mat1 = {{0,1},{1,0}};
        int[][] target1 = {{1,0},{0,1}};
        boolean output1 = sol.findRotation(mat1, target1);
        System.out.println("Example 1: mat=[[0,1],[1,0]], target=[[1,0],[0,1]]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: true");
        System.out.println();
        
        // Example 2
        int[][] mat2 = {{0,1},{1,1}};
        int[][] target2 = {{1,0},{0,1}};
        boolean output2 = sol.findRotation(mat2, target2);
        System.out.println("Example 2: mat=[[0,1],[1,1]], target=[[1,0],[0,1]]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: false");
        System.out.println();
        
        // Example 3
        int[][] mat3 = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] target3 = {{1,1,1},{0,1,0},{0,0,0}};
        boolean output3 = sol.findRotation(mat3, target3);
        System.out.println("Example 3: mat=[[0,0,0],[0,1,0],[1,1,1]], target=[[1,1,1],[0,1,0],[0,0,0]]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: true");
    }
}