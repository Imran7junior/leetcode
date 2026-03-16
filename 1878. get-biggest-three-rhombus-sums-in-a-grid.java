class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] diag1 = new int[m + 1][n + 1];
        int[][] diag2 = new int[m + 1][n + 2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }

        TreeSet<Integer> top3 = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                top3.add(grid[i][j]);
                if (top3.size() > 3) {
                    top3.pollFirst(); // remove smallest
                }

                for (int k = 1; i - k >= 0 && i + k < m && j - k >= 0 && j + k < n; k++) {
                    int topR = i - k, topC = j;
                    int rightR = i, rightC = j + k;
                    int bottomR = i + k, bottomC = j;
                    int leftR = i, leftC = j - k;

                    long border = 0;

                    // top -> right   (\)
                    border += diag1[rightR + 1][rightC + 1] - diag1[topR][topC];

                    // right -> bottom (/)
                    border += diag2[bottomR + 1][bottomC] - diag2[rightR][rightC + 1];

                    // left -> bottom  (\)
                    border += diag1[bottomR + 1][bottomC + 1] - diag1[leftR][leftC];

                    // top -> left     (/)
                    border += diag2[leftR + 1][leftC] - diag2[topR][topC + 1];

                    // corners counted twice
                    border -= grid[topR][topC];
                    border -= grid[rightR][rightC];
                    border -= grid[bottomR][bottomC];
                    border -= grid[leftR][leftC];

                    top3.add((int) border);
                    if (top3.size() > 3) {
                        top3.pollFirst(); // remove smallest
                    }
                }
            }
        }

        int[] ans = new int[top3.size()];
        int idx = 0;
        for (int val : top3.descendingSet()) {
            ans[idx++] = val;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int[][] grid1 = {{3,4,5,1,3},{3,3,4,2,3},{20,30,200,40,10},{1,5,5,4,1},{4,3,2,2,5}};
        int[] output1 = sol.getBiggestThree(grid1);
        System.out.println("Example 1: Input: grid = [[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]");
        System.out.print("Output: [");
        for (int i = 0; i < output1.length; i++) {
            System.out.print(output1[i]);
            if (i < output1.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [228, 216, 211]");
        System.out.println();
        
        // Example 2:
        int[][] grid2 = {{1,2,3},{4,5,6},{7,8,9}};
        int[] output2 = sol.getBiggestThree(grid2);
        System.out.println("Example 2: Input: grid = [[1,2,3],[4,5,6],[7,8,9]]");
        System.out.print("Output: [");
        for (int i = 0; i < output2.length; i++) {
            System.out.print(output2[i]);
            if (i < output2.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [20, 9, 8]");
    }
}