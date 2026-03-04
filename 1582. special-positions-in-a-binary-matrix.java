class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int[][] mat1 = {{1,0,0},{0,0,1},{1,0,0}};
        int output1 = sol.numSpecial(mat1);
        System.out.println("Example 1: Input: mat = [[1,0,0],[0,0,1],[1,0,0]]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 2:
        int[][] mat2 = {{1,0,0},{0,1,0},{0,0,1}};
        int output2 = sol.numSpecial(mat2);
        System.out.println("Example 2: Input: mat = [[1,0,0],[0,1,0],[0,0,1]]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 3");
    }
}