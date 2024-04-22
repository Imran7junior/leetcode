#
# @lc app=leetcode id=1171 lang=python3
#
# [1171] Remove Zero Sum Consecutive Nodes from Linked List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
""" class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        front = ListNode(0, head)
        start = front

        while start is not None:
            prefix_sum = 0
            end = start.next

            while end is not None:
                # Add end's value to the prefix sum
                prefix_sum += end.val
                # Delete zero sum consecutive sequence 
                # by setting node before sequence to node after
                if prefix_sum == 0:
                    start.next = end.next
                end = end.next

            start = start.next

        return front.next """
class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        prefix_sum = 0
        prefix_sums = {0: dummy}
        current = head

        while current:
            prefix_sum += current.val
            if prefix_sum in prefix_sums:
                to_delete = prefix_sums[prefix_sum].next
                temp_sum = prefix_sum + to_delete.val
                while to_delete != current:
                    del prefix_sums[temp_sum]
                    to_delete = to_delete.next
                    temp_sum += to_delete.val
                prefix_sums[prefix_sum].next = current.next
            else:
                prefix_sums[prefix_sum] = current
            current = current.next

        return dummy.next
# @lc code=end

