class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode slow = head;
        ListNode fast = slow.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static ListNode build(int[] vals) {
        ListNode head = new ListNode(vals[0]);
        ListNode cur = head;
        for (int i = 1; i < vals.length; i++) {
            cur.next = new ListNode(vals[i]);
            cur = cur.next;
        }
        return head;
    }

    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(",");
            head = head.next;
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(listToString(sol.deleteMiddle(build(new int[]{1,3,4,7,1,2,6})))); // [1,3,4,1,2,6]
        System.out.println(listToString(sol.deleteMiddle(build(new int[]{1,2,3,4}))));        // [1,2,4]
        System.out.println(listToString(sol.deleteMiddle(build(new int[]{2,1}))));            // [2]
    }
}