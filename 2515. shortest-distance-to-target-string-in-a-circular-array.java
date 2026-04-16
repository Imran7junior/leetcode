class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int clockwise = (i - startIndex + n) % n;
                int anticlockwise = (startIndex - i + n) % n;
                ans = Math.min(ans, Math.min(clockwise, anticlockwise));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String[] words1 = {"hello","i","am","leetcode","hello"};
        String target1 = "hello";
        int startIndex1 = 1;
        int output1 = sol.closestTarget(words1, target1, startIndex1);
        System.out.println("Example 1: words=[hello,i,am,leetcode,hello], target='hello', startIndex=1");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 2
        String[] words2 = {"a","b","leetcode"};
        String target2 = "leetcode";
        int startIndex2 = 0;
        int output2 = sol.closestTarget(words2, target2, startIndex2);
        System.out.println("Example 2: words=[a,b,leetcode], target='leetcode', startIndex=0");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 3
        String[] words3 = {"i","eat","leetcode"};
        String target3 = "ate";
        int startIndex3 = 0;
        int output3 = sol.closestTarget(words3, target3, startIndex3);
        System.out.println("Example 3: words=[i,eat,leetcode], target='ate', startIndex=0");
        System.out.println("Output: " + output3);
        System.out.println("Expected: -1");
    }
}