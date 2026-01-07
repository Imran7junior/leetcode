import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private static final int MOD = 1000000007;
    private long total;
    private long ans;
    
    public int maxProduct(TreeNode root) {
        ans = 0;
        
        // First DFS to calculate total sum and update node values
        total = dfs(root);
        
        // Second traversal to find maximum product
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            
            long currentProduct = (total - node.val) * node.val;
            ans = Math.max(ans, currentProduct);
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        return (int)(ans % MOD);
    }
    
    private long dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        node.val += dfs(node.left) + dfs(node.right);
        return node.val;
    }
    
    // Helper function to build tree from level-order list
    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();
            
            if (i < values.length && values[i] != null) {
                node.left = new TreeNode(values[i]);
                queue.offer(node.left);
            }
            i++;
            
            if (i < values.length && values[i] != null) {
                node.right = new TreeNode(values[i]);
                queue.offer(node.right);
            }
            i++;
        }
        
        return root;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test case 1: root = [1,null,2,3,4,null,null,5,6]
        // Expected output: 90
        TreeNode root1 = buildTree(new Integer[]{1, null, 2, 3, 4, null, null, 5, 6});
        int result1 = sol.maxProduct(root1);
        System.out.println("Test 1: " + result1);
        assert result1 == 90 : "Expected 90, got " + result1;
        
        // Test case 2: root = [1,2,3,4,5,6]
        // Expected output: 110
        TreeNode root2 = buildTree(new Integer[]{1, 2, 3, 4, 5, 6});
        int result2 = sol.maxProduct(root2);
        System.out.println("Test 2: " + result2);
        assert result2 == 110 : "Expected 110, got " + result2;
        
        System.out.println("All test cases passed!");
    }
}
