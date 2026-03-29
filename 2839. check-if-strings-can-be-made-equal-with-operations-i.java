class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int i = 0;
        while(i < ch1.length){
            if(ch1[i] == ch2[i]){
                i++;
            }
            else{
                if(i+2 < ch1.length){
                    char temp = ch1[i];
                    ch1[i] = ch1[i+2];
                    ch1[i+2] = temp;
                }
                i++;
            }
        }
        for(int k=0;k<ch1.length;k++){
            if(ch1[k] != ch2[k]) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String s1_1 = "abcd";
        String s2_1 = "cdab";
        boolean output1 = sol.canBeEqual(s1_1, s2_1);
        System.out.println("Example 1: s1='abcd', s2='cdab'");
        System.out.println("Output: " + output1);
        System.out.println("Expected: true");
        System.out.println();
        
        // Example 2
        String s1_2 = "abcd";
        String s2_2 = "dacb";
        boolean output2 = sol.canBeEqual(s1_2, s2_2);
        System.out.println("Example 2: s1='abcd', s2='dacb'");
        System.out.println("Output: " + output2);
        System.out.println("Expected: false");
    }
}