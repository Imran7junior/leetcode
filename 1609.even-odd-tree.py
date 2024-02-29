#
# @lc app=leetcode id=1609 lang=python3
#
# [1609] Even Odd Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
	def isEvenOddTree(self, root: Optional[TreeNode]) -> bool:
		even = True
		q = deque([root])
		
		while q:
			prev = float("-inf") if even else float("inf")
			for _ in range(len(q)):
				node = q.popleft()
				
				if even:
					if even and node.val % 2 == 0 or node.val <= prev:
						return False
				else:
					if not even and (node.val % 2 == 1 or node.val >= prev):
						return False
				if node.left:
					q.append(node.left)
				if node.right:
					q.append(node.right)
				prev = node.val
				
			even = not even
		return True
# @lc code=end

