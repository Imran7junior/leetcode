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

    private static class Pair {
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    private Pair dfs(TreeNode root) {
        if (root == null) return new Pair(null, 0);

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        } else if (left.depth < right.depth) {
            return new Pair(right.node, right.depth + 1);
        } else {
            return new Pair(root, left.depth + 1);
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
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
        
        // Test case 1: root = [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode root1 = buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode result1 = sol.subtreeWithAllDeepest(root1);
        System.out.println("Test 1 - Result node value: " + (result1 != null ? result1.val : null));
        
        // Test case 2: root = [1]
        TreeNode root2 = buildTree(new Integer[]{1});
        TreeNode result2 = sol.subtreeWithAllDeepest(root2);
        System.out.println("Test 2 - Result node value: " + (result2 != null ? result2.val : null));
        
        // Test case 3: root = [0,1,3,null,2]
        TreeNode root3 = buildTree(new Integer[]{0, 1, 3, null, 2});
        TreeNode result3 = sol.subtreeWithAllDeepest(root3);
        System.out.println("Test 3 - Result node value: " + (result3 != null ? result3.val : null));
        
        System.out.println("All test cases executed!");
    }
}