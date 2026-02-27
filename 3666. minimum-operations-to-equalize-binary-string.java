class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();

        TreeSet<Integer>[] ts = new TreeSet[2];
        Arrays.setAll(ts, i -> new TreeSet<>());

        for (int i = 0; i <= n; i++) {
            ts[i % 2].add(i);
        }

        int cnt0 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                cnt0++;
            }
        }

        ts[cnt0 % 2].remove(cnt0);

        Deque<Integer> q = new ArrayDeque<>();
        q.offer(cnt0);

        int ans = 0;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; --size) {
                int cur = q.poll();
                if (cur == 0) {
                    return ans;
                }

                int l = cur + k - 2 * Math.min(cur, k);
                int r = cur + k - 2 * Math.max(k - n + cur, 0);

                TreeSet<Integer> t = ts[l % 2];

                Integer next = t.ceiling(l);
                while (next != null && next <= r) {
                    q.offer(next);
                    t.remove(next);
                    next = t.ceiling(l);
                }
            }
            ans++;
        }

        return -1;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        String s1 = "110";
        int k1 = 1;
        int output1 = sol.minOperations(s1, k1);
        System.out.println("Example 1: Input: s = " + s1 + ", k = " + k1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 2:
        String s2 = "0101";
        int k2 = 3;
        int output2 = sol.minOperations(s2, k2);
        System.out.println("Example 2: Input: s = " + s2 + ", k = " + k2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: 2");
        System.out.println();
        
        // Example 3:
        String s3 = "101";
        int k3 = 2;
        int output3 = sol.minOperations(s3, k3);
        System.out.println("Example 3: Input: s = " + s3 + ", k = " + k3);
        System.out.println("Output: " + output3);
        System.out.println("Expected: -1");
    }
}