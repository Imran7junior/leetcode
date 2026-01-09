from collections import deque

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def subtreeWithAllDeepest(self, root):
        def dfs(node):
            if not node:
                return (None, 0)

            ln, ld = dfs(node.left)
            rn, rd = dfs(node.right)

            if ld > rd:
                return (ln, ld + 1)
            elif ld < rd:
                return (rn, rd + 1)
            else:
                return (node, ld + 1)

        return dfs(root)[0]


# Helper function to build tree from level-order list
def build_tree(values):
    if not values:
        return None
    
    root = TreeNode(values[0])
    queue = deque([root])
    i = 1
    
    while queue and i < len(values):
        node = queue.popleft()
        
        if i < len(values) and values[i] is not None:
            node.left = TreeNode(values[i])
            queue.append(node.left)
        i += 1
        
        if i < len(values) and values[i] is not None:
            node.right = TreeNode(values[i])
            queue.append(node.right)
        i += 1
    
    return root


# Test cases
if __name__ == "__main__":
    sol = Solution()
    
    # Test case 1: root = [3,5,1,6,2,0,8,null,null,7,4]
    root1 = build_tree([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4])
    result1 = sol.subtreeWithAllDeepest(root1)
    print(f"Test 1 - Result node value: {result1.val if result1 else None}")
    
    # Test case 2: root = [1]
    root2 = build_tree([1])
    result2 = sol.subtreeWithAllDeepest(root2)
    print(f"Test 2 - Result node value: {result2.val if result2 else None}")
    
    # Test case 3: root = [0,1,3,null,2]
    root3 = build_tree([0, 1, 3, None, 2])
    result3 = sol.subtreeWithAllDeepest(root3)
    print(f"Test 3 - Result node value: {result3.val if result3 else None}")
    
    print("All test cases executed!")
