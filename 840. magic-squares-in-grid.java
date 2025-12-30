import java.util.*;

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        if (r < 3 || c < 3) return 0;

        int count = 0;
        for (int i = 1; i < r - 1; i++) {
            for (int j = 1; j < c - 1; j++) {
                if (grid[i][j] == 5 && isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagic(int[][] grid, int i, int j) {
        boolean[] once = new boolean[10];
        int[] rowSum = new int[3];
        int[] colSum = new int[3];

        for (int a = i - 1; a <= i + 1; a++) {
            for (int b = j - 1; b <= j + 1; b++) {
                int x = grid[a][b];

                if (x < 1 || x > 9) return false;

                rowSum[a - i + 1] += x;
                colSum[b - j + 1] += x;

                if (once[x]) return false; // not unique
                once[x] = true;
            }
        }

        // Check all numbers 1 to 9 are present
        for (int k = 1; k <= 9; k++) {
            if (!once[k]) return false;
        }

        // Check row sums
        for (int sum : rowSum) {
            if (sum != 15) return false;
        }

        // Check column sums
        for (int sum : colSum) {
            if (sum != 15) return false;
        }

        // Check diagonals
        return grid[i - 1][j - 1] + grid[i + 1][j + 1] == 10
            && grid[i + 1][j - 1] + grid[i - 1][j + 1] == 10;
    }
	public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = {
            {4, 3, 8, 4},
            {9, 5, 1, 9},
            {2, 7, 6, 2}
        };
        System.out.println(sol.numMagicSquaresInside(grid1)); // Expected: 1

        int[][] grid2 = {
            {8}
        };
        System.out.println(sol.numMagicSquaresInside(grid2)); // Expected: 0
    }

}
