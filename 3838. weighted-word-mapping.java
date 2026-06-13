class Solution {
    public String mapWordWeights(String[] words, int[] wt) {
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            int s = 0;
            for (int i = 0; i < word.length(); i++) 
                s += wt[(word.charAt(i) & (1 << 5) - 1) - 1];
            
            sb.append((char) ('z' - (s - ((s * 2521) >> (1 << 4)) * 26)));
        }

        return sb.toString();
    }
}

class TestWeightedWordMapping {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        String[] words1 = new String[]{"abcd","def","xyz"};
        int[] weights1 = new int[]{5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        String out1 = sol.mapWordWeights(words1, weights1);
        System.out.println("Example 1: words=[abcd,def,xyz]");
        System.out.println("Output: " + out1);
        System.out.println("Expected: rij");
        System.out.println();

        // Example 2
        String[] words2 = new String[]{"a","b","c"};
        int[] weights2 = new int[26];
        java.util.Arrays.fill(weights2, 1);
        String out2 = sol.mapWordWeights(words2, weights2);
        System.out.println("Example 2: words=[a,b,c]");
        System.out.println("Output: " + out2);
        System.out.println("Expected: yyy");
        System.out.println();

        // Example 3
        String[] words3 = new String[]{"abcd"};
        int[] weights3 = new int[]{7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5};
        String out3 = sol.mapWordWeights(words3, weights3);
        System.out.println("Example 3: words=[abcd]");
        System.out.println("Output: " + out3);
        System.out.println("Expected: g");
    }
}