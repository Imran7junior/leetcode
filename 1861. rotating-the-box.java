class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int  n = boxGrid.length;
        int m = boxGrid[0].length;

        for(int i=0; i<n; i++){
            int empty = m - 1;
            for(int j=m-1; j>=0; j--){
                if(boxGrid[i][j] =='*'){
                    empty = j - 1;
                }else if(boxGrid[i][j] == '#'){
                    boxGrid[i][j] = '.';
                    boxGrid[i][empty] = '#';
                    empty--;
                }
            }
        }

        char[][] result = new char[m][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                result[j][n-i-1] = boxGrid[i][j];
            }
        }

        return result;
    }
    
    // Helper function to print 2D char array
    private static void print2DArray(char[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("\"");
                System.out.print(arr[i][j]);
                System.out.print("\"");
                if (j < arr[i].length - 1) System.out.print(",");
            }
            System.out.print("]");
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        char[][] boxGrid1 = {{"#", ".", "#".toCharArray()[0]}};
        boxGrid1[0] = new char[]{'#', '.', '#'};
        char[][] result1 = solution.rotateTheBox(boxGrid1);
        System.out.println("Example 1: Input: boxGrid = [[\"#\",\".\",\"#\"]]\n");
        System.out.print("Output: ");
        print2DArray(result1);
        System.out.println("Expected: [[\".\"], [\"#\"], [\"#\"]]\n");
        
        // Example 2
        char[][] boxGrid2 = {{'#', '.', '*', '.'}, {'#', '#', '*', '.'}};
        char[][] result2 = solution.rotateTheBox(boxGrid2);
        System.out.println("Example 2: Input: boxGrid = [[\"#\",\".\",\"*\",\".\"],[\"#\",\"#\",\"*\",\".\"]]\n");
        System.out.print("Output: ");
        print2DArray(result2);
        System.out.println("Expected: [[\"#\",\".\"], [\"#\",\"#\"], [\"*\",\"*\"], [\".\",\".\"]]\n");
        
        // Example 3
        char[][] boxGrid3 = {{'#', '#', '*', '.', '*', '.'}, {'#', '#', '#', '*', '.', '.'}, {'#', '#', '#', '.', '#', '.'}};
        char[][] result3 = solution.rotateTheBox(boxGrid3);
        System.out.println("Example 3: Input: boxGrid = [[\"#\",\"#\",\"*\",\".\",\"*\",\".\"],[\"#\",\"#\",\"#\",\"*\",\".\",\".\"],[\"#\",\"#\",\"#\",\".\",\"#\",\".\"]]\n");
        System.out.print("Output: ");
        print2DArray(result3);
        System.out.println("Expected: [[\".\",\"#\",\"#\"], [\".\",\"#\",\"#\"], [\"*\",\"*\",\"*\"], [\"#\",\"*\",\".\"], [\"#\",\".\",\"*\"], [\"#\",\".\",\".\"]]\n");
    }
}