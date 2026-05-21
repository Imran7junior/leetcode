class Solution {
    public int digits(int x) {
        int cnt = 0;
        while(x > 0) {
            cnt++;
            x /= 10;
        }
        return cnt;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes =new HashSet<>();

        // storing all prefixes of arr1
        for(int num : arr1) {
            int x = num;
            while(x > 0) {
                prefixes.add(x);
                x /= 10;
            }
        }

        int ans = 0;

        // check prefixes of arr2 numbers
        for(int num : arr2) {
            int x = num;
            int len = digits(num);

            // checking from larger => smaller
            while(x > 0) {
                if(prefixes.contains(x)) {
                    ans = Math.max(ans, len);
                    // first match is the longest
                    // so we stop
                    break;
                }

                x /= 10;
                len--;
            }
        }

        return ans;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] arr1_1 = {1, 10, 100};
        int[] arr2_1 = {1000};
        int result1 = solution.longestCommonPrefix(arr1_1, arr2_1);
        System.out.println("Example 1: Input: arr1 = [1, 10, 100], arr2 = [1000]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 3\n");
        
        // Example 2
        int[] arr1_2 = {1, 2, 3};
        int[] arr2_2 = {4, 4, 4};
        int result2 = solution.longestCommonPrefix(arr1_2, arr2_2);
        System.out.println("Example 2: Input: arr1 = [1, 2, 3], arr2 = [4, 4, 4]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 0");
    }
}