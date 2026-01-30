import java.util.*;

class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        // Create word ID mapping
        Map<String, Integer> wordId = new HashMap<>();
        for (String word : original) {
            wordId.putIfAbsent(word, wordId.size());
        }
        for (String word : changed) {
            wordId.putIfAbsent(word, wordId.size());
        }
        
        int m = wordId.size();
        long[][] dist = new long[m][m];
        long INF = Long.MAX_VALUE / 2;
        
        // Initialize distance matrix
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
        }
        
        // Build initial edges
        for (int idx = 0; idx < original.length; idx++) {
            int i = wordId.get(original[idx]);
            int j = wordId.get(changed[idx]);
            dist[i][j] = Math.min(dist[i][j], cost[idx]);
        }
        
        // Floyd-Warshall algorithm
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                if (dist[i][k] < INF) {
                    for (int j = 0; j < m; j++) {
                        if (dist[k][j] < INF) {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
        }
        
        // Build tries
        TrieNode rootOriginal = buildTrie(original, wordId);
        TrieNode rootChanged = buildTrie(changed, wordId);
        
        int n = source.length();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for (int start = 0; start < n; start++) {
            if (dp[start] == INF) continue;
            
            if (source.charAt(start) == target.charAt(start)) {
                dp[start + 1] = Math.min(dp[start + 1], dp[start]);
            }
            
            TrieNode nodeOriginal = rootOriginal;
            TrieNode nodeChanged = rootChanged;
            int end = start;
            
            while (end < n) {
                char srcChar = source.charAt(end);
                char tgtChar = target.charAt(end);
                
                if (!nodeOriginal.children.containsKey(srcChar) || 
                    !nodeChanged.children.containsKey(tgtChar)) {
                    break;
                }
                
                nodeOriginal = nodeOriginal.children.get(srcChar);
                nodeChanged = nodeChanged.children.get(tgtChar);
                end++;
                
                if (nodeOriginal.wordId != -1 && nodeChanged.wordId != -1) {
                    long newCost = dp[start] + dist[nodeOriginal.wordId][nodeChanged.wordId];
                    dp[end] = Math.min(dp[end], newCost);
                }
            }
        }
        
        return dp[n] == INF ? -1 : dp[n];
    }
    
    private TrieNode buildTrie(String[] words, Map<String, Integer> wordId) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.wordId = wordId.get(word);
        }
        return root;
    }
    
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int wordId = -1;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        String source1 = "abcd";
        String target1 = "acbe";
        String[] original1 = {"a","b","c","c","e","d"};
        String[] changed1 = {"b","c","b","e","b","e"};
        int[] cost1 = {2,5,5,1,2,20};
        long output1 = solution.minimumCost(source1, target1, original1, changed1, cost1);
        System.out.println("Test 1: source = \"abcd\", target = \"acbe\"");
        System.out.println("Output: " + output1 + ", Expected: 28");
        
        // Test case 2
        String source2 = "abcdefgh";
        String target2 = "acdeeghh";
        String[] original2 = {"bcd","fgh","thh"};
        String[] changed2 = {"cde","thh","ghh"};
        int[] cost2 = {1,3,5};
        long output2 = solution.minimumCost(source2, target2, original2, changed2, cost2);
        System.out.println("Test 2: source = \"abcdefgh\", target = \"acdeeghh\"");
        System.out.println("Output: " + output2 + ", Expected: 9");
        
        System.out.println("\nTest cases executed!");
    }
}
