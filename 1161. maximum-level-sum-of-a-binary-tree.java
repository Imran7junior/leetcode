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
    public int maxLevelSum(TreeNode root) {
        int currLvl = 1;
        int maxi = Integer.MIN_VALUE;
        int ans = 1;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int currSum = 0;
            int lvlSize = queue.size();
            
            for (int i = 0; i < lvlSize; i++) {
                TreeNode node = queue.poll();
                currSum += node.val;
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            if (currSum > maxi) {
                maxi = currSum;
                ans = currLvl;
            }
            
            currLvl++;
        }
        
        return ans;
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
        Solution solution = new Solution();
        
        // Example 1: root = [1,7,0,7,-8,null,null]
        // Level 1 sum = 1
        // Level 2 sum = 7 + 0 = 7
        // Level 3 sum = 7 + -8 = -1
        // Expected output: 2
        TreeNode root1 = buildTree(new Integer[]{1, 7, 0, 7, -8, null, null});
        int result1 = solution.maxLevelSum(root1);
        System.out.println("Example 1: " + result1);
        assert result1 == 2 : "Expected 2, got " + result1;
        
        // Example 2: root = [989,null,10250,98693,-89388,null,null,null,-32127]
        // Expected output: 2
        TreeNode root2 = buildTree(new Integer[]{989, null, 10250, 98693, -89388, null, null, null, -32127});
        int result2 = solution.maxLevelSum(root2);
        System.out.println("Example 2: " + result2);
        assert result2 == 2 : "Expected 2, got " + result2;
        
        System.out.println("All test cases passed!");
    }
}
