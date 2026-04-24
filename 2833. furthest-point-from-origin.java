class Solution {
    public int furthestDistanceFromOrigin(String m) {
        int l = 0, r = 0, d = 0;
        for(int i = 0;i<m.length();i++){
            if(m.charAt(i)=='L') l++;
            else if(m.charAt(i)=='R') r++;
            else d++;
        }
        return l>r?l+d-r:r+d-l;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String moves1 = "L_RL__R";
        int output1 = sol.furthestDistanceFromOrigin(moves1);
        System.out.println("Example 1: moves=\"L_RL__R\"");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 3");
        System.out.println();
        
        // Example 2
        String moves2 = "_R__LL_";
        int output2 = sol.furthestDistanceFromOrigin(moves2);
        System.out.println("Example 2: moves=\"_R__LL_\"");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 5");
        System.out.println();
        
        // Example 3
        String moves3 = "_______";
        int output3 = sol.furthestDistanceFromOrigin(moves3);
        System.out.println("Example 3: moves=\"_______\"");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 7");
    }
}