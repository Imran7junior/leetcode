from collections import deque
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        
        # BFS
        queue = deque([root])
        
        # set the root node value to 0 as it can't have cousins
        root.val = 0
        
        while queue:
            level_size = len(queue)
            current_level = []
            child_sum_map = {}  # store sum of children for each parent
            
            # collect nodes of the current level and calculate total sum of the level
            total_sum = 0
            for _ in range(level_size):
                node = queue.popleft()
                current_level.append(node)
                
                # calculate the sum of children for each node
                child_sum = 0
                if node.left:
                    child_sum += node.left.val
                    queue.append(node.left)
                if node.right:
                    child_sum += node.right.val
                    queue.append(node.right)
                
                # add the node's children sum to the total sum of the level
                total_sum += child_sum
                child_sum_map[node] = child_sum

            # update each node's children values based on the total sum and its sibling sum
            for node in current_level:
                sibling_sum = child_sum_map[node]
                if node.left:
                    node.left.val = total_sum - sibling_sum
                if node.right:
                    node.right.val = total_sum - sibling_sum
        
        return root

# Testing stuff
# tree from list
def build_tree_from_list(values: List[Optional[int]]) -> Optional[TreeNode]:
    if not values:
        return None
    root = TreeNode(values[0])
    queue = deque([root])
    i = 1
    while i < len(values):
        current = queue.popleft()
        if values[i] is not None:
            current.left = TreeNode(values[i])
            queue.append(current.left)
        i += 1
        if i < len(values) and values[i] is not None:
            current.right = TreeNode(values[i])
            queue.append(current.right)
        i += 1
    return root

# create list from tree
def tree_to_list(root: Optional[TreeNode]) -> List[Optional[int]]:
    if not root:
        return []
    result = []
    queue = deque([root])
    while queue:
        node = queue.popleft()
        if node:
            result.append(node.val)
            queue.append(node.left)
            queue.append(node.right)
        else:
            result.append(None)
    
    while result and result[-1] is None:
        result.pop()
    
    return result

# Test the solution using the given test case
def test_replace_value_in_tree():
    solution = Solution()

    input_tree = [5, 4, 9, 1, 10, None, 7]
    expected_output = [0, 0, 0, 7, 7, None, 11]

    root = build_tree_from_list(input_tree)

    modified_root = solution.replaceValueInTree(root)

    output_tree = tree_to_list(modified_root)

    # match the output to expected
    print(f"Output: {output_tree}")
    print(f"Expected: {expected_output}")
    assert output_tree == expected_output, f"Test failed: got {output_tree}, expected {expected_output}"
    print("Test passed!")

# Run the test
test_replace_value_in_tree()
