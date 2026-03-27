class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    if (mat[i][j] != mat[i][(j - k % n + n) % n]) {
                        return false;
                    }
                } else {
                    if (mat[i][j] != mat[i][(j + k % n) % n]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[][] mat1 = {{1,2,3},{4,5,6},{7,8,9}};
        int k1 = 4;
        boolean output1 = sol.areSimilar(mat1, k1);
        System.out.println("Example 1: mat=[[1,2,3],[4,5,6],[7,8,9]], k=4");
        System.out.println("Output: " + output1);
        System.out.println("Expected: false");
        System.out.println();
        
        // Example 2
        int[][] mat2 = {{1,2,1,2},{5,5,5,5},{6,3,6,3}};
        int k2 = 2;
        boolean output2 = sol.areSimilar(mat2, k2);
        System.out.println("Example 2: mat=[[1,2,1,2],[5,5,5,5],[6,3,6,3]], k=2");
        System.out.println("Output: " + output2);
        System.out.println("Expected: true");
        System.out.println();
        
        // Example 3
        int[][] mat3 = {{2,2},{2,2}};
        int k3 = 3;
        boolean output3 = sol.areSimilar(mat3, k3);
        System.out.println("Example 3: mat=[[2,2],[2,2]], k=3");
        System.out.println("Output: " + output3);
        System.out.println("Expected: true");
    }
}