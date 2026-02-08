from typing import Optional


class TreeNode:
	def __init__(self, val=0, left=None, right=None):
		self.val = val
		self.left = left
		self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.balanced = True

        def dfs(node):
            if node is None:
                return 0

            l = dfs(node.left)
            r = dfs(node.right)

            if abs(l - r) > 1:
                self.balanced = False

            return max(l, r) + 1

        dfs(root)
        return self.balanced


if __name__ == "__main__":
    sol = Solution()
    
    # Example 1: root = [3,9,20,null,null,15,7]
    root1 = TreeNode(3)
    root1.left = TreeNode(9)
    root1.right = TreeNode(20)
    root1.right.left = TreeNode(15)
    root1.right.right = TreeNode(7)
    print(sol.isBalanced(root1))  # Expected: True
    
    # Example 2: root = [1,2,2,3,3,null,null,4,4]
    root2 = TreeNode(1)
    root2.left = TreeNode(2)
    root2.right = TreeNode(2)
    root2.left.left = TreeNode(3)
    root2.left.right = TreeNode(3)
    root2.left.left.left = TreeNode(4)
    root2.left.left.right = TreeNode(4)
    print(sol.isBalanced(root2))  # Expected: False
    
    # Example 3: root = []
    root3 = None
    print(sol.isBalanced(root3))  # Expected: True