# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next or k == 0:
            return head

        # Step 1: find length and tail
        n = 1
        tail = head
        while tail.next:
            tail = tail.next
            n += 1

        # Step 2: reduce k
        k %= n
        if k == 0:
            return head

        # Step 3: make circular
        tail.next = head

        # Step 4: find new tail
        steps = n - k
        new_tail = head
        for _ in range(steps - 1):
            new_tail = new_tail.next

        # Step 5: break
        new_head = new_tail.next
        new_tail.next = None

        return new_head


# Test cases
if __name__ == "__main__":
    from typing import Optional
    
    # Helper function to create linked list from array
    def create_linked_list(arr):
        if not arr:
            return None
        head = ListNode(arr[0])
        current = head
        for val in arr[1:]:
            current.next = ListNode(val)
            current = current.next
        return head
    
    # Helper function to convert linked list to array
    def linked_list_to_array(head):
        result = []
        current = head
        while current:
            result.append(current.val)
            current = current.next
        return result
    
    solution = Solution()
    
    # Example 1
    head1 = create_linked_list([1, 2, 3, 4, 5])
    result1 = solution.rotateRight(head1, 2)
    output1 = linked_list_to_array(result1)
    print(f"Example 1: Input: head = [1,2,3,4,5], k = 2")
    print(f"Output: {output1}")
    print(f"Expected: [4,5,1,2,3]\n")
    
    # Example 2
    head2 = create_linked_list([0, 1, 2])
    result2 = solution.rotateRight(head2, 4)
    output2 = linked_list_to_array(result2)
    print(f"Example 2: Input: head = [0,1,2], k = 4")
    print(f"Output: {output2}")
    print(f"Expected: [2,0,1]")