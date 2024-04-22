# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode):
        empty = ListNode()
        cur = empty
        carry = 0
        while l1 or l2:
            v1 = l1.val if l1 else 0
            v2 = l2.val if l2 else 0
            
            #new digit
            val = v1 + v2 + carry
            #12
            carry = val//10
            val = val % 10
            cur.next = ListNode(val)
            
            #update pointers
            cur = cur.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        #carryover case3
        if carry== 1: cur.next = ListNode(1)
        
        return empty.next