class Solution {
    public int minimumDeletions(String s) {
        int b_before_a = 0, deletion = 0;
        for(char ch : s.toCharArray()) {
            if(ch == 'b') b_before_a += 1;
            else if(b_before_a > 0 ) {
                b_before_a -= 1;
                deletion += 1;
            }
        }   
        return deletion;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String s1 = "aababbab";
        System.out.println(sol.minimumDeletions(s1));  // Expected: 2
        
        // Example 2
        String s2 = "bbaaaaabb";
        System.out.println(sol.minimumDeletions(s2));  // Expected: 2
    }
}