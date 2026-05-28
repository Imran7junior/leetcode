class Solution {

    static class Node {
        int[] child;
        int idx;

        Node() {
            child = new int[26];
            Arrays.fill(child, -1);
            idx = -1;
        }
    }

    List<Node> trie = new ArrayList<>();

    // update best index according to:
    // 1. smaller length
    // 2. earlier index
    void updateIndex(int storedIdx,int newIdx,String[] wordsContainer,int node) {
        if(storedIdx == -1) {
            trie.get(node).idx = newIdx;
            return;
        }

        int oldLen =wordsContainer[storedIdx].length();
        int newLen =wordsContainer[newIdx].length();

        if(newLen < oldLen) {
            trie.get(node).idx = newIdx;
        }
        else if(newLen == oldLen && newIdx < storedIdx) {
            trie.get(node).idx = newIdx;
        }
    }

    public int[] stringIndices(String[] wordsContainer,String[] wordsQuery) {
        trie.add(new Node()); // root node

        // build reverse trie
        for(int i = 0;i < wordsContainer.length;i++) {

            String word =new StringBuilder(wordsContainer[i]).reverse().toString();

            int node = 0;

            // update root answer
            updateIndex(trie.get(node).idx,i,wordsContainer,node);

            for(char ch : word.toCharArray()) {
                int c = ch - 'a';

                if(trie.get(node).child[c] == -1) {
                    trie.get(node).child[c] =trie.size();
                    trie.add(new Node());
                }

                node = trie.get(node).child[c];

                updateIndex(trie.get(node).idx,i,wordsContainer,node);
            }
        }

        int[] ans =new int[wordsQuery.length];

        // process queries
        for(int i = 0;i < wordsQuery.length;i++) {

            String query =new StringBuilder(wordsQuery[i]).reverse().toString();

            int node = 0;

            for(char ch : query.toCharArray()) {
                int c = ch - 'a';

                if(trie.get(node).child[c] == -1) {
                    break;
                }
                node = trie.get(node).child[c];
            }

            ans[i] = trie.get(node).idx;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String[] wordsContainer1 = {"abcd","bcd","xbcd"};
        String[] wordsQuery1 = {"cd","bcd","xyz"};
        int[] output1 = sol.stringIndices(wordsContainer1, wordsQuery1);
        System.out.println("Example 1: wordsContainer=[abcd,bcd,xbcd], wordsQuery=[cd,bcd,xyz]");
        System.out.print("Output: [");
        for(int i = 0; i < output1.length; i++) {
            if(i > 0) System.out.print(",");
            System.out.print(output1[i]);
        }
        System.out.println("]");
        System.out.println("Expected: [1,1,1]");
        System.out.println();
        
        // Example 2
        String[] wordsContainer2 = {"abcdefgh","poiuygh","ghghgh"};
        String[] wordsQuery2 = {"gh","acbfgh","acbfegh"};
        int[] output2 = sol.stringIndices(wordsContainer2, wordsQuery2);
        System.out.println("Example 2: wordsContainer=[abcdefgh,poiuygh,ghghgh], wordsQuery=[gh,acbfgh,acbfegh]");
        System.out.print("Output: [");
        for(int i = 0; i < output2.length; i++) {
            if(i > 0) System.out.print(",");
            System.out.print(output2[i]);
        }
        System.out.println("]");
        System.out.println("Expected: [2,0,2]");
    }
}