from typing import Optional


class ListNode:
    def __init__(self, val: int = 0, next: 'ListNode' = None):
        self.val = val
        self.next = next


class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        res, left = 0, head

        def dfs(right):
            nonlocal res, left
            if right.next:
                dfs(right.next)
            res = max(res, left.val + right.val)
            left = left.next

        dfs(head)
        return res


def build_list(arr: list[int]) -> Optional[ListNode]:
    if not arr:
        return None
    head = ListNode(arr[0])
    cur = head
    for v in arr[1:]:
        cur.next = ListNode(v)
        cur = cur.next
    return head


if __name__ == "__main__":
    sol = Solution()

    # Example 1
    head1 = build_list([5,4,2,1])
    out1 = sol.pairSum(head1)
    print(f"Example 1: head=[5,4,2,1]")
    print(f"Output: {out1}")
    print(f"Expected: 6")
    print()

    # Example 2
    head2 = build_list([4,2,2,3])
    out2 = sol.pairSum(head2)
    print(f"Example 2: head=[4,2,2,3]")
    print(f"Output: {out2}")
    print(f"Expected: 7")
    print()

    # Example 3
    head3 = build_list([1,100000])
    out3 = sol.pairSum(head3)
    print(f"Example 3: head=[1,100000]")
    print(f"Output: {out3}")
    print(f"Expected: 100001")