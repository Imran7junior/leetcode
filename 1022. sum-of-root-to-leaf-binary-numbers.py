class Solution:
    def sumRootToLeaf(self, root: TreeNode) -> int:

        def dfs(node: TreeNode, n = 0)-> None:
            if not node: return

            n = 2 * n + node.val
            if not node.left and not node.right:
                self.ans+= n
                return
                
            dfs(node.left , n)
            dfs(node.right, n)
            return
            

        self.ans = 0
        dfs(root)
        return self.ans

# Definition for a binary tree node (for testing)
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1: [1,0,1,0,1,0,1]
    #       1
    #      / \
    #     0   1
    #    / \ / \
    #   0  1 0  1
    root1 = TreeNode(1)
    root1.left = TreeNode(0)
    root1.right = TreeNode(1)
    root1.left.left = TreeNode(0)
    root1.left.right = TreeNode(1)
    root1.right.left = TreeNode(0)
    root1.right.right = TreeNode(1)
    
    output1 = sol.sumRootToLeaf(root1)
    print(f"Example 1: Input: root = [1,0,1,0,1,0,1]")
    print(f"Output: {output1}")
    print(f"Expected: 22")
    print()
    
    # Example 2: [0]
    root2 = TreeNode(0)
    output2 = sol.sumRootToLeaf(root2)
    print(f"Example 2: Input: root = [0]")
    print(f"Output: {output2}")
    print(f"Expected: 0")