import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        // Extend arrays with boundaries
        int[] hExtended = new int[hFences.length + 2];
        int[] vExtended = new int[vFences.length + 2];
        
        hExtended[0] = 1;
        hExtended[1] = m;
        for (int i = 0; i < hFences.length; i++) {
            hExtended[i + 2] = hFences[i];
        }
        
        vExtended[0] = 1;
        vExtended[1] = n;
        for (int i = 0; i < vFences.length; i++) {
            vExtended[i + 2] = vFences[i];
        }
        
        Set<Integer> stt = new HashSet<>();
        int ans = 0;
        
        // Calculate all possible horizontal distances
        for (int i = 0; i < hExtended.length; i++) {
            for (int j = i + 1; j < hExtended.length; j++) {
                stt.add(Math.abs(hExtended[j] - hExtended[i]));
            }
        }
        
        // Find maximum common distance with vertical fences
        for (int i = 0; i < vExtended.length; i++) {
            for (int j = i + 1; j < vExtended.length; j++) {
                int val = Math.abs(vExtended[j] - vExtended[i]);
                if (stt.contains(val)) {
                    ans = Math.max(ans, val);
                }
            }
        }
        
        if (ans == 0) {
            return -1;
        }
        
        long result = (long) ans * ans;
        return (int) (result % (1_000_000_007));
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int m1 = 4, n1 = 3;
        int[] hFences1 = {2, 3};
        int[] vFences1 = {2};
        int output1 = solution.maximizeSquareArea(m1, n1, hFences1, vFences1);
        System.out.println("Test 1: m=4, n=3, hFences=[2,3], vFences=[2]");
        System.out.println("Output: " + output1 + ", Expected: 4");
        
        // Test case 2
        int m2 = 6, n2 = 7;
        int[] hFences2 = {2};
        int[] vFences2 = {4};
        int output2 = solution.maximizeSquareArea(m2, n2, hFences2, vFences2);
        System.out.println("Test 2: m=6, n=7, hFences=[2], vFences=[4]");
        System.out.println("Output: " + output2 + ", Expected: -1");
        
        System.out.println("\nTest cases executed!");
    }
}
