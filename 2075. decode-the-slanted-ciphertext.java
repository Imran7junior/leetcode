class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 0) return "";

        int n = encodedText.length();
        if (n == 0) return "";

        int cols = n / rows;

        // Step 1: Build matrix
        char[][] mat = new char[rows][cols];
        int idx = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = encodedText.charAt(idx++);
            }
        }

        // Step 2: Diagonal traversal
        StringBuilder result = new StringBuilder();

        for (int startCol = 0; startCol < cols; startCol++) {
            int i = 0, j = startCol;

            while (i < rows && j < cols) {
                result.append(mat[i][j]);
                i++;
                j++;
            }
        }

        // Step 3: Remove trailing spaces
        int end = result.length() - 1;
        while (end >= 0 && result.charAt(end) == ' ') {
            end--;
        }

        return result.substring(0, end + 1);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String encodedText1 = "ch   ie   pr";
        int rows1 = 3;
        String output1 = sol.decodeCiphertext(encodedText1, rows1);
        System.out.println("Example 1: encodedText=\"ch   ie   pr\", rows=3");
        System.out.println("Output: \"" + output1 + "\"");
        System.out.println("Expected: \"cipher\"");
        System.out.println();
        
        // Example 2
        String encodedText2 = "iveo    eed   l te   olc";
        int rows2 = 4;
        String output2 = sol.decodeCiphertext(encodedText2, rows2);
        System.out.println("Example 2: encodedText=\"iveo    eed   l te   olc\", rows=4");
        System.out.println("Output: \"" + output2 + "\"");
        System.out.println("Expected: \"i love leetcode\"");
        System.out.println();
        
        // Example 3
        String encodedText3 = "coding";
        int rows3 = 1;
        String output3 = sol.decodeCiphertext(encodedText3, rows3);
        System.out.println("Example 3: encodedText=\"coding\", rows=1");
        System.out.println("Output: \"" + output3 + "\"");
        System.out.println("Expected: \"coding\"");
    }
}