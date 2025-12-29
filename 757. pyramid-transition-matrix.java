import java.util.*;

class Solution {
    private Map<String, List<Character>> mp;
    private Map<String, Boolean> memo;
    
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Build a mapping: pair -> [possible_top_blocks]
        mp = new HashMap<>();
        for (String a : allowed) {
            String key = a.substring(0, 2);
            mp.computeIfAbsent(key, k -> new ArrayList<>()).add(a.charAt(2));
        }
        
        memo = new HashMap<>();
        return dfs(bottom);
    }
    
    private boolean dfs(String row) {
        // If we've reached a single block, pyramid is complete
        if (row.length() == 1) {
            return true;
        }
        
        // Check if we've already computed this row
        if (memo.containsKey(row)) {
            return memo.get(row);
        }
        
        // Try to build the next level
        boolean result = build(row, 0, "");
        memo.put(row, result);
        return result;
    }
    
    private boolean build(String row, int i, String path) {
        // If we've finished building the next level
        if (i == row.length() - 1) {
            return dfs(path);
        }
        
        // Get the pair of blocks at position i and i+1
        String pair = row.substring(i, i + 2);
        
        // Check if this pair has any allowed blocks
        if (!mp.containsKey(pair)) {
            return false;
        }
        
        // Try all possible blocks that can be placed on top
        for (char ch : mp.get(pair)) {
            if (build(row, i + 1, path + ch)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String bottom1 = "BCD";
        List<String> allowed1 = Arrays.asList("BCC", "CDE", "CEA", "FFF");
        boolean result1 = solution.pyramidTransition(bottom1, allowed1);
        System.out.println("Test 1: bottom='" + bottom1 + "', allowed=" + allowed1);
        System.out.println("Output: " + result1 + ", Expected: true\n");
    }
}