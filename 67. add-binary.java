import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
      BigInteger val1 = new BigInteger(a, 2); 
        BigInteger val2 = new BigInteger(b, 2);
        BigInteger sum = val1.add(val2);        
        return sum.toString(2);   
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String a1 = "11", b1 = "1";
        String result1 = sol.addBinary(a1, b1);
        System.out.println("Example 1: a = \"" + a1 + "\", b = \"" + b1 + "\"");
        System.out.println("Output: \"" + result1 + "\" (Expected: \"100\")\n");
        
        // Example 2
        String a2 = "1010", b2 = "1011";
        String result2 = sol.addBinary(a2, b2);
        System.out.println("Example 2: a = \"" + a2 + "\", b = \"" + b2 + "\"");
        System.out.println("Output: \"" + result2 + "\" (Expected: \"10101\")\n");
    }
}