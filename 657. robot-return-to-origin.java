class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char m : moves.toCharArray()) {
            if (m == 'R') x++;
            else if (m == 'L') x--;
            else if (m == 'U') y++;
            else if (m == 'D') y--;
        }
        return x == 0 && y == 0;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String moves1 = "UD";
        boolean output1 = sol.judgeCircle(moves1);
        System.out.println("Example 1: moves='UD'");
        System.out.println("Output: " + output1);
        System.out.println("Expected: true");
        System.out.println();
        
        // Example 2
        String moves2 = "LL";
        boolean output2 = sol.judgeCircle(moves2);
        System.out.println("Example 2: moves='LL'");
        System.out.println("Output: " + output2);
        System.out.println("Expected: false");
    }
}