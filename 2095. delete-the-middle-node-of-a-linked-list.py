from typing import Optional


class ListNode:
    def __init__(self, val: int = 0, next: 'ListNode' = None):
        self.val = val
        self.next = next


class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head.next:
            return None

        slow = head
        fast = slow.next.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        slow.next = slow.next.next
        return head


def build_list(arr: list[int]) -> Optional[ListNode]:
    if not arr:
        return None
    head = ListNode(arr[0])
    cur = head
    for v in arr[1:]:
        cur.next = ListNode(v)
        cur = cur.next
    return head


def to_list(head: Optional[ListNode]) -> list[int]:
    res = []
    cur = head
    while cur:
        res.append(cur.val)
        cur = cur.next
    return res


if __name__ == "__main__":
    sol = Solution()

    # Example 1
    head1 = build_list([1,3,4,7,1,2,6])
    out1 = sol.deleteMiddle(head1)
    print(f"Example 1: Input: [1,3,4,7,1,2,6]")
    print(f"Output: {to_list(out1)}")
    print(f"Expected: [1,3,4,1,2,6]")
    print()

    # Example 2
    head2 = build_list([1,2,3,4])
    out2 = sol.deleteMiddle(head2)
    print(f"Example 2: Input: [1,2,3,4]")
    print(f"Output: {to_list(out2)}")
    print(f"Expected: [1,2,4]")
    print()

    # Example 3
    head3 = build_list([2,1])
    out3 = sol.deleteMiddle(head3)
    print(f"Example 3: Input: [2,1]")
    print(f"Output: {to_list(out3)}")
    print(f"Expected: [2]")