import java.util.*;
class Solution {
    public String getHappyString(int n, int k) {
        Queue<String> q = new LinkedList<>();
        q.offer("a");
        q.offer("b");
        q.offer("c");
        List<String> happyStrings = new ArrayList<>();
        
        while (!q.isEmpty()) {
            String s = q.poll();
            if (s.length() == n) {
                happyStrings.add(s);
                continue;
            }
            for (char ch : new char[]{'a', 'b', 'c'}) {
                if (s.charAt(s.length() - 1) != ch) {
                    q.offer(s + ch);
                }
            }
        }
        
        return k > happyStrings.size() ? "" : happyStrings.get(k - 1);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int n1 = 1;
        int k1 = 3;
        String output1 = sol.getHappyString(n1, k1);
        System.out.println("Example 1: Input: n = " + n1 + ", k = " + k1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: c");
        System.out.println();
        
        // Example 2:
        int n2 = 1;
        int k2 = 4;
        String output2 = sol.getHappyString(n2, k2);
        System.out.println("Example 2: Input: n = " + n2 + ", k = " + k2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: (empty string)");
        System.out.println();
        
        // Example 3:
        int n3 = 3;
        int k3 = 9;
        String output3 = sol.getHappyString(n3, k3);
        System.out.println("Example 3: Input: n = " + n3 + ", k = " + k3);
        System.out.println("Output: " + output3);
        System.out.println("Expected: cab");
    }
}