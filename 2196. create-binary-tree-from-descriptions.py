from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def createBinaryTree(self, descriptions: list[list[int]]) -> Optional[TreeNode]:
        def construct_tree(cur_node_val):
            new_node = TreeNode(cur_node_val)
            if cur_node_val in children_hashmap:
                if children_hashmap[cur_node_val][0] is not None:
                    new_node.left = construct_tree(children_hashmap[cur_node_val][0])
                if children_hashmap[cur_node_val][1] is not None:
                    new_node.right = construct_tree(children_hashmap[cur_node_val][1])
            return new_node

        children_set = set()
        children_hashmap: dict[int, list[int]] = {}

        for parent, child, isleft in descriptions:
            if not parent in children_hashmap:
                children_hashmap[parent] = [None, None]  # left and right
            children_set.add(child)
            target = 0 if isleft else 1
            children_hashmap[parent][target] = child

        for parent in children_hashmap:
            if parent not in children_set:
                head_node_val: int = parent
                break
        head = construct_tree(head_node_val)
        return head

if __name__ == "__main__":
    sol = Solution()
    
    def levelOrder(root):
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
        return result
    
    # Example 1
    descriptions1 = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
    root1 = sol.createBinaryTree(descriptions1)
    output1 = levelOrder(root1)
    print(f"Example 1: descriptions={descriptions1}")
    print(f"Output: {output1}")
    print(f"Expected: [50,20,80,15,17,19]")
    print()
    
    # Example 2
    descriptions2 = [[1,2,1],[2,3,0],[3,4,1]]
    root2 = sol.createBinaryTree(descriptions2)
    output2 = levelOrder(root2)
    print(f"Example 2: descriptions={descriptions2}")
    print(f"Output: {output2}")
    print(f"Expected: [1,2,None,None,3,4]")