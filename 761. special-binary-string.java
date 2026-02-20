class Solution {
    public String makeLargestSpecial(String s) {
        int cnt =0;
        List<String> list = new LinkedList<>();
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                cnt++;
            else cnt--;
            if(cnt==0)
            {
                list.add('1'+makeLargestSpecial(s.substring(j+1,i))+'0');
                j= i+1;
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        return String.join("",list);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        String s1 = "11011000";
        String output1 = sol.makeLargestSpecial(s1);
        System.out.println("Example 1: Input: s = " + s1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 11100100");
        System.out.println();
        
        // Example 2:
        String s2 = "10";
        String output2 = sol.makeLargestSpecial(s2);
        System.out.println("Example 2: Input: s = " + s2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 10");
    }
}