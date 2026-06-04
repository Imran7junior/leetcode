class Solution {

    private int waviness(int x) {
        String s = Integer.toString(x);

        int cnt = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            char cur = s.charAt(i);

            if ((cur > s.charAt(i - 1) && cur > s.charAt(i + 1)) ||
                (cur < s.charAt(i - 1) && cur < s.charAt(i + 1))) {
                cnt++;
            }
        }

        return cnt;
    }

    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int x = num1; x <= num2; x++) {
            ans += waviness(x);
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int num1_1 = 120;
        int num2_1 = 130;
        int output1 = sol.totalWaviness(num1_1, num2_1);
        System.out.println("Example 1: num1=120, num2=130");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 3");
        System.out.println();
        
        // Example 2
        int num1_2 = 198;
        int num2_2 = 202;
        int output2 = sol.totalWaviness(num1_2, num2_2);
        System.out.println("Example 2: num1=198, num2=202");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 3");
        System.out.println();
        
        // Example 3
        int num1_3 = 4848;
        int num2_3 = 4848;
        int output3 = sol.totalWaviness(num1_3, num2_3);
        System.out.println("Example 3: num1=4848, num2=4848");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 2");
    }
}