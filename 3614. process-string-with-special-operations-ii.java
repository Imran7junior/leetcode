class Solution {
    public char processStr(String s, long k) {
        long len = 0;

        // Step 1
        for (char c : s.toCharArray()) {
            if (c == '*') len = Math.max(0, len - 1);
            else if (c == '#') len *= 2;
            else if (c != '%') len++;
        }

        if (k >= len) return '.';

        // Step 2
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '*') len++;

            else if (c == '#') {
                long half = len / 2;
                if (k >= half) k -= half;
                len = half;
            }

            else if (c == '%') {
                k = len - 1 - k;
            }

            else {
                if (k == len - 1) return c;
                len--;
            }
        }

        return '.';
    }
	
	public static void main(String[] args) {
        Solution sol = new Solution();
 
        System.out.println(sol.processStr("a#b%*", 1));   // 'a'
        System.out.println(sol.processStr("cd%#*#", 3));  // 'd'
        System.out.println(sol.processStr("z*#", 0));     // '.'
    
}