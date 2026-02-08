class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private boolean balanced = true;
    
    public boolean isBalanced(TreeNode root) {
        balanced = true;
        dfs(root);
        return balanced;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int l = dfs(node.left);
        int r = dfs(node.right);
        
        if (Math.abs(l - r) > 1) {
            balanced = false;
        }
        
        return Math.max(l, r) + 1;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1: root = [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(sol.isBalanced(root1));  // Expected: true
        
        // Example 2: root = [1,2,2,3,3,null,null,4,4]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        System.out.println(sol.isBalanced(root2));  // Expected: false
        
        // Example 3: root = []
        TreeNode root3 = null;
        System.out.println(sol.isBalanced(root3));  // Expected: true
    }
}
