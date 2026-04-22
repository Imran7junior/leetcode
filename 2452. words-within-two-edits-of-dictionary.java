class Solution {
    boolean hasMatch(String query, String[] dictionary) {
        boolean found = false;
        for (String dict : dictionary) {
            int diffMax = 2;
            for (int i=0;i<dict.length();i++) {
                if (dict.charAt(i) != query.charAt(i)) {
                    diffMax--;
                }
                if (diffMax < 0) {
                    break;
                }
            }
            if (diffMax >= 0) {
                return true;
            }
        }

        return found;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {

        List<String> result = new ArrayList<>();
        for (String query : queries) {
            if (hasMatch(query, dictionary)) {
                result.add(query);
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String[] queries1 = {"word","note","ants","wood"};
        String[] dictionary1 = {"wood","joke","moat"};
        List<String> output1 = sol.twoEditWords(queries1, dictionary1);
        System.out.println("Example 1: queries=[\"word\",\"note\",\"ants\",\"wood\"], dictionary=[\"wood\",\"joke\",\"moat\"]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: [word, note, wood]");
        System.out.println();
        
        // Example 2
        String[] queries2 = {"yes"};
        String[] dictionary2 = {"not"};
        List<String> output2 = sol.twoEditWords(queries2, dictionary2);
        System.out.println("Example 2: queries=[\"yes\"], dictionary=[\"not\"]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: []");
    }
}