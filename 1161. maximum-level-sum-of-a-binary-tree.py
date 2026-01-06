
from collections import deque
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        curr_lvl = 1
        maxi = float('-inf')
        ans = 1

        queue = deque([root])

        while queue:
            curr_sum = 0
            lvl_size = len(queue)

            for _ in range(lvl_size):
                node = queue.popleft()
                curr_sum += node.val

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            if curr_sum > maxi:
                maxi = curr_sum
                ans = curr_lvl

            curr_lvl += 1
        
        return ans


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
    solution = Solution()
    
    # Example 1: root = [1,7,0,7,-8,null,null]
    # Level 1 sum = 1
    # Level 2 sum = 7 + 0 = 7
    # Level 3 sum = 7 + -8 = -1
    # Expected output: 2
    root1 = build_tree([1, 7, 0, 7, -8, None, None])
    result1 = solution.maxLevelSum(root1)
    print(f"Example 1: {result1}")
    assert result1 == 2, f"Expected 2, got {result1}"
    
    # Example 2: root = [989,null,10250,98693,-89388,null,null,null,-32127]
    # Expected output: 2
    root2 = build_tree([989, None, 10250, 98693, -89388, None, None, None, -32127])
    result2 = solution.maxLevelSum(root2)
    print(f"Example 2: {result2}")
    assert result2 == 2, f"Expected 2, got {result2}"
    
    print("All test cases passed!")
