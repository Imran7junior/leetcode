class TreeNode:
	def __init__(self, val=0, left=None, right=None):
		self.val = val
		self.left = left
		self.right = right
class Solution:
    def inorder(self, node, vals):
        if not node:
            return
        self.inorder(node.left, vals)
        vals.append(node.val)
        self.inorder(node.right, vals)

    def build(self, vals, l, r):
        if l > r:
            return None
        mid  = (l + r) // 2
        node = TreeNode(vals[mid])
        node.left  = self.build(vals, l, mid - 1)
        node.right = self.build(vals, mid + 1, r)
        return node

    def balanceBST(self, root):
        vals = []
        self.inorder(root, vals)
        return self.build(vals, 0, len(vals) - 1)


def level_order(root):
    if not root:
        return []
    result = []
    queue = [root]
    while queue:
        node = queue.pop(0)
        if node:
            result.append(node.val)
            queue.append(node.left)
            queue.append(node.right)
        else:
            result.append(None)
    # Remove trailing None values
    while result and result[-1] is None:
        result.pop()
    return result


if __name__ == "__main__":
    sol = Solution()
    
    # Example 1: root = [1,null,2,null,3,null,4,null,null]
    root1 = TreeNode(1)
    root1.right = TreeNode(2)
    root1.right.right = TreeNode(3)
    root1.right.right.right = TreeNode(4)
    balanced1 = sol.balanceBST(root1)
    print(level_order(balanced1))  # Expected: [2,1,3,null,null,null,4] or [3,1,4,null,2]
    
    # Example 2: root = [2,1,3]
    root2 = TreeNode(2)
    root2.left = TreeNode(1)
    root2.right = TreeNode(3)
    balanced2 = sol.balanceBST(root2)
    print(level_order(balanced2))  # Expected: [2,1,3]