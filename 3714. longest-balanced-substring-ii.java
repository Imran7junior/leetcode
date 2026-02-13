import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestBalanced(String s) {
        char[] cs = s.toCharArray();
        int x = calc1(cs);
        int y = Math.max(calc2(cs, 'a', 'b'), Math.max(calc2(cs, 'b', 'c'), calc2(cs, 'a', 'c')));
        int z = calc3(cs);
        return Math.max(x, Math.max(y, z));
    }

    private int calc1(char[] s) {
        int res = 0;
        int i = 0, n = s.length;
        while (i < n) {
            int j = i + 1;
            while (j < n && s[j] == s[i]) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j;
        }
        return res;
    }

    private int calc2(char[] s, char a, char b) {
        int res = 0;
        int i = 0, n = s.length;
        while (i < n) {
            while (i < n && s[i] != a && s[i] != b) {
                i++;
            }
            Map<Integer, Integer> pos = new HashMap<>();
            pos.put(0, i - 1);
            int d = 0;
            while (i < n && (s[i] == a || s[i] == b)) {
                d += (s[i] == a) ? 1 : -1;
                Integer prev = pos.get(d);
                if (prev != null) {
                    res = Math.max(res, i - prev);
                } else {
                    pos.put(d, i);
                }
                i++;
            }
        }
        return res;
    }

    private int calc3(char[] s) {
        Map<Long, Integer> pos = new HashMap<>();
        pos.put(f(0, 0), -1);

        int[] cnt = new int[3];
        int res = 0;

        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            ++cnt[c - 'a'];
            int x = cnt[0] - cnt[1];
            int y = cnt[1] - cnt[2];
            long k = f(x, y);

            Integer prev = pos.get(k);
            if (prev != null) {
                res = Math.max(res, i - prev);
            } else {
                pos.put(k, i);
            }
        }
        return res;
    }

    private long f(int x, int y) {
        return (x + 100000) << 20 | (y + 100000);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String s1 = "abbac";
        int result1 = sol.longestBalanced(s1);
        System.out.println("Example 1: s = \"" + s1 + "\" -> " + result1 + " (Expected: 4)");
        System.out.println("Explanation: The longest balanced substring is \"abba\" because both distinct characters 'a' and 'b' each appear exactly 2 times.\n");
        
        // Example 2
        String s2 = "aabcc";
        int result2 = sol.longestBalanced(s2);
        System.out.println("Example 2: s = \"" + s2 + "\" -> " + result2 + " (Expected: 3)");
        System.out.println("Explanation: The longest balanced substring is \"abc\" because all distinct characters 'a', 'b' and 'c' each appear exactly 1 time.\n");
        
        // Example 3
        String s3 = "aba";
        int result3 = sol.longestBalanced(s3);
        System.out.println("Example 3: s = \"" + s3 + "\" -> " + result3 + " (Expected: 2)\n");
    }
}