class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return letters[left % letters.length];
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        char[] letters1 = {'c', 'f', 'j'};
        char target1 = 'a';
        char output1 = solution.nextGreatestLetter(letters1, target1);
        System.out.println("Test 1: letters = [\"c\",\"f\",\"j\"], target = \"a\"");
        System.out.println("Output: \"" + output1 + "\", Expected: \"c\"");
        
        // Test case 2
        char[] letters2 = {'c', 'f', 'j'};
        char target2 = 'c';
        char output2 = solution.nextGreatestLetter(letters2, target2);
        System.out.println("Test 2: letters = [\"c\",\"f\",\"j\"], target = \"c\"");
        System.out.println("Output: \"" + output2 + "\", Expected: \"f\"");
        
        // Test case 3
        char[] letters3 = {'x', 'x', 'y', 'y'};
        char target3 = 'z';
        char output3 = solution.nextGreatestLetter(letters3, target3);
        System.out.println("Test 3: letters = [\"x\",\"x\",\"y\",\"y\"], target = \"z\"");
        System.out.println("Output: \"" + output3 + "\", Expected: \"x\"");
        
        System.out.println("\nTest cases executed!");
    }
}
