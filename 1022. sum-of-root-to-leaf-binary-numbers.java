class Solution {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        solve(root, 0);
        return sum;
    }
    void solve(TreeNode root, int currSum) {
        if (root==null) return;
        if (root.left==null && root.right==null) {
            currSum=(currSum<<1)|root.val;
            sum+=currSum;
            return;
        }
        currSum=(currSum<<1)|root.val;
        solve(root.left, currSum);solve(root.right, currSum);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1: [1,0,1,0,1,0,1]
        //       1
        //      / \
        //     0   1
        //    / \ / \
        //   0  1 0  1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(0);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(1);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(1);
        
        int output1 = sol.sumRootToLeaf(root1);
        System.out.println("Example 1: Input: root = [1,0,1,0,1,0,1]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 22");
        System.out.println();
        
        // Example 2: [0]
        TreeNode root2 = new TreeNode(0);
        int output2 = sol.sumRootToLeaf(root2);
        System.out.println("Example 2: Input: root = [0]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 0");
    }
    
    // TreeNode definition for main method
    static class TreeNode {
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
}