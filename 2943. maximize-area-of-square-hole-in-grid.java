import java.util.Arrays;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        
        int maxiH = 1, maxiV = 1, maxi = 1;
        
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] - hBars[i-1] == 1) {
                maxi++;
            } else {
                maxiH = Math.max(maxiH, maxi);
                maxi = 1;
            }
        }
        maxiH = Math.max(maxiH, maxi);
        
        maxi = 1;
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] - vBars[i-1] == 1) {
                maxi++;
            } else {
                maxiV = Math.max(maxiV, maxi);
                maxi = 1;
            }
        }
        maxiV = Math.max(maxiV, maxi);
        
        int side = Math.min(maxiH + 1, maxiV + 1);
        return side * side;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int n1 = 2, m1 = 1;
        int[] hBars1 = {2, 3};
        int[] vBars1 = {2};
        int output1 = solution.maximizeSquareHoleArea(n1, m1, hBars1, vBars1);
        System.out.println("Test 1: n=2, m=1, hBars=[2,3], vBars=[2]");
        System.out.println("Output: " + output1 + ", Expected: 4");
        
        // Test case 2
        int n2 = 1, m2 = 1;
        int[] hBars2 = {2};
        int[] vBars2 = {2};
        int output2 = solution.maximizeSquareHoleArea(n2, m2, hBars2, vBars2);
        System.out.println("Test 2: n=1, m=1, hBars=[2], vBars=[2]");
        System.out.println("Output: " + output2 + ", Expected: 4");
        
        // Test case 3
        int n3 = 2, m3 = 3;
        int[] hBars3 = {2, 3};
        int[] vBars3 = {2, 4};
        int output3 = solution.maximizeSquareHoleArea(n3, m3, hBars3, vBars3);
        System.out.println("Test 3: n=2, m=3, hBars=[2,3], vBars=[2,4]");
        System.out.println("Output: " + output3 + ", Expected: 4");
        
        System.out.println("\nTest cases executed!");
    }
}
