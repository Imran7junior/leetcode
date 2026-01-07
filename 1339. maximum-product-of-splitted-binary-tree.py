from collections import deque
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        MOD = 10**9 + 7

        def dfs(node):
            if not node:
                return 0
            
            node.val += dfs(node.left) + dfs(node.right)
            return node.val

        total = dfs(root)

        ans = 0
        q = deque([root])

        while q:
            node = q.popleft()
            if not node:
                continue

            
            current_product = (total - node.val) * node.val
            ans = max(ans, current_product)

            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)

        return ans % MOD


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
    
    # Test case 1: root = [1,null,2,3,4,null,null,5,6]
    # Expected output: 90
    root1 = build_tree([1, None, 2, 3, 4, None, None, 5, 6])
    result1 = sol.maxProduct(root1)
    print(f"Test 1: {result1}")
    assert result1 == 90, f"Expected 90, got {result1}"
    
    # Test case 2: root = [1,2,3,4,5,6]
    # Expected output: 110
    root2 = build_tree([1, 2, 3, 4, 5, 6])
    result2 = sol.maxProduct(root2)
    print(f"Test 2: {result2}")
    assert result2 == 110, f"Expected 110, got {result2}"
    
    print("All test cases passed!")
